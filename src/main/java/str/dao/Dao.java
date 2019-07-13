package str.dao;

import java.util.List;

import org.hibernate.Session;

import str.config.HibernateUtil;
import str.model.CreditOrg;

public class Dao implements IDao {

	@Override
	public void save(Object obj) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.save(obj); // пользуемся ее методами
		session.flush();
		session.close();
	}

	@Override
	public void delete(Object obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(obj);
		session.flush();
		session.close();
	}

	@Override
	public List<CreditOrg> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CreditOrg> orgs = (List<CreditOrg>) session.createQuery("From CreditOrg").getResultList();
		return orgs;
	}

	@Override
	public CreditOrg getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CreditOrg org = session.get(CreditOrg.class, id);
		return org;
	}

	@Override
	public void update(Object org) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.merge(org); // пользуемся ее методами
		session.flush();
		session.close();
	}
}
