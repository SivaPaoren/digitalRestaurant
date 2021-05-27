package digitalRestaurant.model;

import org.springframework.stereotype.Component;

import digitalRestaurant.entity.Menu;

@Component
public class MenuDTO {
    private int id;
    private String name;
    private String menuname;
    private String imagename;
    private String price;
    private String currency = "฿";
    
    public MenuDTO(){

    }

    public  MenuDTO(Menu menu){
      this.price = menu.getPrice();
      this.currency = menu.getCurrency();
      this.name = menu.getName();
      this.imagename = menu.getImagename();
      this.menuname = menu.getMenuname();
    }


    public String getMenuname() {
        return this.menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
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

    public String getImagename() {
        return this.imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
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
