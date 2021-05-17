package digitalRestaurant.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    
}
