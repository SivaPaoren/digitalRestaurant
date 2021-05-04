package digitalRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import digitalRestaurant.entity.Customer;
import digitalRestaurant.service.CustomerServiceImpl;

@RestController
//@Controller
public class controller {
	@Autowired
	private CustomerServiceImpl customerService;
//     @GetMapping("/")
//     public String home() {
//    	 return "index.html";
//     }
	
	
	@PostMapping("/saveCustomer")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable int id ) {
		return customerService.getCustomer(id);
	}
	
}
