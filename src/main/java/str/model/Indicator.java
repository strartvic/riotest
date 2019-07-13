package str.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "indicators")
public class Indicator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Входящие остатки в руб
	 */
	@Column(name = "incom_bal_rub")
	private Integer incomingBalanceRub;

	/**
	 * Кредитная организация
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_org_id")
	private CreditOrg creditOrg;

	/**
	 * Счет
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id")
	private Bill bill;

	public Indicator() {

	}

	/**
	 * Конструктор
	 * 
	 * @param creditOrg          организация
	 * @param incomingBalanceRub Входящие остатки в руб
	 */
	public Indicator(int incomingBalanceRub) {
		this.incomingBalanceRub = incomingBalanceRub;
	}

	public int getIncomingBalanceRub() {
		return incomingBalanceRub;
	}

	public void setIncomingBalanceRub(int incomingBalanceRub) {
		this.incomingBalanceRub = incomingBalanceRub;
	}

	public CreditOrg getCreditOrg() {
		return creditOrg;
	}

	public void setCreditOrg(CreditOrg creditOrg) {
		this.creditOrg = creditOrg;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
