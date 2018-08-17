package fi.hh.server.CosmeticShop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
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
	public CommandLineRunner cosmeticDemo (ProductRepository repository, UserRepository urepository){
		return (args) -> {
			log.info("save some products");
			
			repository.save(new Product("lumene_daycream.jpg","Lumene Day Cream", 10));
			repository.save(new Product("lumene_nightcream.jpg","Lumene Night Cream", 12));
			repository.save(new Product("innisfree_sheetmask.jpg", "Innisfree Sheet Mask", 5));
			repository.save(new Product("loreal_serum.jpg", "L'oreal Serum", 17));
			repository.save(new Product("nivea_handcream.jpg", "Nivea Hand Cream", 2.5));
			repository.save(new Product("l300_eyecream.jpg", "L300 Eye Cream", 12.5));
	
			//create different users
			User user1 = new User("user1", "$2a$06$b7KCJLr/U/iXObm3T1/VS.xNPe6hI2WOSQaLuZVb.IFjEbd0ID/92", "USER");
			User user2 = new User("user2", "$2a$06$xUNh81KaW/wPiSr2WQNiP.1XCoYAwTtvVT2RCNZ8QikodBYskdi72", "USER");
			User admin = new User("admin", "$2a$06$wo0JXyuluuUWueTmGizicef/wU4d/2EvAep4E/NKu1ctnTvLS73b2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(admin);
			
			log.info("fetch all products");
			for(Product product : repository.findAll()){
				log.info(product.toString());
			}
			
		};
	}
}
