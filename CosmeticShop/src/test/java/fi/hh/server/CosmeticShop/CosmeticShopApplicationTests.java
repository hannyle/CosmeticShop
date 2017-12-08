package fi.hh.server.CosmeticShop;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import fi.hh.server.CosmeticShop.web.CosmeticController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CosmeticShopApplicationTests {
	@Autowired
	private CosmeticController controller;
	
	@Test
	public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	

}
