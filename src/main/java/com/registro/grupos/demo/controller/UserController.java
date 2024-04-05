package com.registro.grupos.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.grupos.demo.dto.Message;
import com.registro.grupos.demo.dto.UserDTO;
import com.registro.grupos.demo.model.User;
import com.registro.grupos.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll()
    {
        List<User> listUser = userService.findAll();
        return new ResponseEntity<>( listUser, HttpStatus.FOUND );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser( @RequestBody UserDTO userDTO )
    {
        if ( StringUtils.isBlank( userDTO.getName() ) )
            return new ResponseEntity<>( new Message("Nombre vacio"), HttpStatus.LENGTH_REQUIRED );
        if ( StringUtils.isBlank( userDTO.getAvatar() ) )
            return new ResponseEntity<>( new Message("Avatar vacio"), HttpStatus.LENGTH_REQUIRED );
        
        User newUser = new User();
        newUser.setName( userDTO.getName() );
        newUser.setAvatar( userDTO.getAvatar() );

        userService.addUser(newUser);

        return new ResponseEntity<>( new Message("Usuario creado"), HttpStatus.CREATED );
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser( @RequestBody UserDTO userDTO )
    {
        if ( !userService.existById( userDTO.getId() ) )
            return new ResponseEntity<>( new Message("Id no encontrado"), HttpStatus.NOT_MODIFIED );
        
        User updateUser = new User();
        updateUser.setId( userDTO.getId() );
        updateUser.setAvatar( userDTO.getName() );
        updateUser.setName( userDTO.getAvatar() );

        userService.addUser( updateUser );

        return new ResponseEntity<>( new Message( "Usuario actualizado" ), HttpStatus.OK );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser( @RequestBody UserDTO userDTO )
    {
        if ( !userService.existById( userDTO.getId() ) )
            return new ResponseEntity<>( new Message("Usuario no encontrado"), HttpStatus.NOT_FOUND );
        
        userService.deleteUser( userDTO.getId() );

        return new ResponseEntity<>( new Message("Usuario eliminado"), HttpStatus.OK );
    }
}
