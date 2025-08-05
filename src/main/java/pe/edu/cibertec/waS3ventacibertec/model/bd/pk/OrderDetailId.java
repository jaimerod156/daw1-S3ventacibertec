package pe.edu.cibertec.waS3ventacibertec.model.bd.pk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    private Integer orderid;
    private Integer productid;
}
