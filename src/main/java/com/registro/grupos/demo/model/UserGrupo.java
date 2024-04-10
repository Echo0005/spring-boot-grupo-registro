package com.registro.grupos.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "user_grupo" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGrupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private User user;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "grupo_id" )
    private Grupo grupo;
}