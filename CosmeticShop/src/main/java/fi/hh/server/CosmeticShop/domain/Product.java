package fi.hh.server.CosmeticShop.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public Long id;
	public String image;
	public String name;
	public double price;
		
	public Product(String image, String name, double price) {
		this.image = image;
		this.name = name;
		this.price = price;
	}
	
	public Product() {}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + image + ", name=" + name + ", price=" + price + "]";
	}

	
	
}
