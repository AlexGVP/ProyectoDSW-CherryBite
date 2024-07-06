package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DatoDto implements DtoEntity{
    private Integer iddato;
    private String titulo;
    private String descripcion;
    private String imagen;
}
