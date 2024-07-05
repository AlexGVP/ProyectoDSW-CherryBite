package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NoticiaDto implements DtoEntity{
    private Integer idnoticia;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Date fecha;
}
