package fi.hh.server.CosmeticShop;

import org.springframework.data.repository.CrudRepository;
import fi.hh.server.CosmeticShop.domain.*;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByName(String name);
}
