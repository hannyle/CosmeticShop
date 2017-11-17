package fi.hh.server.CosmeticShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.hh.server.CosmeticShop.domain.*;

@SpringBootApplication
public class CosmeticShopApplication {
	private static final Logger log = LoggerFactory.getLogger(CosmeticShopApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CosmeticShopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner cosmeticDemo (ProductRepository repository){
		return (args) -> {
			log.info("save some products");
			repository.save(new Product("Lumene Day Cream", "10€"));
			repository.save(new Product("Lumene Night Cream", "12€"));
			repository.save(new Product("Innisfree Sheet Mask", "5€/6kpl"));
			repository.save(new Product("L'oreal Serum", "17.5€"));
			repository.save(new Product("Nivea Hand Cream", "2.95€"));
			repository.save(new Product("L300 Eye Cream", "12.5€"));
			
			log.info("fetch all products");
			for(Product product : repository.findAll()){
				log.info(product.toString());
			}
		};
	}
}
