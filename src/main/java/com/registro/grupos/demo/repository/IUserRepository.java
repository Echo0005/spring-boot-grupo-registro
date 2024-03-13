package com.registro.grupos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.grupos.demo.model.User;

@Repository
public interface IUserRepository extends JpaRepository< User, Long >
{

}