package com.registro.grupos.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.grupos.demo.service.GroupService;
import com.registro.grupos.demo.dto.GroupDTO;
import com.registro.grupos.demo.dto.Message;
import com.registro.grupos.demo.model.Group;

@RestController
@RequestMapping("/group")
public class GroupController
{
    @Autowired
    private GroupService groupService;

    
    @GetMapping("/all")
    public ResponseEntity<List<Group>> findAll()
    {
        List<Group> listGroup = groupService.findAll();
        return new ResponseEntity<>(listGroup, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addGroup( @RequestBody GroupDTO groupDTO )
    {
        if ( StringUtils.isBlank( groupDTO.getLogo() ) )
            return new ResponseEntity<>( new Message("Logo vacio"), HttpStatus.LENGTH_REQUIRED );
        if ( StringUtils.isBlank( groupDTO.getName() ) )
            return new ResponseEntity<>( new Message("Nombre vacio"), HttpStatus.LENGTH_REQUIRED );
        
        Group newGroup = new Group();
        newGroup.setLogo( groupDTO.getLogo() );
        newGroup.setName( groupDTO.getName() );

        groupService.addGroup(newGroup);

        return new ResponseEntity<>( new Message("Grupo creado"), HttpStatus.CREATED );
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateGroup( @RequestBody GroupDTO groupDTO )
    {
        if ( groupService.existById( groupDTO.getId() ) )
            return new ResponseEntity<>( new Message("Id no encontrado"), HttpStatus.NOT_MODIFIED );
        
        Group group = new Group();
        group.setId( groupDTO.getId() );
        group.setLogo( groupDTO.getLogo() );
        group.setName( groupDTO.getName() );

        groupService.addGroup( group );

        return new ResponseEntity<>( new Message( "Grupo actualizado" ), HttpStatus.OK );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteGroup( @RequestBody GroupDTO groupDTO )
    {
        if ( groupService.existById( groupDTO.getId() ) )
            return new ResponseEntity<>( new Message("Grupo no encontrado"), HttpStatus.NOT_FOUND );
        
        groupService.deleteGroup( groupDTO.getId() );

        return new ResponseEntity<>( new Message("Grupo eliminado"), HttpStatus.OK );
    }

}