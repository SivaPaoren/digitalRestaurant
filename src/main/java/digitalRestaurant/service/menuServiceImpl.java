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
import digitalRestaurant.model.MenuDTO;
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
    public Menu getMenuByMenuName(String menuName) {
        //return the menu of the sent id
        Menu menu = menuRepo.findByMenuname(menuName);
        return menu;
    }

    @Override
    public boolean saveMenuAndImage(MenuDTO menu,MultipartFile userUploadedImageFile,String uploadDirectory){
        //check if the menu name used by admin is already used or not
        boolean isMenuNameAlreadyUsed = isMenuNameAlreadyUsed(menu.getMenuname());
        if(isMenuNameAlreadyUsed){
            return false;
        }else{
             //else if the menu name is useable it will be used here
        
                //finle extendtoin is generated here  // png jpeg html php java
                String ImageExtentions = generateFileExtention(userUploadedImageFile);
        
                //image name is generated here to match the menu name // soda.png  papa.jpeg
                String imageName = generateImageNameWithExtention(menu.getName(),ImageExtentions);
                //path to save the image is set here //getUploadDirectory is from controller is returns directory in String
                Path imgNameAndPath = Paths.get(uploadDirectory, imageName);
                
                    //here we will store image to our files in our repository
                    saveImageFile(imgNameAndPath,userUploadedImageFile);
                
                //save Menu entity here
                Menu menuEntity = new Menu();
                
                menuEntity.setMenuname(trimSpaceBarsForMenuName(menu.getName()));
                menuEntity.setName(menu.getName());
                menuEntity.setCurrency(menu.getCurrency());
                menuEntity.setPrice(menu.getPrice());
                menuEntity.setImagename(imageName);
                saveMenu(menuEntity);
                
                return true;
        }
    }

   private String generateFileExtention(MultipartFile imageFile){
       return FilenameUtils.getExtension(imageFile.getOriginalFilename());
   }

   private String generateImageNameWithExtention(String name,String extention){
       return trimSpaceBarsForMenuName(name)+"."+extention;
   }

   private boolean saveImageFile(Path nameAndPath,MultipartFile imageFile){
         try {
            Files.write(nameAndPath,imageFile.getBytes());
        } catch (IOException e) {
            //if the image could not be saved
            e.printStackTrace();
            return false;
        }
        return true;
   }
    

    @Override
    public String trimSpaceBarsForMenuName(String name) {
        name = name.replaceAll("\\s+","");
        return name;
    }
   
    @Override
    public boolean updateMenu(MenuDTO menu,MultipartFile useruploadedImageFile,String uploadDirectory) {
       
        String menuName = trimSpaceBarsForMenuName(menu.getName());
        //check if the newly update menu already exist in the database
        boolean isMenuNameAlreadyUsed = isMenuNameAlreadyUsed(menuName);

        if(isMenuNameAlreadyUsed){
            return false;
        }else{
         
       

         //get the old xeisting menu from the database 
        String extention = generateFileExtention(useruploadedImageFile);
        String imageName = generateImageNameWithExtention(menu.getName(), extention);
        Menu existingDataBaseMenu  = getMenuByMenuName(menu.getMenuname());

        existingDataBaseMenu.setCurrency(menu.getCurrency());
        existingDataBaseMenu.setPrice(menu.getPrice());

        //deleteOldImage here  // image name and directory
        deleteImage(uploadDirectory, existingDataBaseMenu.getImagename());
        
        //saving new image file
        Path imageNameAndPath = Paths.get(uploadDirectory, imageName);
        saveImageFile(imageNameAndPath, useruploadedImageFile);

        
        existingDataBaseMenu.setName(menu.getName());
        existingDataBaseMenu.setImagename(generateImageNameWithExtention(menu.getName(), extention));
        existingDataBaseMenu.setMenuname(menuName);
        menuRepo.save(existingDataBaseMenu);
        
         return true;

        }
    }

    public boolean deleteImage(String fileDirecotry,String imageName){
        String filePath = fileDirecotry+"/"+imageName;
        try {
             Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            // if deleting file was not successfull
            e.printStackTrace();
            return false;
        }
        return true;
    }
     

   private boolean isMenuNameAlreadyUsed(String menuName){
         Menu menu = getMenuByMenuName(menuName);

         if(menu == null)return false;
         else return true;
   }

}

