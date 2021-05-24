package digitalRestaurant.service;

import java.util.List;

import org.springframework.stereotype.Component;

import digitalRestaurant.entity.Menu;
import digitalRestaurant.model.MenuDto;
@Component
public interface menuService {
    void saveMenu(Menu menu);
    List<Menu> getAllMenus();
    Menu getMenuByName(String name);
    public MenuDto saveImg(MenuDto menuDto);
    public String   trimSpaceBarsForMenuName(String name);
    

}
