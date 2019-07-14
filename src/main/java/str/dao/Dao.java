package str.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import str.config.HibernateUtil;
import str.model.Bill;
import str.model.CreditOrg;

@Repository
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
	public List<Bill> getAllBills() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Bill> orgs = (List<Bill>) session.createQuery("From Bill").getResultList();
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

	@Override
	public Bill getBill(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Bill bill = session.get(Bill.class, id);
		return bill;
	}
}
