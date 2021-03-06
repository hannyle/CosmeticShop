package fi.hh.server.CosmeticShop.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByName(String name);

}
