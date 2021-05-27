package digitalRestaurant;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import digitalRestaurant.controller.menuController;

@SpringBootApplication
public class DigitalRestaurantApplication {
     
	public static void main(String[] args) {
		//here this code will create folder to store image
		new File(menuController.uploadDirectory).mkdir();
		SpringApplication.run(DigitalRestaurantApplication.class, args);
	}

}
