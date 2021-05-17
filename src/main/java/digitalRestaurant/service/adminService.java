package digitalRestaurant.service;



import digitalRestaurant.entity.Admin;


public interface adminService {
    public boolean validAdminOrNot(String username);
    public void SaveAdmin(Admin admin);
}
