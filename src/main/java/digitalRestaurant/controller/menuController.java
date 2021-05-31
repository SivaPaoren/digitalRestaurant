package digitalRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import digitalRestaurant.model.MenuDTO;
import digitalRestaurant.service.menuService;



@Controller
public class menuController {

    //this is the directory where is images will be stored
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/imageData";
     
    @Autowired
    private menuService menuService;

    @GetMapping("/Add-Menu")
    public String showControlPanel(Model model){
        model.addAttribute("menu",new MenuDTO());
        return "addMenu.html";
    }

    @PostMapping("/Add-Menu")
    public String processAndSaveMenuForm(@ModelAttribute("menu")MenuDTO menu,@RequestParam("img")MultipartFile image,Model model){
        //service will return if the username can be used or not
         boolean isMenuAndImageSavedSuccessfully = menuService.saveMenuAndImage(menu,image,uploadDirectory);
       
        if(!isMenuAndImageSavedSuccessfully){
            model.addAttribute("menu", menu);
            model.addAttribute("msg", menu.getName()+" is alredy added");
            return "addMenu.html";
        }else{
            //image saved successfull will be done here
            model.addAttribute("msg", menu.getName()+" added successfully");
            model.addAttribute("menu", new MenuDTO());
            return "addMenu.html";
        }
    }



    @GetMapping("/Menu-Category")
    public String displayMenuToEditPage(Model model){
       model.addAttribute("Menus", menuService.getAllMenus());
       return "menuCategory.html";
    }


 
    //this method here display menu update page along with selected menu
    @GetMapping("/Edit-Menu/{name}")
    public String getEditMenuPage(@PathVariable("name")String name,Model model){
      //Editing menu page will be directed from here
        MenuDTO menuDto = new MenuDTO(menuService.getMenuByMenuName(name));

        model.addAttribute("menu", menuDto);
        return "editMenu.html";
    }

    
    @PostMapping("/Update-Menu")
    public String updateMenu(@ModelAttribute("menu")MenuDTO menu,@RequestParam("img")MultipartFile imageFile,Model model){
        
        boolean isUpdateMenuSuccessful = menuService.updateMenu(menu, imageFile, uploadDirectory);

        if(isUpdateMenuSuccessful){
            model.addAttribute("msg", "Menu Updated Successfully");
            return "redirect:/Menu-Category";
        }else{
            model.addAttribute("msg", "Menu Update Unsuccessful."+menu.getName()+" is alreay taken");
            return "redirect:/Edit-Menu/"+menu.getMenuname();
        }
    }

    @PostMapping(value="/Delete-Menu")
    public String deleteMenu(@RequestParam("menuname")String menuname,Model model) {
       
        
        MenuDTO menu = new MenuDTO(menuService.getMenuByMenuName(menuname));
        boolean isDeleted = menuService.deleteMenu(menuname);
        if(isDeleted){
            model.addAttribute("msg", "Deleted "+menu.getName()+" successfully");
        }else{
            model.addAttribute("msg", "Deleting "+menu.getName()+" was unsuccessful");
        }
        
        return displayMenuToEditPage(model);
    }
    
    

    
}
