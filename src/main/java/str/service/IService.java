package str.service;

import java.util.LinkedList;
import java.util.List;

import str.model.Bill;
import str.model.CreditOrg;
import str.model.Indicator;

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
	 * Получить объекты по id
	 * 
	 * @param <T> параметр
	 * @param T   класс
	 * @param id  массив id
	 * @return список объектов
	 */
	<T> LinkedList<T> getById(Class<?> T, int[] id);

	/**
	 * Сохранить данные в БД из архива
	 * 
	 * @param zipFile путь до архива
	 */
	void save(String zipFile);

	/**
	 * Получить общие показатели
	 * 
	 * @param orgs  организации
	 * @param bills счета
	 * @return показатели
	 */
	LinkedList<Indicator> getRetainIndicators(List<CreditOrg> orgs, List<Bill> bills);
}
