package com.example.Autobase.controller;

import com.example.Autobase.model.AppUser;
import com.example.Autobase.model.Role;
import com.example.Autobase.model.UserRole;
import com.example.Autobase.service.appUserService.AppUserService;
import com.example.Autobase.service.roleService.RoleService;
import com.example.Autobase.service.userRoleService.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm()
    {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model)
    {
        model.addAttribute("appUser", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute AppUser appUser, Model model)
    {
        if (appUserService.findUserAccount(appUser.getUserName()).isPresent())
        {
            model.addAttribute("error", "User already exists!");
            return "register";
        }

        String password = appUser.getPassword();
        String encPassword = passwordEncoder.encode(password);
        appUser.setPassword(encPassword);
        appUser.setEnabled(true);

        appUserService.save(appUser);

        Role roleUser = roleService.findRoleByName("ROLE_USER").orElse(null);

        UserRole userRole = new UserRole(0L, appUser, roleUser);
        userRoleService.save(userRole);

        return "redirect:/login?success";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model)
    {
        model.addAttribute("title", "Logout");
        return "logoutSuccessful";
    }
}
