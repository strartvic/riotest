package str.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CreditOrg {

	/**
	 * Уникальный номер
	 */
	@Id
	private Integer id;

	/**
	 * Наименование
	 */
	private String name;

	@OneToMany(mappedBy = "creditOrg")
	private List<Indicator> indicators;

	/**
	 * Пустой конструктор
	 */
	public CreditOrg() {

	}

	/**
	 * Конструктор
	 * 
	 * @param id   уник номер
	 * @param name наименование
	 */
	public CreditOrg(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void add(Indicator indicator) {
		indicator.setCreditOrg(this);
		indicators.add(indicator);
	}

	public void remove(Indicator indicator) {
		indicators.remove(indicator);
	}

}
