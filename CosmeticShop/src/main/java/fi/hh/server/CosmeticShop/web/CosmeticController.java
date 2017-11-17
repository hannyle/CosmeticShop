package fi.hh.server.CosmeticShop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fi.hh.server.CosmeticShop.domain.*;

@Controller


public class CosmeticController {
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping(value="/home")
    public String productList(Model model) {	
        return "home";
    }
	
	//Login
	@RequestMapping(value="/login")
	public String login(Model model){
		return "login";
	}
  
	@RequestMapping(value="/mycart")
    public String myCart(Model model) {	
        model.addAttribute("products", repository.findAll());
        return "mycart";
    }
	@RequestMapping(value="/mycart/addProduct/{id}", method = RequestMethod.POST)
    public String addToCart(@PathVariable ("id") Long productId, Model model) {	
        model.addAttribute(productId);
        return "mycart";
    }
}


