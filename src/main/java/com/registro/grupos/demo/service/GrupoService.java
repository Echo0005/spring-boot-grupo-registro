package com.registro.grupos.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.dto.GrupoDTO;
import com.registro.grupos.demo.model.Grupo;
import com.registro.grupos.demo.model.User;
import com.registro.grupos.demo.repository.IGrupoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GrupoService
{
    @Autowired
    private IGrupoRepository iGrupoRepository;

    public Grupo findGrupoById ( Long id )
    {
        return iGrupoRepository.findById(id).orElseThrow();
    }

    public GrupoDTO findOne (Long id)
    {
        Grupo grupo = iGrupoRepository.findById(id).orElseThrow();

        GrupoDTO grupoDTO = new GrupoDTO();
        grupoDTO.setId( grupo.getId() );
        grupoDTO.setName( grupo.getName() );
        grupoDTO.setLogo( grupo.getLogo() );

        return grupoDTO;
    }

    public List<Grupo> findAll()
    {
        return iGrupoRepository.findAll();
    }

    public Grupo addGroup ( Grupo grupo )
    {
        return iGrupoRepository.save(grupo);
    }

    public Grupo editGroup ( Grupo grupo )
    {
        return iGrupoRepository.save(grupo);
    }

    public void deleteGroup (Long id)
    {
        iGrupoRepository.deleteById(id);
    }

    public boolean existById ( Long id )
    {
        return iGrupoRepository.existsById(id);
    }
    
    public Set<Grupo> searchGruposById ( Set<Long> ids )
    {
        Set<Grupo> grupos = iGrupoRepository.searchGruposById(ids);

        return grupos;
    }

    public GrupoDTO loadGrupo ( GrupoDTO grupoDTO, Set<User> usersList )
    {
        GrupoDTO grupo = grupoDTO;
        grupo.setUsers( usersList );

        return grupo;
    }
}