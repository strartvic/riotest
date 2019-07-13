package str.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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

}
