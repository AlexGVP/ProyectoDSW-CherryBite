package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Dato;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.DatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DatoService implements IDatoService{

    private DatoRepository datoRepository;

    @Override
    public List<Dato> datoList() {
        return datoRepository.findAll();
    }
}
