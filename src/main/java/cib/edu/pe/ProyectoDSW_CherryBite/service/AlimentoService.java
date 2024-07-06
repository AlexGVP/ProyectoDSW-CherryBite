package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Alimento;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.AlimentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlimentoService implements IAlimentoService{
    private AlimentoRepository alimentoRepository;
    @Override
    public List<Alimento> listarAlimentos() {
        return alimentoRepository.findAll();
    }
}
