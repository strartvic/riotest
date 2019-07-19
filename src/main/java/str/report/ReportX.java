package str.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportX implements IReport {

	/**
	 * Файл отчета
	 */
	private File file;

	/**
	 * Книга
	 */
	private XSSFWorkbook workbook;

	public ReportX(String filePath) throws IOException {
		this.file = new File(filePath);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
			workbook = new XSSFWorkbook();
			workbook.createSheet();
			return;
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

	@Override
	public LinkedList<String[]> getRows() {
		Iterator<Row> iter = workbook.getSheetAt(0).rowIterator();
		LinkedList<String[]> rows = new LinkedList<String[]>();

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
					cells.add(Integer.toString((int) cell.getNumericCellValue()));
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

	@Override
	public void addRows(LinkedList<String[]> values) {
		XSSFSheet sheet = workbook.getSheetAt(0);
		int i = 0;
		for (String[] cells : values) {
			XSSFRow row = sheet.createRow(i);
			int j = 0;
			for (String cell : cells) {
				row.createCell(j).setCellValue(cell);
				j++;
			}
			i++;
		}
	}

	@Override
	public void addRow(String[] values) {
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.createRow(sheet.getLastRowNum());
		int j = 0;
		for (String cell : values) {
			row.createCell(j).setCellValue(cell);
			j++;
		}
	}
}
