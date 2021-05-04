package digitalRestaurant.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalRestaurant.entity.Customer;
import digitalRestaurant.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{
      
	@Autowired
	private CustomerRepository customerRepository;
	  
	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(int id) {
		return customerRepository.findById(id).orElseThrow();
	}

}
