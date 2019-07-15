package str.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import str.config.HibernateUtil;

@Repository
public class Dao implements IDao {

	@Override
	public <T> void save(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		try {
			session.beginTransaction();
			session.save(obj); // пользуемся ее методами
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public <T> void delete(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(obj);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getAll(Class<?> T) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<T> obj = (List<T>) session.createQuery("From " + T.getSimpleName()).getResultList();
			return obj;
		} catch (Exception e) {
			session.close();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getById(Class<?> T, Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			T obj = (T) session.get(T, id);
			return obj;
		} catch (Exception e) {
			session.close();
			return null;
		}
	}

	@Override
	public <T> void update(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(obj);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
