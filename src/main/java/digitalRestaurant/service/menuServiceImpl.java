package digitalRestaurant.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalRestaurant.entity.Menu;
import digitalRestaurant.repository.menuRepository;

@Service
public class menuServiceImpl implements menuService{
    
    @Autowired
    private menuRepository menuRepo;

    @Override
    public void saveMenu(Menu menu) {
        menuRepo.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepo.findAll();
    }

    @Override
    public Menu getMenuByName(String name) {
        //return the menu of the sent id
        Menu menu = menuRepo.findByName(name);
        return menu;
    }
}

