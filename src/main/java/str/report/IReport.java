package str.report;

import java.util.LinkedList;

public interface IReport {

	/**
	 * Записать файл
	 */
	void write();

	/**
	 * Получить все значения
	 * 
	 * @return значения
	 */
	LinkedList<String[]> getRows();

}
