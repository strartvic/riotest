package str.dao;

import java.util.List;

import str.model.Bill;
import str.model.CreditOrg;

public interface IDao {

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

	/**
	 * Получить счет из базы
	 * 
	 * @param id номер
	 * @return счет
	 */
	Bill getBill(Integer id);

	List<Bill> getAllBills();

}
