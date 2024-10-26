package com.example.Autobase.configuration;

import com.example.Autobase.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception
    {
        return authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();

        List<Endpoints> endpointsForAll = Endpoints.getEndpointForAllUsers();
        for (var endpoint : endpointsForAll)
        {
            http.authorizeRequests().mvcMatchers(endpoint.getEndPoint()).permitAll();
        }

        List<Endpoints> endpointsForAdmin = Endpoints.getEndpointForAdmin();
        for (var endpoint : endpointsForAdmin) {
            http.authorizeRequests().mvcMatchers(endpoint.getEndPoint())
                    .access("hasAnyRole('ROLE_ADMIN')");
        }

        List<Endpoints> endpointsForAdminAndUser = Endpoints.getEndpointForAdminAndAuthUser();
        for (var endpoint : endpointsForAdminAndUser) {
            http.authorizeRequests().mvcMatchers(endpoint.getEndPoint())
                    .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        }

        http.authorizeRequests().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logoutSuccessful");
    }
}
