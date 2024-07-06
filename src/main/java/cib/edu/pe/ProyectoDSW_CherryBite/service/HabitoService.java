package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Habito;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.HabitoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HabitoService implements IHabitoService{

    private HabitoRepository habitoRepository;

    @Override
    public List<Habito> listarHabitos() {
            return habitoRepository.findAll();
    }
}