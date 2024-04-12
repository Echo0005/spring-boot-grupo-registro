package com.registro.grupos.demo.service;

import java.util.HashSet;
import java.util.Set;

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

    public void delete( Long userId, Long grupoId )
    {
        iUserGrupoRepository.deleteUserOnGrupo( userId, grupoId );
    }

    /**
     * Metodo para Obtener un HashSet() con los id de los usuarios dentro de un grupo en concreto.
     * 
     * Primero obtenemos un Set<UserGrupo> buscados en la DB, filtrados por el id de un grupo en concreto. Luego con un ForEach cargamos los Id de cada User en el Set<UserGrupo>, en un Set<Long>.
     * 
     * @param grupoId
     * @return Set<Long>
     */
    public Set<Long> getUserIdsInGrupo( Long grupoId )
    {
        Set<UserGrupo> userGrupos = iUserGrupoRepository.findAllByGrupoId(grupoId);

        Set<Long> userIds = new HashSet<>();

        for (UserGrupo userGrupo : userGrupos)
        {
            userIds.add( userGrupo.getUser().getId() );
        }

        return userIds;
    }


    /**
     * Metodo para obtener un HashSet con los id de los grupos en los que un usuario en concreto esta anotado.
     * 
     * Primero obtenemos un Set<UserGrupo> buscados en la DB, filtrados por el id de un usuario en concreto. Luego con un ForEach cargamos los Id de cada grupo en el Set<UserGrupo>, en un Set<Long>.
     * 
     * @param userId
     * @return Set<Long>
     */
    public Set<Long> getGrupoIdsInUser( Long userId )
    {
        Set<UserGrupo> userGrupos = iUserGrupoRepository.findAllByUserId(userId);

        Set<Long> grupoIds = new HashSet<>();

        for ( UserGrupo userGrupo : userGrupos )
        {
            grupoIds.add( userGrupo.getGrupo().getId() );
        }

        return grupoIds;
    }
}