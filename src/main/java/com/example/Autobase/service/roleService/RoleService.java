package com.example.Autobase.service.roleService;

import com.example.Autobase.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    void save(Role role);
    int[] saveRolesList(List<Role> roles);
    void update(Role role);
    void delete(Role role);
    List<Role> findAll();
    void deleteAll();

    Optional<Role> findRoleByName(String name);
}
