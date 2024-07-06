package cib.edu.pe.ProyectoDSW_CherryBite.repository;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {
}
