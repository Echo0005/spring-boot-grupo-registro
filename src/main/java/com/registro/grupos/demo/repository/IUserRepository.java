package com.registro.grupos.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.grupos.demo.model.User;

@Repository
public interface IUserRepository extends JpaRepository< User, Long >
{
    @Query
    (
        value = "SELECT u.* FROM user u WHERE u.id IN(?1)",
        nativeQuery = true
    )
    Set<User> searchUsersById( Set<Long> ids );
}