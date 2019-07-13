package str.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditOrg")
public class CreditOrg {

	/**
	 * Уникальный номер
	 */
	@Id
	private int id;

	/**
	 * Наименование
	 */
	@Column
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
