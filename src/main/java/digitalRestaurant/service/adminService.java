package digitalRestaurant.service;






import digitalRestaurant.entity.Admin;
import digitalRestaurant.model.MenuDto;


public interface adminService {
    public boolean useableAdminUsernameCheck(String username);
    public void SaveAdmin(Admin admin);
    public boolean AdminAuthenticatedToLoginOrNot(Admin admin);
    public MenuDto saveImg(MenuDto menuDto);
}
