package pe.edu.cibertec.waS3ventacibertec.model.dto.request;

import lombok.Data;

@Data
public class UsuarioRequest {
//atributos que podemos cambiar
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private String activo;
    private String email;
}
