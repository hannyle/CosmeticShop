package fi.hh.server.CosmeticShop.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fi.hh.server.CosmeticShop.domain.*;
import fi.hh.server.CosmeticShop.domain.ProductRepository;

@Controller
public class CosmeticController {
	private static final Model Model = null;
	
	@Autowired
	private ProductRepository repository;
	
	private int n = 0;
	private Long[] selectid = new Long[n];
	
	
	private Product[] a = new Product[n];
	private Order customer_order;
	private long order_id = 1;
	private Order[] orderlist =  new Order[0];
	
	@RequestMapping(value="/")
    public String mainpage (Model model) {	
		model.addAttribute("products", repository.findAll());		
        return "mainpage";
    }
	
	@RequestMapping(value="/home")
    public String productList(Model model) {	
		model.addAttribute("products", repository.findAll());		
        return "home";
    }
	//Login (customer, employee, manager)
	@RequestMapping(value="/login")
	public String login(Model model){
		return "login";
	}
	
	//Create new product (manager)
	@RequestMapping(value="/createproduct")
	public String createProduct(Model model){
		model.addAttribute("products", new Product());
		return "createproduct";
	}
	//save Product in Home (manager)
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save (Product products){
		repository.save(products);
		return "redirect:home";
	}

	//edit Product in Home (manager)
	@RequestMapping(value="/edit/{id}")
	public String editProduct (@PathVariable("id") Long id, Model model){
		model.addAttribute("products", repository.findOne(id));
		return "editproduct";
	}
	//delete Product in Home (manager)
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct (@PathVariable("id") Long id, Model model){
		repository.delete(id);
		return "redirect:../home";
	}
	
	//add to cart
	@RequestMapping(value="/addtocart/{id}", method = RequestMethod.POST)
	public String addToCart (@PathVariable("id") Long id, Model model){		
		Long[] temp = new Long[]{id};
		selectid = (Long[])ArrayUtils.addAll(selectid, temp);
		n++;	
		
		
		a = new Product[n];		
		for (int i= 0; i<n; i++){
			a[i] = repository.findOne(selectid[i]);
		}
		model.addAttribute("cproducts", a);
		System.out.println(n);
		return "mycart";
	}
	
	@RequestMapping(value="/deletefromcart/{id}", method = RequestMethod.GET)
	public String deleteFromCart(@PathVariable("id") Long id, Model model){
		int productId;
		int j;
		productId = id.intValue();
		
		for(j= 0; j<n; j++){
		
			if(a[j].id == productId){
				n--;
				break;
			}		
		}	
		
		a = (Product[])ArrayUtils.remove(a, j);
		selectid = (Long[])ArrayUtils.remove(selectid, j);
		model.addAttribute("cproducts", a);
		
		return "mycart";
	}
	
	//my cart
	@RequestMapping(value="/mycart")
    public String ShoppingCart(Model model) {	
		model.addAttribute("cproducts", a);
        return "mycart";
    }
	
	//order confirm
	@RequestMapping(value="/orderconfirm")
	public String Order(Model model) {	
		model.addAttribute("cproducts", a);
		double sum = 0;
		for (int i= 0; i<n; i++){
			sum = sum + a[i].price;
		}
		customer_order = new Order(order_id, sum);
		//customer_order.setTotalPrice(sum);
		model.addAttribute("totalprice", customer_order.getTotalPrice());
		
		
		return "orderconfirm";
	}
	
	//Order Saving
		@RequestMapping(value="/saveorder")
		public String saveOrder(Model model) {	
			
			//add customer order to Orderlist
			orderlist = (Order[])ArrayUtils.addAll(orderlist, new Order[]{customer_order});
			order_id++;
			
			//reset mycart data
			n = 0;
			selectid = new Long[n];
			a = new Product[n];
			return "redirect:home";
		}
	
	//Orderlist
		@RequestMapping(value="/orderlist")
		public String Orderlist(Model model) {	
			
			model.addAttribute("orders", orderlist);
			
			
			return "orderlist";
		}
	
	//RESTful service to get all books
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> productsRest() {	
	    return (List<Product>) repository.findAll();
	}    
}


