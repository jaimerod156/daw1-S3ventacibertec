package pe.edu.cibertec.waS3ventacibertec.service;

import pe.edu.cibertec.waS3ventacibertec.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario findUserByNomUsuario(String username);
    Usuario guardarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuarioxId(int id);
}
