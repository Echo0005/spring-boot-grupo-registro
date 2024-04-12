package com.registro.grupos.demo.dto;

import java.util.Set;

import com.registro.grupos.demo.model.Grupo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO
{
    private Long id;
    private String name;
    private String avatar;

    private Set<Grupo> grupos;
}
