package fi.hh.server.CosmeticShop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private double totalPrice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long id, double totalPrice) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
