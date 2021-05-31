package digitalRestaurant.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import digitalRestaurant.entity.Customer;
import digitalRestaurant.model.MenuDTO;
import digitalRestaurant.service.menuServiceImpl;


@Controller
public class frontSideController {
	//@Autowired
	//private CustomerServiceImpl customerService;

     @Autowired
     private menuServiceImpl menuService;
	
     //this welcome home will also pass object customer to the welcome to collect user input datas
     @GetMapping("/")
     public String showGreetingPage(Model model) {
    	 //object customer is bind with model to send to welcome page
         model.addAttribute("customer",new Customer());
    	 return "index.html";
     }
      
     @GetMapping("/Home")
     public String getHomePage(Model model){
          //send list of menu from here to the client
          List<MenuDTO> allMenu= menuService.getAllMenus();

          model.addAttribute("firstMenu",allMenu.get(0));
          allMenu.remove(0);
          model.addAttribute("Menus", allMenu);

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
