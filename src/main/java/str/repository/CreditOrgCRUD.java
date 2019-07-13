package str.repository;

import java.util.List;

import org.hibernate.Session;

import str.config.HibernateUtil;
import str.model.CreditOrg;

public class CreditOrgCRUD {

	/**
	 * Сохранить организацию
	 * 
	 * @param org организация
	 */
	public void save(CreditOrg org) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.save(org); // пользуемся ее методами
		session.flush();
		session.close();
	}

	/**
	 * Удалить организацию
	 * 
	 * @param org организация
	 */
	public void delete(CreditOrg org) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(org);
		session.flush();
		session.close();
	}

	/**
	 * Получить все организации
	 * 
	 * @return организации
	 */
	public List<CreditOrg> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createCriteria(CreditOrg.class).list();
	}

	/**
	 * Получить организацию по id
	 * 
	 * @param id уник номер
	 * @return организация
	 */
	public CreditOrg getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CreditOrg pos = session.get(CreditOrg.class, id);
		return pos;
	}
}
