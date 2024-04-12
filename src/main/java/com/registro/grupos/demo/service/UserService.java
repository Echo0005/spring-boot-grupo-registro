package com.registro.grupos.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.dto.UserDTO;
import com.registro.grupos.demo.model.Grupo;
import com.registro.grupos.demo.model.User;
import com.registro.grupos.demo.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService
{
    @Autowired
    private IUserRepository iUserRepository;

    public User findUserbyId ( Long id )
    {
        User user = iUserRepository.findById(id).orElseThrow();

        return user;
    }

    public UserDTO findOne (Long id)
    {
        User user = iUserRepository.findById(id).orElseThrow();

        UserDTO userDTO = new UserDTO();
        userDTO.setId( user.getId() );
        userDTO.setAvatar( user.getAvatar() );
        userDTO.setName( user.getName() );

        return userDTO;
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

    public Set<User> searchUsersByIds ( Set<Long> ids )
    {
        Set<User> users = iUserRepository.searchUsersById(ids);

        return users;
    }

    public UserDTO loadUser ( UserDTO userDTO, Set<Grupo> grupos )
    {
        UserDTO user = userDTO;
        user.setGrupos(grupos);

        return user;
    }
}