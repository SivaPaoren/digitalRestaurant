package digitalRestaurant.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;







@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String customerName;
  private int tableNo;
  
  /*
  //@Column(name="date_time")
  @OneToOne(mappedBy = "Customer",cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private DateAndTime dateAndTime;
  */

  /*
  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
  @JoinColumn(name = "menu_id")
  private List<Menu> customersMenu = new ArrayList<>();
  */





  /*
  public List<Menu> getCustomersMenu() {
    return this.customersMenu;
  }

  public void setCustomersMenu(List<Menu> customersMenu) {
    this.customersMenu = customersMenu;
  }
  */

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

/*
public DateAndTime getDateAndTime() {
	return dateAndTime;
}

public void setDateAndTime(DateAndTime dateAndTime) {
	this.dateAndTime = dateAndTime;
}

*/

  
  
  
}
