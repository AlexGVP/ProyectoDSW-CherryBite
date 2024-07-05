package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Noticia;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.NoticiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoticiaService implements INoticiaService{

    private NoticiaRepository noticiaRepository;

    @Override
    public List<Noticia> noticiaList() {
        return noticiaRepository.findAll();
    }
}
