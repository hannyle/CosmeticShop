package fi.hh.server.CosmeticShop;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.server.CosmeticShop.domain.Product;
import fi.hh.server.CosmeticShop.domain.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class ProductRepositoryTest {
	@Autowired
	private ProductRepository repository;
	
	@Test
	 public void findByNameShouldReturnProduct(){
		List<Product> products = (List<Product>)repository.findAll();
        
        assertThat(products).hasSize(6);
        assertThat(products.get(0).getName()).isEqualTo("Lumene Day Cream");
	} 
	
	 @Test
	    public void createNewProduct() {
	    	Product product1 = new Product("lumene_bodylotion.jpg","Lumene Body Lotion", 8);
	    	repository.save(product1);
	    	assertThat(product1.getId()).isNotNull();
	    }    
}
