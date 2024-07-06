package cib.edu.pe.ProyectoDSW_CherryBite.service;


import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleHabito;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.DetalleHabitoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DetalleHabitoService implements IDetalleHabitoService {
    DetalleHabitoRepository detalleHabitoRepository;

    @Override
    public List<DetalleHabito> listarDetalleHabito() {
        return detalleHabitoRepository.findAll();
    }
}
