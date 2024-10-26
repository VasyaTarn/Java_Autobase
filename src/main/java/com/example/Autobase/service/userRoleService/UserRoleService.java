package com.example.Autobase.service.userRoleService;

import com.example.Autobase.model.UserRole;

import java.util.List;

public interface UserRoleService {
    void save(UserRole userRole);
    int[] saveUserRolesList(List<UserRole> userRoles);
    void update(UserRole userRole);
    void delete(UserRole userRole);
    List<UserRole> findAll();
    void deleteAll();

    List<String> getRoleNames(Long driverId);
}
