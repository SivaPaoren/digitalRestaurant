package digitalRestaurant.service;




import org.springframework.web.multipart.MultipartFile;

import digitalRestaurant.entity.Admin;


public interface adminService {
    public boolean useableAdminUsernameCheck(String username);
    public void SaveAdmin(Admin admin);
    public boolean AdminAuthenticatedToLoginOrNot(Admin admin);
    public String saveImg(MultipartFile img,String menuName,String uploadDirectory);
}
