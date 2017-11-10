package fi.hh.server.CosmeticShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller


public class CosmeticController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}


