package com.registro.grupos.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGrupoDTO
{
    private Long id;
    private Long userId;
    private Long grupoId;
}
