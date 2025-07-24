package pe.edu.cibertec.waS3ventacibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Rol;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Usuario;
import pe.edu.cibertec.waS3ventacibertec.repository.RolRepository;
import pe.edu.cibertec.waS3ventacibertec.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
     private UsuarioRepository usuarioRepository;
     private RolRepository rolRepository;

     private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

     @Override
     public Usuario findUserByNomUsuario(String username){
         return usuarioRepository.findByNomusuario(username);
     }

     @Override
     public Usuario guardarUsuario(Usuario usuario){
         usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
         usuario.setActivo(true);
         // Buscar el rol que le compete al usuario
         Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
         usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
         return usuarioRepository.save(usuario);
     }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioxId(int id) {
        Usuario usuario =usuarioRepository.findById(id).orElse(null);
        assert usuario != null;
        usuario.setPassword("");
        return usuario;
    }
}
