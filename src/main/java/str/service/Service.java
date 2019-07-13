package str.service;

import java.util.List;

import str.model.CreditOrg;
import str.model.Indicator;
import str.repository.CreditOrgCRUD;

public class Service {

	/**
	 * Репозиторий организаций
	 */
	private CreditOrgCRUD orgCrud = new CreditOrgCRUD();

	public List<CreditOrg> getAll() {
		return orgCrud.getAll();
	}

	public void save(CreditOrg org) {
		orgCrud.save(org);
	}

	public List<Indicator> getIndicators(CreditOrg org) {
		return org.getIndicators();
	}
}
