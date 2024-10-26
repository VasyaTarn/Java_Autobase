package com.example.Autobase.service.appUserService;

import com.example.Autobase.DAO.UserRepository;
import com.example.Autobase.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(AppUser user)
    {
        userRepository.save(user);
    }

    @Override
    public int[] saveUsersList(List<AppUser> users)
    {
        userRepository.saveAll(users);
        return new int[0];
    }

    @Override
    public void update(AppUser user)
    {
        userRepository.save(user);
    }

    @Override
    public void delete(AppUser user)
    {
        userRepository.delete(user);
    }

    @Override
    public List<AppUser> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        userRepository.deleteAll();
    }

    @Override
    public Optional<AppUser> findUserAccount(String userName)
    {
        return userRepository.findUserAccount(userName);
    }
}
