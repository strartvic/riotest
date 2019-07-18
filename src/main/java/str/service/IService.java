package str.service;

import java.util.LinkedList;
import java.util.List;

import str.model.Bill;
import str.model.CreditOrg;

public interface IService {

	/**
	 * Сохранить объект
	 * 
	 * @param obj объект
	 */
	<T> void save(T obj);

	/**
	 * Удалить
	 * 
	 * @param obj объект
	 */
	<T> void delete(T obj);

	/**
	 * Обновить
	 * 
	 * @param obj объект
	 */
	<T> void update(T obj);

	/**
	 * Получить все объекты
	 * 
	 * @return организации
	 */
	<T> List<T> getAll(Class<?> T);

	/**
	 * Получить объект по id
	 * 
	 * @param id уник номер
	 * @return объект
	 */
	<T> T getById(Class<?> T, Integer id);

	/**
	 * Сохранить данные в БД из архива
	 * 
	 * @param zipFile путь до архива
	 */
	void save(String zipFile);

	void printReport(String dirPath, LinkedList<CreditOrg> orgs, LinkedList<Bill> bills);
}
