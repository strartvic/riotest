package str.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import str.dao.IDao;
import str.model.CreditOrg;

@org.springframework.stereotype.Service
public class Service implements IService {

	private IDao dao;

	@Autowired
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public List<CreditOrg> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(Object obj) {
		dao.save(obj);
	}

	@Override
	public void update(Object obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Object obj) {
		dao.delete(obj);
	}

	@Override
	public CreditOrg getById(Integer id) {
		return dao.getById(id);
	}

}
