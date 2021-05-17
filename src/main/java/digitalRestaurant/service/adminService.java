package digitalRestaurant.service;



import digitalRestaurant.entity.Admin;


public interface adminService {
    public boolean validAdminOrNot(Admin admin);
    public void SaveAdmin(Admin admin);
}
