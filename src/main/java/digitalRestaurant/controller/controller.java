package digitalRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import digitalRestaurant.service.CustomerServiceImpl;


@Controller
public class controller {
	@Autowired
	private CustomerServiceImpl customerService;

     @GetMapping("/")
     public String home() {
    	 return "index.html";
     }

     @GetMapping("/welcomePage")
     public String welcomePage(){
          return "Welcome MotherFucker";
     }
	
	
	
}
