package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Alimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;

import java.util.List;

public interface IAlimentoService {
    List<Alimento> listarAlimentos();
}
