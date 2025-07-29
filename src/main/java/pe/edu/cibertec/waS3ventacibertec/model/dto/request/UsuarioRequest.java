package pe.edu.cibertec.waS3ventacibertec.model.dto.request;

import lombok.Data;

@Data
public class UsuarioRequest {
//atributos que podemos cambiar
    private Integer idusuario;
    private String nomusuario;
    private String password;
    private String nombres;
    private String apellidos;
    private Boolean activo;
    private String email;
}
