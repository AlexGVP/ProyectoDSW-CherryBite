package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GrupoAlimentoDto implements DtoEntity{
    private Integer idgrupoalimento;
    private String descripcion;
    private Set<AlimentoDto> alimentos;
}
