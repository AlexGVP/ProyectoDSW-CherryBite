package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idnoticia;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Date fecha;
}