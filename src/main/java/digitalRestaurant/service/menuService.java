package digitalRestaurant.service;

import java.util.List;

import digitalRestaurant.entity.Menu;

public interface menuService {
    void saveMenu(Menu menu);
    List<Menu> getAllMenus();
    Menu getMenuByName(String name);
}
