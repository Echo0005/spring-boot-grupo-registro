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

import com.registro.grupos.demo.dto.GrupoDTO;
import com.registro.grupos.demo.dto.Message;
import com.registro.grupos.demo.model.Grupo;
import com.registro.grupos.demo.service.GrupoService;

@RestController
@RequestMapping("/grupo")
public class GrupoController
{
    @Autowired
    private GrupoService grupoService;

    
    @GetMapping("/all")
    public ResponseEntity<List<Grupo>> findAll()
    {
        List<Grupo> listGrupo = grupoService.findAll();
        return new ResponseEntity<>(listGrupo, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addGrupo( @RequestBody GrupoDTO grupoDTO )
    {
        if ( StringUtils.isBlank( grupoDTO.getLogo() ) )
            return new ResponseEntity<>( new Message("Logo vacio"), HttpStatus.LENGTH_REQUIRED );
        if ( StringUtils.isBlank( grupoDTO.getName() ) )
            return new ResponseEntity<>( new Message("Nombre vacio"), HttpStatus.LENGTH_REQUIRED );
        
            Grupo newGroup = new Grupo();
        newGroup.setLogo( grupoDTO.getLogo() );
        newGroup.setName( grupoDTO.getName() );

        grupoService.addGroup(newGroup);

        return new ResponseEntity<>( new Message("Grupo creado"), HttpStatus.CREATED );
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateGroup( @RequestBody GrupoDTO grupoDTO )
    {
        if ( !grupoService.existById( grupoDTO.getId() ) )
            return new ResponseEntity<>( new Message("Id no encontrado"), HttpStatus.NOT_MODIFIED );
        
        Grupo group = new Grupo();
        group.setId( grupoDTO.getId() );
        group.setLogo( grupoDTO.getLogo() );
        group.setName( grupoDTO.getName() );

        grupoService.addGroup( group );

        return new ResponseEntity<>( new Message( "Grupo actualizado" ), HttpStatus.OK );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteGroup( @RequestBody GrupoDTO grupoDTO )
    {
        if ( !grupoService.existById( grupoDTO.getId() ) )
            return new ResponseEntity<>( new Message("Grupo no encontrado"), HttpStatus.NOT_FOUND );
        
        grupoService.deleteGroup( grupoDTO.getId() );

        return new ResponseEntity<>( new Message("Grupo eliminado"), HttpStatus.OK );
    }

}