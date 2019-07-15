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
		session.beginTransaction();
		session.save(obj); // пользуемся ее методами
		session.flush();
		session.close();
	}

	@Override
	public <T> void delete(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(obj);
		session.flush();
		session.close();
	}

	@Override
	public <T> List<T> getAll(Class<?> T) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String str = T.getSimpleName();
		List<T> obj = (List<T>) session.createQuery("From " + T.getSimpleName()).getResultList();
		return obj;
	}

	@Override
	public <T> T getById(Class<?> T, Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T obj = (T) session.get(T, id);
		return obj;
	}

	@Override
	public <T> void update(T obj) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // открываем сессию
		session.beginTransaction();
		session.merge(obj); // пользуемся ее методами
		session.flush();
		session.close();
	}
}
