package fi.hh.server.CosmeticShop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import fi.hh.server.CosmeticShop.ProductRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller


public class CosmeticController {
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}


