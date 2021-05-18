package digitalRestaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalRestaurant.entity.Menu;
import digitalRestaurant.service.menuService;
@Service
public class menuServiceImpl implements menuService{
    
    @Autowired
    private menuRepository menuRepo;

    @Override
    public void saveMenu(Menu menu) {
        menuRepo.save(menu);
    }
}
