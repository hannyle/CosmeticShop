package fi.hh.server.CosmeticShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class CosmeticController {
	@RequestMapping("*")
	public String hi() {
		return "Hello Spring";
	}
}


