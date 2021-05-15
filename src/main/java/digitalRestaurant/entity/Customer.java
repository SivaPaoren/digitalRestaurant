package digitalRestaurant.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;





@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="customer_name")
  private String customerName;
  
  @Column(name="table_no")
  private int tableNo;
  
  //@Column(name="date_time")
  @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private DateAndTime dateAndTime;
  


  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
  @JoinColumn(name = "menu_id")
  private List<Menu> customersMenu = new ArrayList<>();






  
  public List<Menu> getCustomersMenu() {
    return this.customersMenu;
  }

  public void setCustomersMenu(List<Menu> customersMenu) {
    this.customersMenu = customersMenu;
  }
  

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public int getTableNo() {
	return tableNo;
}

public void setTableNo(int tableNo) {
	this.tableNo = tableNo;
}

public DateAndTime getDateAndTime() {
	return dateAndTime;
}

public void setDateAndTime(DateAndTime dateAndTime) {
	this.dateAndTime = dateAndTime;
}


  
  
  
}
