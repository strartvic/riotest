package str.service;

import java.util.List;

import str.model.Bill;
import str.model.CreditOrg;

public interface IService {

	/**
	 * Сохранить объект
	 * 
	 * @param obj объект
	 */
	void save(Object obj);

	/**
	 * Удалить
	 * 
	 * @param obj объект
	 */
	void delete(Object obj);

	/**
	 * Обновить
	 * 
	 * @param org объект
	 */
	void update(Object org);

	/**
	 * Получить все организации
	 * 
	 * @return организации
	 */
	List<CreditOrg> getAll();

	/**
	 * Получить организацию по id
	 * 
	 * @param id уник номер
	 * @return организация
	 */
	CreditOrg getById(Integer id);

	List<Bill> getAllBills();

	/**
	 * Сохранить данныие из файлов
	 * 
	 * @param path1 путь1
	 * @param path2 путь2
	 * @param path3 путь3
	 */
	void save(String path1, String path2, String path3);

	Bill getBill(Integer id);
}
