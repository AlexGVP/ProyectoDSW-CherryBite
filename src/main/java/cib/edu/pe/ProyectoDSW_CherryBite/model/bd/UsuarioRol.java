package cib.edu.pe.ProyectoDSW_CherryBite.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;
}
