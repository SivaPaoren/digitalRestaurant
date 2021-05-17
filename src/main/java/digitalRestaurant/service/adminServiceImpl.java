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
    public boolean validAdminOrNot(Admin admin) {
        Admin existingAdminWithSameUserName = adminRepo.FindByUserName(admin.getUsername());
        if(existingAdminWithSameUserName != null){
            System.out.println("User already exist");
            return false;
        }
        return true;
    }


    @Override
    public void SaveAdmin(Admin admin) {
        adminRepo.save(admin);
    }
}
