package digitalRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import digitalRestaurant.entity.Customer;
import digitalRestaurant.service.CustomerServiceImpl;


@Controller
public class controller {
	@Autowired
	private CustomerServiceImpl customerService;
	
     //this welcome home will also pass object customer to the welcome to collect user input datas
     @GetMapping("/")
     public String showGreetingPage(Model model) {
    	 //object customer is bind with model to send to welcome page
    	 Customer customer = new Customer();
    	 model.addAttribute("customer",customer);
    	 return "index.html";
     }

     @PostMapping("/processForm")
     public String processForm(@ModelAttribute(value="customer") Customer customer){
          return "index.html";
     }
	
	
	
}
