package digitalRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import digitalRestaurant.entity.Admin;
import digitalRestaurant.service.adminServiceImpl;

@Controller
public class adminController {
     
    @Autowired
    private adminServiceImpl adminservice;

    //display login page
    @GetMapping("/Login")
    public String showAddMenuPage(){
        return "loginAdmin.html";
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
    public ModelAndView saveAdmin(@ModelAttribute("admin")Admin admin){

         ModelAndView mv = new ModelAndView();

         boolean validOrNot = adminservice.validAdminOrNot(admin.getUsername());
         if(validOrNot){
            adminservice.SaveAdmin(admin);
            mv.setViewName("adminControlerPanel.html");
         }else{
            admin.setPassword("");
            mv.addObject("admin", admin);
            mv.addObject("condition", true);
            mv.addObject("error", "User Name "+admin.getUsername()+" is already taken");
            mv.setViewName("register.html");
         }

         return mv;
    }

}
