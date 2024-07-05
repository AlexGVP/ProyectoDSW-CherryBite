package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CategoriaDto {
    private Integer idcategoria;
    private String descripcion;
    private Set<HabitoDto> habitos;
}
