package digitalRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalRestaurant.entity.Menu;

@Repository
public interface menuRepository extends JpaRepository<Menu,Integer>{
   Menu findByMenuname(String menuname);
   Menu findByName(String name);
}
