package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(String nomususario) {
        return usuarioRepository.findByNomusuario(nomususario);
    }
}
