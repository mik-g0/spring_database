package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Класс Clothing представляет сущность "Одежда" для сохранения в базе данных.
 * Используется для хранения информации о товарах, таких как название, размер, 
 * материал, количество и цена.
 */
@Entity
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String size;
    private String material;
    private int quantity;
    private double price;

    /**
     * Возвращает уникальный идентификатор товара.
     *
     * @return значение id.
     */
	public Long getId() {
		return id;
	}

    /**
     * Устанавливает уникальный идентификатор товара.
     *
     * @param id уникальный идентификатор.
     */
	public void setId(Long id) {
		this.id = id;
	}

    /**
     * Возвращает название товара.
     *
     * @return значение name.
     */
	public String getName() {
		return name;
	}

    /**
     * Устанавливает название товара.
     *
     * @param name название товара.
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Возвращает размер товара.
     *
     * @return значение size.
     */
	public String getSize() {
		return size;
	}

    /**
     * Устанавливает размер товара.
     *
     * @param size размер товара.
     */
	public void setSize(String size) {
		this.size = size;
	}
	
    /**
     * Возвращает материал товара.
     *
     * @return значение material.
     */
	public String getMaterial() {
		return material;
	}
	
    /**
     * Устанавливает материал товара.
     *
     * @param material материал товара.
     */
	public void setMaterial(String material) {
		this.material = material;
	}
	
    /**
     * Возвращает количество товара на складе.
     *
     * @return значение quantity.
     */
	public int getQuantity() {
		return quantity;
	}
	
    /**
     * Устанавливает количество товара на складе.
     *
     * @param quantity количество товара.
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
    /**
     * Возвращает цену товара.
     *
     * @return значение price.
     */
	public double getPrice() {
		return price;
	}

    /**
     * Устанавливает цену товара.
     *
     * @param price цена товара.
     */
	public void setPrice(double price) {
		this.price = price;
	}

    /**
     * Возвращает строковое представление объекта.
     * 
     * @return строка, содержащая информацию о товаре.
     */
	@Override
	public String toString() {
		return "Clothing [id=" + id + ", name=" + name + ", size=" + size + ", material=" + material + ", quantity="
				+ quantity + ", price=" + price + "]";
	}

}

