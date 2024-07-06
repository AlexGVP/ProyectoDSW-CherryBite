package cib.edu.pe.ProyectoDSW_CherryBite.service;


import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuario();
    Usuario obtenerUsuarioPorNomUsuario(String nomususario);
    Usuario agregarUsuario(Usuario nuevoUsuario);
    Usuario actualizarUsuario(Usuario usuarioActualizado);
}
