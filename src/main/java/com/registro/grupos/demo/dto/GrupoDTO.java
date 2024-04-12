package com.registro.grupos.demo.dto;

import java.util.Set;

import com.registro.grupos.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDTO
{
    private Long id;
    private String name;
    private String logo;

    private Set<User> users;
}
