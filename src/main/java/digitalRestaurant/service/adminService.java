package digitalRestaurant.service;






import digitalRestaurant.entity.Admin;


public interface adminService {
    public boolean useableAdminUsernameCheck(String username);
    public void SaveAdmin(Admin admin);
    public boolean AdminAuthenticatedToLoginOrNot(Admin admin);
    public Admin getAdminByUserName(String name);
}
