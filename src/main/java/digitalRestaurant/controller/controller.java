package digitalRestaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import digitalRestaurant.entity.Customer;


@Controller
public class controller {
	//@Autowired
	//private CustomerServiceImpl customerService;
	
     //this welcome home will also pass object customer to the welcome to collect user input datas
     @GetMapping("/")
     public String showGreetingPage(Model model) {
    	 //object customer is bind with model to send to welcome page
         model.addAttribute("customer",new Customer());
    	 return "index.html";
     }
      
     @GetMapping("/Home")
     public String getHomePage(){
          return "home.html";
     }
     @PostMapping("/processForm")
     public String processForm(@ModelAttribute(value="customer") Customer customer){
          return "redirect:/Home";
     }

     @GetMapping("/menuCart")
     public String showMenuCartPage(){
       return "shop-cart.html";
     }
	
	
	
}
