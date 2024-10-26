package com.example.Autobase.service.appUserService;

import com.example.Autobase.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    void save(AppUser role);
    int[] saveUsersList(List<AppUser> roles);
    void update(AppUser role);
    void delete(AppUser role);
    List<AppUser> findAll();
    void deleteAll();

    Optional<AppUser> findUserAccount(String userName);
}
