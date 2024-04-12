package com.registro.grupos.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.grupos.demo.dto.Message;
import com.registro.grupos.demo.dto.UserGrupoDTO;
import com.registro.grupos.demo.model.Grupo;
import com.registro.grupos.demo.model.User;
import com.registro.grupos.demo.model.UserGrupo;
import com.registro.grupos.demo.service.GrupoService;
import com.registro.grupos.demo.service.UserGrupoService;
import com.registro.grupos.demo.service.UserService;

@RestController
@RequestMapping("/user-grupo")
public class UserGrupoController
{
    @Autowired
    private UserGrupoService userGrupoService;

    @Autowired
    private UserService userService;

    @Autowired
    private GrupoService grupoService;


    private boolean verificarUser( Long id )
    {
        return userService.existById(id);
    }

    private boolean verificarGrupo( Long id )
    {
        return grupoService.existById(id);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addUserGrupo( @RequestBody UserGrupoDTO userGrupoDTO )
    {
        if ( !verificarUser( userGrupoDTO.getUserId() ) )
            return new ResponseEntity<>(new Message("Usuario no encontrado"), HttpStatus.NOT_FOUND);
        
        if ( !verificarGrupo( userGrupoDTO.getGrupoId() ) )
            return new ResponseEntity<>(new Message("Grupo no encontrado"), HttpStatus.NOT_FOUND);

        User user = new User();
        user = userService.findUserbyId( userGrupoDTO.getUserId() );

        Grupo grupo = new Grupo();
        grupo = grupoService.findGrupoById( userGrupoDTO.getGrupoId() );

        UserGrupo userGrupo = new UserGrupo();
        userGrupo.setUser(user);
        userGrupo.setGrupo(grupo);

        userGrupoService.addUserGrupo(userGrupo);

        return new ResponseEntity<>( new Message("Usuario anotado en el grupo"), HttpStatus.CREATED );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRelation( @RequestBody UserGrupoDTO userGrupoDTO )
    {
        if ( !verificarUser( userGrupoDTO.getUserId() ) )
            return new ResponseEntity<>(new Message("Usuario no encontrado"), HttpStatus.NOT_FOUND);
        
        if ( !verificarGrupo( userGrupoDTO.getGrupoId() ) )
            return new ResponseEntity<>(new Message("Grupo no encontrado"), HttpStatus.NOT_FOUND);

        userGrupoService.delete(userGrupoDTO.getUserId(), userGrupoDTO.getGrupoId());
        
        return new ResponseEntity<>(new Message("Usuario retirado del grupo"), HttpStatus.OK);
    }

}