package str.service;

import java.util.List;

import str.dao.Dao;
import str.model.Bill;
import str.model.CreditOrg;
import str.model.Indicator;

public class Service {

	/**
	 * Репозиторий организаций
	 */
	private Dao orgCrud = new Dao();

	public List<CreditOrg> getAll() {
		return orgCrud.getAll();
	}

	public void save(CreditOrg org) {
		orgCrud.save(org);
	}

	public void save(Bill bill) {
		orgCrud.save(bill);
	}

	public List<Indicator> getIndicators(CreditOrg org) {
		return org.getIndicators();
	}

	public void update(CreditOrg org) {
		orgCrud.update(org);
	}
}
