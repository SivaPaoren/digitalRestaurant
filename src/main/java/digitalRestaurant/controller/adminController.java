package digitalRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import digitalRestaurant.entity.Admin;
import digitalRestaurant.entity.Menu;
import digitalRestaurant.service.adminServiceImpl;

@Controller
public class adminController {
    
    //this is the directory where is images will be stored
    public static String uploadDirectory = System.getProperty("user-dir")+"/src/main/resources/static/imageData";
     
    @Autowired
    private adminServiceImpl adminservice;

    //display login page
    @GetMapping("/Login")
    public String showLoginPage(Model model){
        model.addAttribute("admin", new Admin());
        return "loginAdmin.html";
    }

    //user will try to login here
    @PostMapping("/Login")
    public String adminLogin(@ModelAttribute("admin")Admin admin,Model model){
        boolean validAdminCheck = adminservice.AdminAuthenticatedToLoginOrNot(admin);
        

        if(validAdminCheck){
         //redirect to login successfull page by redecting to AdminControlPanel
          return "redirect:/AdminControlPanel";
        }else{
            admin.setPassword("");
            model.addAttribute("admin", admin);
            model.addAttribute("error", "Incorrect User Name or Password");
            return "loginAdmin.html";
        }
    }
    
    //display register page
    @GetMapping("/Register")
    public String showRegisterPage(Model model){
        model.addAttribute("admin", new Admin());
        model.addAttribute("condition", false);
        return "register.html";
    }


    //get register admin object here
    @PostMapping("/Register")
    public String saveAdmin(@ModelAttribute("admin")Admin admin,Model model){

         boolean validOrNot = adminservice.useableAdminUsernameCheck(admin.getUsername());
         if(validOrNot){
            adminservice.SaveAdmin(admin);
            return "redirect:/AdminControlPanel";
         }else{
            admin.setPassword("");
            model.addAttribute("admin", admin);
            model.addAttribute("condition", true);
            model.addAttribute("error", "User Name "+admin.getUsername()+" is already taken");
            return "register.html";
         }
    }


    @GetMapping("/AdminControlPanel")
    public String showControlPanel(Model model){
        model.addAttribute("menu",new Menu());
        return "adminControlerPanel.html";
    }

}
