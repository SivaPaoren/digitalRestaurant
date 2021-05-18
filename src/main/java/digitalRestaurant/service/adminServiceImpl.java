package digitalRestaurant.service;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digitalRestaurant.entity.Admin;
import digitalRestaurant.repository.adminRepository;

@Service
public class adminServiceImpl implements adminService{
     
    @Autowired
    private adminRepository adminRepo;

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
    public String saveImg(MultipartFile img,String menuName,String uploadDirectory){
        // TODO Auto-generated method stub
        String imgName = menuName+img.getOriginalFilename().substring(img.getOriginalFilename().length()-4);
        Path imgNameAndPath = Paths.get(uploadDirectory, imgName);
        
        //writing files here
        try {
            Files.write(imgNameAndPath,img.getBytes());
        } catch (IOException e) {
          e.printStackTrace();
           return "";
        }
       return imgName;
    }

    
}
