package com.registro.grupos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.grupos.demo.model.Grupo;

@Repository
public interface IGrupoRepository extends JpaRepository< Grupo, Long >
{

}