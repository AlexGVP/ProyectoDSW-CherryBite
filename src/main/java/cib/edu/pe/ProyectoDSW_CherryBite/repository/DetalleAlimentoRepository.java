package cib.edu.pe.ProyectoDSW_CherryBite.repository;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Rol;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk.AlimentoUsuarioID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleAlimentoRepository extends JpaRepository<DetalleAlimento, AlimentoUsuarioID> {
}
