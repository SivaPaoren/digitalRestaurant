package digitalRestaurant.service;


import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digitalRestaurant.entity.Menu;
import digitalRestaurant.model.MenuDto;
import digitalRestaurant.repository.menuRepository;

@Service
public class menuServiceImpl implements menuService{
    
    @Autowired
    private menuRepository menuRepo;


    @Override
    public void saveMenu(Menu menu) {
        menuRepo.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepo.findAll();
    }

    @Override
    public Menu getMenuByName(String name) {
        //return the menu of the sent id
        Menu menu = menuRepo.findByName(name);
        return menu;
    }

    @Override
    public MenuDto saveImg(MenuDto menuDto){
       
        //menu name will be here so that it can be added as a new image name
        String menuName = menuDto.getMenuName();

        //Image file will be here send from server
        MultipartFile imageFile = menuDto.getOriginalImageFile();

        //finle extendtoin is generated here
        String extentions = FilenameUtils.getExtension(imageFile.getOriginalFilename());
 
        //image name is generated here to match the menu name
        String newGeneratedImageName = trimSpaceBarsForMenuName(menuName)+"."+extentions;
        //path to save the image is set here //getUploadDirectory is from controller is returns directory in String
        Path imgNameAndPath = Paths.get(menuDto.getUploadDirectory(), newGeneratedImageName);
        
        //here we check if the menu already exits in the repository or not
        Menu existingMenu = menuRepo.findByImagename(newGeneratedImageName);

         if(existingMenu == null){
             //here we will store image to our files in our repository
             try {
                Files.write(imgNameAndPath,imageFile.getBytes());
            } catch (IOException e) {
              e.printStackTrace();
            }
            menuDto.setImageAlredyExistInTheDataBaseOrNot(false);
            menuDto.setImageName(newGeneratedImageName);
            return menuDto;
         }

            menuDto.setImageAlredyExistInTheDataBaseOrNot(true);
            menuDto.setImageName(menuDto.getImageName());


       return menuDto;
    }
    

    @Override
    public String trimSpaceBarsForMenuName(String name) {
        name = name.replaceAll("\\s+","");
        return name;
    }



}

