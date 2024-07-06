package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Alimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.DetalleAlimento;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.pk.AlimentoUsuarioID;
import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.DetalleAlimentoDto;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.AlimentoRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.DetalleAlimentoRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.UsuarioRepository;
import cib.edu.pe.ProyectoDSW_CherryBite.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DetalleAlimentoService implements IDetalleAlimentoService{

    private DetalleAlimentoRepository detalleAlimentoRepository;
    private UsuarioRepository usuarioRepository;
    private AlimentoRepository alimentoRepository;
    private DtoUtil dtoUtil;

    @Override
    public List<DetalleAlimento> listadoComidasRegistradas() {
        return detalleAlimentoRepository.findAll();
    }

    @Override
    public DetalleAlimento registrarAlimento(DetalleAlimentoDto detalleAlimentoDto) {
        DetalleAlimento detalleAlimento = convertToEntity(detalleAlimentoDto);
        return detalleAlimentoRepository.save(detalleAlimento);
    }

    private DetalleAlimento convertToEntity(DetalleAlimentoDto dto) {
        DetalleAlimento detalleAlimento = new DetalleAlimento();
        AlimentoUsuarioID id = new AlimentoUsuarioID();
        id.setIdusuario(dto.getIdusuario());
        id.setIdalimento(dto.getIdalimento());
        detalleAlimento.setId(id);
        detalleAlimento.setCantidad(dto.getCantidad());
        if (dto.getFecha() == null) {
            detalleAlimento.setFecha(new Date());
        } else {
            detalleAlimento.setFecha(dto.getFecha());
        }
        Optional<Usuario> usuario = usuarioRepository.findById(dto.getIdusuario());
        usuario.ifPresent(detalleAlimento::setUsuario);
        Optional<Alimento> alimento = alimentoRepository.findById(dto.getIdalimento());
        alimento.ifPresent(detalleAlimento::setAlimento);

        return detalleAlimento;
    }
}
