package com.registro.grupos.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.grupos.demo.model.UserGrupo;

@Repository
public interface IUserGrupoRepository extends JpaRepository< UserGrupo, Long >
{
    @Query
    (
        value = "DELETE FROM user_grupo WHERE ( user_id = ?1 AND grupo_id = ?2 );",
        nativeQuery = true
    )
    public void deleteUserOnGrupo( Long userId, Long grupoId );

    public Set<UserGrupo> findAllByUserId( Long userId );

    public Set<UserGrupo> findAllByGrupoId( Long grupoId );
}