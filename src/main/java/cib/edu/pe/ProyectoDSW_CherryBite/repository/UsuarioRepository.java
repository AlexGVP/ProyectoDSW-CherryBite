package cib.edu.pe.ProyectoDSW_CherryBite.repository;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByNomusuario(String nomusuario);
    Usuario findByNombres(String nombres);
}
