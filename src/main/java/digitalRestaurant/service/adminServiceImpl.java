package digitalRestaurant.service;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digitalRestaurant.entity.Admin;
import digitalRestaurant.entity.Menu;
import digitalRestaurant.model.MenuDto;
import digitalRestaurant.repository.adminRepository;
import digitalRestaurant.repository.menuRepository;

@Service
public class adminServiceImpl implements adminService{
     
    @Autowired
    private adminRepository adminRepo;

    @Autowired
    private menuRepository menuRepo;

    @Override
    public boolean useableAdminUsernameCheck(String username) {
        Admin existingAdminWithSameUserName = adminRepo.findByUsername(username);
        if(existingAdminWithSameUserName != null){
            return false;
        }
        return true;
    }


    @Override
    public void SaveAdmin(Admin admin) {
        adminRepo.save(admin);
    }


    @Override
    public boolean AdminAuthenticatedToLoginOrNot(Admin admin) {
        // here we will authencate login user by passing admin paramater admin
        Admin existinUser = adminRepo.findByUsername(admin.getUsername());
        if(existinUser == null){
            return false;
        }else{
             if(!existinUser.getPassword().equals(admin.getPassword())){
                 return false;
             }else{
                 return true;
             }
        }
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
        String newGeneratedImageName = menuName +"."+extentions;
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

    
}
