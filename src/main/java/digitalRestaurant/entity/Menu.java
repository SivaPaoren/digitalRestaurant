package digitalRestaurant.entity;


import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;


@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imagename;
    private String price;
    private String currency = "฿";

  //  @ManyToOne(fetch = FetchType.LAZY)
   // private Customer customer; 



    public String getImagename() {
        return this.imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
 

    public int getId() {
        return this.id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /*
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
  */


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", imagename='" + getImagename() + "'" +
            ", price='" + getPrice() + "'" +
            ", currency='" + getCurrency() + "'" +
            "}";
    }



}
