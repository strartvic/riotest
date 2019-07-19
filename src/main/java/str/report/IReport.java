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

	/**
	 * Добавить значения
	 * 
	 * @param values значения
	 */
	void addRows(LinkedList<String[]> values);

	/**
	 * Добавить строку
	 * 
	 * @param values значения
	 */
	void addRow(String[] values);

}
