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

	/**
	 * Конструктор
	 * 
	 * @param properties свойства в виде строках
	 * @throws Exception
	 */
	public Bill(String[] properties) throws Exception {
		if (properties.length > 2) {
			throw new Exception("Ошибка создания объекта организации. Неверный формат входных данных!");
		}

		for (int i = 0; i < properties.length; i++) {
			switch (i) {
			case 0:
				id = Integer.parseInt(properties[i]);
				break;
			case 1:
				name = properties[i];
				break;
			}
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Bill other = (Bill) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
