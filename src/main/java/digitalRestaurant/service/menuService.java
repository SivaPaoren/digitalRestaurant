package digitalRestaurant.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import digitalRestaurant.entity.Menu;
import digitalRestaurant.model.MenuDTO;
@Component
public interface menuService {
    void saveMenu(Menu menu);
    List<MenuDTO> getAllMenus();
    List<MenuDTO> getBestSellerMenu();
    Menu getMenuByMenuName(String menuName);
    public boolean saveMenuAndImage(MenuDTO menu,MultipartFile userUploadedImageFile,String uploadDirectory);
    public String   trimSpaceBarsForMenuName(String name);
    public boolean updateMenu(MenuDTO menu,MultipartFile userUploadedImageFile,String uploadDirectory);
    boolean deleteMenu(String menuname);

}
