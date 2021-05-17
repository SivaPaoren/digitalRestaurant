package digitalRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalRestaurant.entity.Admin;

@Repository
public interface adminRepository extends JpaRepository<Admin,Integer>{
   
     Admin findByUsername(String username);
}
