package str.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Autowired;

import str.dao.IDao;
import str.model.Bill;
import str.model.CreditOrg;
import str.model.Indicator;
import str.report.Report;
import str.report.ReportFactory;

@org.springframework.stereotype.Service
public class Service implements IService {

	private IDao dao;

	@Autowired
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public <T> List<T> getAll(Class<?> T) {
		return dao.getAll(T);
	}

	@Override
	public <T> void save(T obj) {
		dao.save(obj);
	}

	@Override
	public <T> void update(T obj) {
		dao.update(obj);
	}

	@Override
	public <T> void delete(T obj) {
		dao.delete(obj);
	}

	@Override
	public <T> T getById(Class<?> T, Integer id) {
		return dao.getById(T, id);
	}

	@Override
	public void save(String zipFile) {
		File[] files = unpackZip(zipFile, zipFile.substring(0, zipFile.lastIndexOf("\\")));
		if (files == null) {
			return;
		}

		LinkedList<String[]> orgData = getData(getFile(files, "092018N1"));
		LinkedList<String[]> billData = getData(getFile(files, "NAMES"));
		LinkedList<String[]> indData = getData(getFile(files, "092018B1"));

		// Сохранение организаций
		for (String[] props : orgData) {
			try {
				dao.save(new CreditOrg(props));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("Завершена передача организаций!");

		// Сохранение счетов
		for (String[] props : billData) {
			try {
				dao.save(new Bill(props));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("Завершена передача счетов!");

		// Сохранение показателей
		for (String[] props : indData) {
			try {
				Indicator ind = new Indicator(Arrays.copyOfRange(props, 2, props.length));
				ind.setCreditOrg(dao.getById(CreditOrg.class, Integer.parseInt(props[0])));
				ind.setBill(dao.getById(Bill.class, Integer.parseInt(props[1])));
				dao.save(ind);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("Завершена передача показателей!");
	}

	/**
	 * Получить файл по имени
	 * 
	 * @param files    файлы
	 * @param fileName имя искомого
	 * @return файл
	 */
	private File getFile(File[] files, String fileName) {
		for (File file : files) {
			String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
			if (fileName.equalsIgnoreCase(name)) {
				return file;
			}
		}
		return null;
	}

	/**
	 * Получить данные из файла
	 * 
	 * @param file файл
	 * @return данные
	 */
	private LinkedList<String[]> getData(File file) {
		if (file == null) {
			return null;
		}
		LinkedList<String[]> list = ReportFactory.getReport(file.getAbsolutePath()).getRows();
		list.removeFirst();
		return list;
	}

	@Override
	public void printReport(String dirPath, LinkedList<CreditOrg> orgs, LinkedList<Bill> bills) {
		if (dirPath.isEmpty() || orgs.isEmpty()) {
			return;
		}

		LinkedList<Indicator> inds1 = new LinkedList<Indicator>();
		LinkedList<Indicator> inds2 = new LinkedList<Indicator>();

		for (CreditOrg org : orgs) {
			inds1.addAll(org.getIndicators());
		}

		for (Bill bill : bills) {
			inds2.addAll(bill.getIndicators());
		}

		if (!inds2.isEmpty()) {
			inds2.retainAll(inds1);
		}

		try {
			Report rep = new Report("D:\\Отчет.xls");
		} catch (IOException e) {
			System.out.print("Ошибка создания отчета!");
			e.printStackTrace();
		}
	}

	/**
	 * Распаковка zip файла
	 * 
	 * @param filePath   файл zip
	 * @param unpackPath путь до дериктории распаковки
	 */
	public static File[] unpackZip(String filePath, String unpackPath) {
		File zipFile = new File(filePath);
		if (!filePath.toLowerCase().endsWith(".zip") || (!zipFile.exists()) || (unpackPath == null)
				|| (unpackPath.isEmpty())) {
			return null;
		}

		File unpackDir = new File(unpackPath);
		unpackDir.mkdirs();
		List<File> unpackFiles = new ArrayList<File>();
		try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFile), Charset.forName("CP866"))) {

			ZipEntry entry;
			while ((entry = zip.getNextEntry()) != null) {
				String name = entry.getName();
				int i = name.indexOf("\\");

				if (i != -1) {
					File dir = new File(unpackPath + "\\" + name.substring(0, i));
					dir.mkdirs();
				}

				File unpackFile = new File(unpackPath + "\\" + name);
				unpackFiles.add(unpackFile);
				FileOutputStream fout = new FileOutputStream(unpackFile);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = zip.read(buffer)) >= 0) {
					fout.write(buffer, 0, length);
				}
				fout.flush();
				zip.closeEntry();
				fout.close();
			}
			return unpackFiles.toArray(new File[unpackFiles.size()]);
		} catch (IOException ex) {
			System.out.println("Ошибка распаковки");
			return null;
		}
	}
}
