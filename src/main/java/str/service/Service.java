package str.service;

import java.util.List;

import str.dao.Dao;
import str.model.CreditOrg;

public class Service implements IService {

	private Dao orgCrud = new Dao();

	@Override
	public List<CreditOrg> getAll() {
		return orgCrud.getAll();
	}

	@Override
	public void save(Object obj) {
		orgCrud.save(obj);
	}

	@Override
	public void update(Object obj) {
		orgCrud.update(obj);
	}

	@Override
	public void delete(Object obj) {
		orgCrud.delete(obj);
	}

	@Override
	public CreditOrg getById(Integer id) {
		return orgCrud.getById(id);
	}
}
