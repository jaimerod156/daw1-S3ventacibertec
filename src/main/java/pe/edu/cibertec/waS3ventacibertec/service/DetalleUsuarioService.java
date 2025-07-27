package pe.edu.cibertec.waS3ventacibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Rol;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Usuario;
import pe.edu.cibertec.waS3ventacibertec.model.dto.security.UsuarioSecurity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private IUsuarioService iUsuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioService.findUserByNomUsuario(username);
        return autenticacionUsuario(usuario, obtenerListaRolesUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listaRoles){
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        for(Rol rol: listaRoles){
            grantedAuthorityList.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        return grantedAuthorityList;
    }

    private UserDetails autenticacionUsuario(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        UsuarioSecurity usuarioSecurity = new UsuarioSecurity(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(), true,
                true, true,
                authorityList
        );
        usuarioSecurity.setEmail(usuario.getEmail());
        usuarioSecurity.setNombre(usuario.getNombres());
        return usuarioSecurity;

    }
}
