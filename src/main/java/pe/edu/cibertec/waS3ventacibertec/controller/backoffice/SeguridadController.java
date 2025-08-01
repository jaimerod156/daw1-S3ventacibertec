package pe.edu.cibertec.waS3ventacibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Usuario;
import pe.edu.cibertec.waS3ventacibertec.model.dto.request.UsuarioRequest;
import pe.edu.cibertec.waS3ventacibertec.model.dto.response.ResultadoResponse;
import pe.edu.cibertec.waS3ventacibertec.service.IUsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    private IUsuarioService iUsuarioService;

    @GetMapping("/usuario")
    public String frmUsuario(Model model){
        model.addAttribute("listaUsuarios",iUsuarioService.listarUsuarios());
        return "backoffice/seguridad/formusuario";
    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuarioXId(@PathVariable("id") int id){
        return iUsuarioService.obtenerUsuarioxId(id);
    }

    @PostMapping("/usuario/registrar")
    @ResponseBody
    public ResultadoResponse registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){

        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try{
            Usuario usuario = new Usuario();
            if(usuarioRequest.getIdusuario() > 0){
                usuario.setIdusuario(usuarioRequest.getIdusuario());
            }else
                usuario.setPassword(usuarioRequest.getPassword()); //no actualizamos contraseña

            // atributos a actualzar
            usuario.setNombres(usuarioRequest.getNombres());
            usuario.setApellidos(usuarioRequest.getApellidos());
            usuario.setActivo(usuarioRequest.getActivo());
            iUsuarioService.guardarUsuario(usuario);
        }catch (Exception ex){
            mensaje = "Usuario no registrado. Error en la BD";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje)
                .respuesta(respuesta).build();
    }
}

