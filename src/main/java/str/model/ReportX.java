package str.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportX {

	/**
	 * Файл отчета
	 */
	private File file;

	/**
	 * Книга
	 */
	private XSSFWorkbook workbook;

	public ReportX(File file) throws IOException {
		this.file = file;
		if (!file.exists()) {
			throw new IOException();
		}
		FileInputStream is = new FileInputStream(file);
		workbook = new XSSFWorkbook(is);
	}

	/**
	 * Запись файла
	 */
	public void write() {
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String[]> getRows() {
		Iterator<Row> iter = workbook.getSheetAt(0).rowIterator();
		List<String[]> rows = new ArrayList<String[]>();

		iter.next();
		while (iter.hasNext()) {
			Row row = iter.next();
			Iterator<Cell> iterCell = row.cellIterator();
			List<String> cells = new ArrayList<String>();
			while (iterCell.hasNext()) {
				cells.add(iterCell.next().getStringCellValue());
			}

			rows.add(cells.toArray(new String[cells.size()]));
		}

		return rows;
	}

}
