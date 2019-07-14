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

	/**
	 * Входящие остатки в руб
	 */
	@Column(name = "incom_bal_rub")
	private Integer incomingBalanceRub;

	/**
	 * Входящие остатки в другое
	 */
	@Column(name = "incom_bal_other")
	private Integer incomingBalanceOther;

	/**
	 * Входящие остатки в итого
	 */
	@Column(name = "incom_bal_total")
	private Integer incomingBalanceTotal;

	/**
	 * Исходящие остатки в руб
	 */
	@Column(name = "outcom_bal_rub")
	private Integer outcomingBalanceRub;

	/**
	 * Исходящие остатки в другое
	 */
	@Column(name = "outcom_bal_other")
	private Integer outcomingBalanceOther;

	/**
	 * Исходящие остатки в итого
	 */
	@Column(name = "outcom_bal_total")
	private Integer outcomingBalanceTotal;

	/**
	 * Обороты активные в руб
	 */
	@Column(name = "turnover_active_rub")
	private Integer turnoverActiveRub;

	/**
	 * Обороты активные в другое
	 */
	@Column(name = "turnover_active_other")
	private Integer turnoverActiveOther;

	/**
	 * Обороты активные в итого
	 */
	@Column(name = "turnover_active_total")
	private Integer turnoverActiveTotal;

	/**
	 * Обороты пассивные в руб
	 */
	@Column(name = "turnover_passive_rub")
	private Integer turnoverPassiveRub;

	/**
	 * Обороты пассивные в другое
	 */
	@Column(name = "turnover_passive_other")
	private Integer turnoverPassiveOther;

	/**
	 * Обороты пассивные в итого
	 */
	@Column(name = "turnover_passive_total")
	private Integer turnoverPassiveTotal;

	public Indicator() {

	}

	/**
	 * Конструктор
	 * 
	 * @param creditOrg          организация
	 * @param incomingBalanceRub Входящие остатки в руб
	 */
	public Indicator(int incomingBalanceRub, int incomingBalanceOther, int incomingBalanceTotal,
			int outcomingBalanceRub, int outcomingBalanceOther, int outcomingBalanceTotal, int turnoverActiveRub,
			int turnoverActiveOther, int turnoverActiveTotal, int turnoverPassiveRub, int turnoverPassiveOther,
			int turnoverPassiveTotal) {
		this.incomingBalanceRub = incomingBalanceRub;
		this.incomingBalanceOther = incomingBalanceOther;
		this.incomingBalanceTotal = incomingBalanceTotal;
		this.outcomingBalanceRub = outcomingBalanceRub;
		this.outcomingBalanceOther = outcomingBalanceOther;
		this.outcomingBalanceTotal = outcomingBalanceTotal;
		this.turnoverActiveRub = turnoverActiveRub;
		this.turnoverActiveOther = turnoverActiveOther;
		this.turnoverActiveTotal = turnoverActiveTotal;
		this.turnoverPassiveRub = turnoverPassiveRub;
		this.turnoverPassiveOther = turnoverPassiveOther;
		this.turnoverPassiveTotal = turnoverPassiveTotal;
	}

	/**
	 * Конструктор
	 * 
	 * @param properties свойства в виде строках
	 * @throws Exception
	 */
	public Indicator(String[] properties) throws Exception {
		if (properties.length > 12) {
			throw new Exception("Ошибка создания объекта показателей. Неверный формат входных данных!");
		}

		for (int i = 0; i < properties.length; i++) {
			switch (i) {
			case 0:
				incomingBalanceRub = Integer.parseInt(properties[i]);
				break;
			case 1:
				incomingBalanceOther = Integer.parseInt(properties[i]);
				break;
			case 2:
				incomingBalanceTotal = Integer.parseInt(properties[i]);
				break;
			case 3:
				turnoverActiveRub = Integer.parseInt(properties[i]);
				break;
			case 4:
				turnoverActiveOther = Integer.parseInt(properties[i]);
				break;
			case 5:
				turnoverActiveTotal = Integer.parseInt(properties[i]);
				break;
			case 6:
				turnoverPassiveRub = Integer.parseInt(properties[i]);
				break;
			case 7:
				turnoverPassiveOther = Integer.parseInt(properties[i]);
				break;
			case 8:
				turnoverPassiveTotal = Integer.parseInt(properties[i]);
				break;
			case 9:
				outcomingBalanceRub = Integer.parseInt(properties[i]);
				break;
			case 10:
				outcomingBalanceOther = Integer.parseInt(properties[i]);
				break;
			case 11:
				outcomingBalanceTotal = Integer.parseInt(properties[i]);
				break;
			}
		}
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
