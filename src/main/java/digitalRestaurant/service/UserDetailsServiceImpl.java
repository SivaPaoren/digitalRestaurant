package digitalRestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import digitalRestaurant.entity.Admin;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private adminService adminService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getAdminByUserName(username);
        
        return new userDetailsimpl(admin);
    }
}
