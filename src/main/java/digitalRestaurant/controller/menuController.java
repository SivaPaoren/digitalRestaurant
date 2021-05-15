package digitalRestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class menuController {
     

    //display login page
    @GetMapping("/Login")
    public String showAddMenuPage(){
        return "loginAdmin.html";
    }
    
    //display register page
    @GetMapping("/Register")
    public String showRegisterPage(){
        return "register.html";
    }

}
