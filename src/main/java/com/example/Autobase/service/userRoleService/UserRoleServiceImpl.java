package com.example.Autobase.service.userRoleService;

import com.example.Autobase.DAO.UserRoleRepository;
import com.example.Autobase.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public void save(UserRole userRole)
    {
        userRoleRepository.save(userRole);
    }

    @Override
    public int[] saveUserRolesList(List<UserRole> userRoles)
    {
        userRoleRepository.saveAll(userRoles);
        return new int[0];
    }

    @Override
    public void update(UserRole userRole)
    {
        userRoleRepository.save(userRole);
    }

    @Override
    public void delete(UserRole userRole)
    {
        userRoleRepository.delete(userRole);
    }

    @Override
    public List<UserRole> findAll()
    {
        return userRoleRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        userRoleRepository.deleteAll();
    }


    @Override
    public List<String> getRoleNames(Long driverId)
    {
        return userRoleRepository.getRoleNames(driverId);
    }
}
