package com.registro.grupos.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.model.Grupo;
import com.registro.grupos.demo.repository.IGrupoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GrupoService
{
    @Autowired
    private IGrupoRepository iGrupoRepository;

    public Grupo findOne (Long id)
    {
        return iGrupoRepository.findById(id).orElseThrow();
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
    
}