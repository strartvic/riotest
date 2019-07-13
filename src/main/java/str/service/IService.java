package str.service;

import java.util.List;

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
	public CreditOrg getById(Integer id);
}
