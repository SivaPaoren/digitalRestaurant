package digitalRestaurant.service;

import java.util.List;


import digitalRestaurant.entity.Customer;


public interface CustomerService {
   public void saveCustomer(Customer customer);
   public List<Customer> getCustomers();
   public Customer getCustomer(int id);
}
