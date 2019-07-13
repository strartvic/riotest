package str.dao;

import java.util.List;

import str.model.CreditOrg;

public interface IDao {

	/**
	 * Сохранить объект
	 * 
	 * @param org объект
	 */
	void save(CreditOrg org);

	/**
	 * Обновить
	 * 
	 * @param org объект
	 */
	void update(CreditOrg org);

	/**
	 * Получить все организации
	 * 
	 * @return организации
	 */
	List<CreditOrg> getAll();

}
