package str.dao;

import java.util.List;

import org.hibernate.Session;

import str.config.HibernateUtil;
import str.model.Bill;
import str.model.CreditOrg;

public class Dao implements IDao {

	@Override
	public void save(CreditOrg org) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.save(org); // пользуемся ее методами
		session.flush();
		session.close();
	}

	public void save(Bill bill) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.save(bill); // пользуемся ее методами
		session.flush();
		session.close();
	}

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
		List<CreditOrg> orgs = (List<CreditOrg>) session.createQuery("From " + CreditOrg.class.toString())
				.getResultList();
		return orgs;
	}

	/**
	 * Получить организацию по id
	 * 
	 * @param id уник номер
	 * @return организация
	 */
	public CreditOrg getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CreditOrg org = session.get(CreditOrg.class, id);
		return org;
	}

	@Override
	public void update(CreditOrg org) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.merge(org); // пользуемся ее методами
		session.flush();
		session.close();
	}
}
