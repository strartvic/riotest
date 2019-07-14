package str.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import str.dao.IDao;
import str.model.Bill;
import str.model.CreditOrg;
import str.model.Report;

@org.springframework.stereotype.Service
public class Service implements IService {

	private IDao dao;

	@Autowired
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public List<CreditOrg> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(Object obj) {
		dao.save(obj);
	}

	@Override
	public void update(Object obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Object obj) {
		dao.delete(obj);
	}

	@Override
	public CreditOrg getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Bill> getAllBills() {
		return dao.getAllBills();
	}

	@Override
	public void save(String path1, String path2, String path3) {
		File file1 = new File(path1);
		File file2 = new File(path2);
		File file3 = new File(path3);
		if (!file1.exists() || !file2.exists() || !file3.exists()) {
			return;
		}

		try {
			List<String[]> data1 = new Report(file1).getRows();
			List<String[]> data2 = new Report(file2).getRows();
			List<String[]> data3 = new Report(file3).getRows();

			// Сохранение организаций
			for (String[] props : data1) {
				try {
					dao.save(new CreditOrg(props));
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
			System.out.print("Завершена передача организаций!");

			// Сохранение счетов
			for (String[] props : data2) {
				try {
					dao.save(new Bill(props));
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
			System.out.print("Завершена передача счетов!");

			// Сохранение показателей
			for (String[] props : data3) {
				try {
					dao.save(new Bill(props));
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
			System.out.print("Завершена передача показателей!");

		} catch (IOException e) {
			System.out.print("Ошибка загрузки данных!");
			e.printStackTrace();
		}
	}
}
