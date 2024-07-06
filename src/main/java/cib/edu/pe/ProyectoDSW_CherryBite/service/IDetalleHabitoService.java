package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleHabito;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleHabitoDto;

import java.util.List;

public interface IDetalleHabitoService {
    List<DetalleHabito> listarDetalleHabito();
    DetalleHabito registrarHabito(DetalleHabitoDto detalleHabitoDto);
}
