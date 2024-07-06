package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "dato")
public class Dato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddato;
    private String titulo;
    private String descripcion;
    private String imagen;
}