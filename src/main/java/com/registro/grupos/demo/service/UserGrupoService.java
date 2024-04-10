package com.registro.grupos.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.grupos.demo.model.UserGrupo;
import com.registro.grupos.demo.repository.IUserGrupoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserGrupoService
{
    @Autowired
    private IUserGrupoRepository iUserGrupoRepository;


    public UserGrupo addUserGrupo( UserGrupo userGrupo )
    {
        return iUserGrupoRepository.save( userGrupo );
    }

    public void delete( Long id )
    {
        iUserGrupoRepository.deleteById( id );
    }
}