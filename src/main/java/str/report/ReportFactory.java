package str.report;

import java.io.IOException;

public class ReportFactory {

	/**
	 * Получить отчет
	 * 
	 * @param filePath путь к файлу
	 * @return отчет
	 */
	public static IReport getReport(String filePath) {
		if (filePath == null || filePath.isEmpty()) {
			return null;
		}
		try {
			if (filePath.toLowerCase().endsWith(".xls")) {
				return new Report(filePath);
			} else if (filePath.toLowerCase().endsWith(".xlsx")) {
				return new ReportX(filePath);
			}
			return null;
		} catch (IOException e) {
			return null;
		}
	}

}
