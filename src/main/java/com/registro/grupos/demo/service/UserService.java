package com.registro.grupos.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.model.User;
import com.registro.grupos.demo.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService
{
    @Autowired
    private IUserRepository iUserRepository;

    public User findOne (Long id)
    {
        return iUserRepository.findById(id).orElseThrow();
    }

    public List<User> findAll()
    {
        return iUserRepository.findAll();
    }

    public User addUser ( User user )
    {
        return iUserRepository.save(user);
    }

    public User editUser ( User user )
    {
        return iUserRepository.save(user);
    }

    public void deleteUser (Long id)
    {
        iUserRepository.deleteById(id);
    }

    public boolean existById ( Long id )
    {
        return iUserRepository.existsById(id);
    }

}