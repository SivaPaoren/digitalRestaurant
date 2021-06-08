package digitalRestaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService UserDetailService;
    
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(UserDetailService);
        provider.setPasswordEncoder(getPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             .antMatchers("/",
                          "/Home",
                          "/Login",
                          "/Register",
                          "/Source/**",
                          "/assets/**",
                          "/css/**",
                          "/fonts/**",
                          "/imageData/**",
                          "/img/**",
                          "/loginAssets/**",
                          "/sass/**",
                          "/gulpfile.js",
                          "package-lock.json",
                          "package.json")
             .permitAll()
             .anyRequest()
             .authenticated()

             .and()
             .formLogin()
             .loginPage("/Login")
             .defaultSuccessUrl("/Add-Menu")
             .permitAll();
    }

    

    
}
