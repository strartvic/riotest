package str.dao;

import java.util.List;

public interface IDao {

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
	 * @param org объект
	 */
	<T> void update(T org);

	/**
	 * Получить все организации
	 * 
	 * @return организации
	 */
	<T> List<T> getAll(Class<?> T);

	/**
	 * Получить организацию по id
	 * 
	 * @param id уник номер
	 * @return организация
	 */
	<T> T getById(Class<?> T, Integer id);

}
