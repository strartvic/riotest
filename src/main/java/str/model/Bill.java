package str.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {

	/**
	 * Уникальный номер
	 */
	@Id
	private Integer id;

	/**
	 * Наименование
	 */
	private String name;

	/**
	 * Показатели
	 */
	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Indicator> indicators;

	/**
	 * Пустой конструктор
	 */
	public Bill() {

	}

	/**
	 * Конструктор
	 * 
	 * @param id   уник номер
	 * @param name наименование
	 */
	public Bill(int id, String name) {
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
		indicator.setBill(this);
		this.indicators.add(indicator);
	}

	public void remove(Indicator indicator) {
		indicators.remove(indicator);
	}

}
