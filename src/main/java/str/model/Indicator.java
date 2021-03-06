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
import javax.persistence.Transient;

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

	@Transient
	private static String[] inds;

	static {
		inds = new String[12];
		inds[0] = "Входящие остатки (руб)";
		inds[1] = "Входящие остатки (другое)";
		inds[2] = "Входящие остатки (всего)";

		inds[3] = "Обороты активные (руб)";
		inds[4] = "Обороты активные (другое)";
		inds[5] = "Обороты активные (всего)";

		inds[6] = "Обороты пассивные (руб)";
		inds[7] = "Обороты пассивные (другое)";
		inds[8] = "Обороты пассивные (всего)";

		inds[9] = "Исходящие остатки (руб)";
		inds[10] = "Исходящие остатки (другое)";
		inds[11] = "Исходящие остатки (всего)";
	}

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

	public Integer getId() {
		return id;
	}

	public Integer getIncomingBalanceOther() {
		return incomingBalanceOther;
	}

	public Integer getIncomingBalanceTotal() {
		return incomingBalanceTotal;
	}

	public Integer getOutcomingBalanceRub() {
		return outcomingBalanceRub;
	}

	public Integer getOutcomingBalanceOther() {
		return outcomingBalanceOther;
	}

	public Integer getOutcomingBalanceTotal() {
		return outcomingBalanceTotal;
	}

	public Integer getTurnoverActiveRub() {
		return turnoverActiveRub;
	}

	public Integer getTurnoverActiveOther() {
		return turnoverActiveOther;
	}

	public Integer getTurnoverActiveTotal() {
		return turnoverActiveTotal;
	}

	public Integer getTurnoverPassiveRub() {
		return turnoverPassiveRub;
	}

	public Integer getTurnoverPassiveOther() {
		return turnoverPassiveOther;
	}

	public Integer getTurnoverPassiveTotal() {
		return turnoverPassiveTotal;
	}

	/**
	 * Получить показатель
	 * 
	 * @param name имя показателя
	 * @return значение
	 */
	public Integer getProperty(String name) {
		int index = -1;
		for (int i = 0; i < inds.length; i++) {
			if (name.equalsIgnoreCase(inds[i])) {
				index = i;
				break;
			}
		}
		switch (index) {
		case 0:
			return incomingBalanceRub;
		case 1:
			return incomingBalanceOther;
		case 2:
			return incomingBalanceTotal;
		case 3:
			return turnoverActiveRub;
		case 4:
			return turnoverActiveOther;
		case 5:
			return turnoverActiveTotal;
		case 6:
			return turnoverPassiveRub;
		case 7:
			return turnoverPassiveOther;
		case 8:
			return turnoverPassiveTotal;
		case 9:
			return outcomingBalanceRub;
		case 10:
			return outcomingBalanceOther;
		case 11:
			return outcomingBalanceTotal;
		}
		return 0;
	}

	/**
	 * Получить имена показателей
	 * 
	 * @return показатели
	 */
	public static String[] getNamesProperties() {
		return inds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((incomingBalanceOther == null) ? 0 : incomingBalanceOther.hashCode());
		result = prime * result + ((incomingBalanceRub == null) ? 0 : incomingBalanceRub.hashCode());
		result = prime * result + ((incomingBalanceTotal == null) ? 0 : incomingBalanceTotal.hashCode());
		result = prime * result + ((outcomingBalanceOther == null) ? 0 : outcomingBalanceOther.hashCode());
		result = prime * result + ((outcomingBalanceRub == null) ? 0 : outcomingBalanceRub.hashCode());
		result = prime * result + ((outcomingBalanceTotal == null) ? 0 : outcomingBalanceTotal.hashCode());
		result = prime * result + ((turnoverActiveOther == null) ? 0 : turnoverActiveOther.hashCode());
		result = prime * result + ((turnoverActiveRub == null) ? 0 : turnoverActiveRub.hashCode());
		result = prime * result + ((turnoverActiveTotal == null) ? 0 : turnoverActiveTotal.hashCode());
		result = prime * result + ((turnoverPassiveOther == null) ? 0 : turnoverPassiveOther.hashCode());
		result = prime * result + ((turnoverPassiveRub == null) ? 0 : turnoverPassiveRub.hashCode());
		result = prime * result + ((turnoverPassiveTotal == null) ? 0 : turnoverPassiveTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indicator other = (Indicator) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (incomingBalanceOther == null) {
			if (other.incomingBalanceOther != null)
				return false;
		} else if (!incomingBalanceOther.equals(other.incomingBalanceOther))
			return false;
		if (incomingBalanceRub == null) {
			if (other.incomingBalanceRub != null)
				return false;
		} else if (!incomingBalanceRub.equals(other.incomingBalanceRub))
			return false;
		if (incomingBalanceTotal == null) {
			if (other.incomingBalanceTotal != null)
				return false;
		} else if (!incomingBalanceTotal.equals(other.incomingBalanceTotal))
			return false;
		if (outcomingBalanceOther == null) {
			if (other.outcomingBalanceOther != null)
				return false;
		} else if (!outcomingBalanceOther.equals(other.outcomingBalanceOther))
			return false;
		if (outcomingBalanceRub == null) {
			if (other.outcomingBalanceRub != null)
				return false;
		} else if (!outcomingBalanceRub.equals(other.outcomingBalanceRub))
			return false;
		if (outcomingBalanceTotal == null) {
			if (other.outcomingBalanceTotal != null)
				return false;
		} else if (!outcomingBalanceTotal.equals(other.outcomingBalanceTotal))
			return false;
		if (turnoverActiveOther == null) {
			if (other.turnoverActiveOther != null)
				return false;
		} else if (!turnoverActiveOther.equals(other.turnoverActiveOther))
			return false;
		if (turnoverActiveRub == null) {
			if (other.turnoverActiveRub != null)
				return false;
		} else if (!turnoverActiveRub.equals(other.turnoverActiveRub))
			return false;
		if (turnoverActiveTotal == null) {
			if (other.turnoverActiveTotal != null)
				return false;
		} else if (!turnoverActiveTotal.equals(other.turnoverActiveTotal))
			return false;
		if (turnoverPassiveOther == null) {
			if (other.turnoverPassiveOther != null)
				return false;
		} else if (!turnoverPassiveOther.equals(other.turnoverPassiveOther))
			return false;
		if (turnoverPassiveRub == null) {
			if (other.turnoverPassiveRub != null)
				return false;
		} else if (!turnoverPassiveRub.equals(other.turnoverPassiveRub))
			return false;
		if (turnoverPassiveTotal == null) {
			if (other.turnoverPassiveTotal != null)
				return false;
		} else if (!turnoverPassiveTotal.equals(other.turnoverPassiveTotal))
			return false;
		return true;
	}
}
