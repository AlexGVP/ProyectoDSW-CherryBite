package cib.edu.pe.ProyectoDSW_CherryBite.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NoticiaDto {
    private Integer idnoticia;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Date fecha;
}
