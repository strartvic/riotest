package str.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class Report {

	/**
	 * Файл отчета
	 */
	private File file;

	/**
	 * Книга
	 */
	private HSSFWorkbook workbook;

	public Report(File file) throws IOException {
		this.file = file;
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		workbook = new HSSFWorkbook(fs);
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

	/**
	 * Получить книгу
	 * 
	 * @return
	 */
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	/**
	 * Получить значения всех строк
	 * 
	 * @return значения строк
	 */
	public List<String[]> getRows() {
		Iterator<Row> iter = workbook.getSheetAt(0).rowIterator();
		List<String[]> rows = new ArrayList<String[]>();

		iter.next();
		while (iter.hasNext()) {
			Row row = iter.next();
			Iterator<Cell> iterCell = row.cellIterator();
			List<String> cells = new ArrayList<String>();
			while (iterCell.hasNext()) {
				Cell cell = iterCell.next();
				CellType type = cell.getCellType();
				switch (type.toString()) {
				case "NUMERIC":
					cells.add(Double.toString(cell.getNumericCellValue()));
					break;
				case "STRING":
					cells.add(cell.getStringCellValue());
					break;
				}
			}

			rows.add(cells.toArray(new String[cells.size()]));
		}

		return rows;
	}

}