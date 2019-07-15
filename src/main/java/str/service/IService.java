package str.service;

import java.util.List;

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
	 * Сохранить данныие из файлов
	 * 
	 * @param path1 путь1
	 * @param path2 путь2
	 * @param path3 путь3
	 */
	void save(String path1, String path2, String path3);
}
