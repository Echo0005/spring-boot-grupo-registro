package com.registro.grupos.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.grupos.demo.model.Grupo;

@Repository
public interface IGrupoRepository extends JpaRepository< Grupo, Long >
{
    @Query
    (
        value = "SELECT g.* FROM grupo g WHERE g.id IN(?1)",
        nativeQuery = true
    )
    Set<Grupo> searchGruposById( Set<Long> ids );
}