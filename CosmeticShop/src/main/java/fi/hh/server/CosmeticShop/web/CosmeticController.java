package fi.hh.server.CosmeticShop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import fi.hh.server.CosmeticShop.domain.*;

@Controller


public class CosmeticController {
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}


