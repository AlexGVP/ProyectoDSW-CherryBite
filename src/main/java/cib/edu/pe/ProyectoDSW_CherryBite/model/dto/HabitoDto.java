package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HabitoDto implements DtoEntity{
    private Integer idhabito;
    private String descripcion;
    private Integer idcategoria;
    private String frecuencia;
    private Date horadia;
    private Date fechainicio;
    private Date fechafin;
    private Integer progreso;
}