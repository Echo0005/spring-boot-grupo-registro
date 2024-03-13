package com.registro.grupos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.grupos.demo.model.Group;

@Repository
public interface IGroupRepository extends JpaRepository< Group, Long >
{

}