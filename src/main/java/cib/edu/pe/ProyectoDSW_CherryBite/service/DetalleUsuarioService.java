package cib.edu.pe.ProyectoDSW_CherryBite.service;

import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Rol;
import cib.edu.pe.ProyectoDSW_CherryBite.model.bd.Usuario;
import cib.edu.pe.ProyectoDSW_CherryBite.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomusuario(username);
        return autenticacionUsuario(
                usuario,
                obtenerListaRolesUsuario(usuario.getRoles())
        );
    }
    public List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol rol : listRoles) {
            roles.add(new SimpleGrantedAuthority("ROLE_"+ rol.getNomrol()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }


    public Usuario findByNomusuario(String usuario){
        return usuarioRepository.findByNomusuario(usuario);
    }

    private UserDetails autenticacionUsuario(
            Usuario usuario, List<GrantedAuthority> authorityList) {
        UserDetails userDetails = new User(usuario.getNomusuario(),
                usuario.getPassword(),
                true,
                true,
                true,
                true, authorityList);
        return userDetails;
    }

}
