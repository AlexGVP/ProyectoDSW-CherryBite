package cib.edu.pe.ProyectoDSW_CherryBite.service;


import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioPorNomUsuario(String nomususario);
}
