package pe.edu.cibertec.waS3ventacibertec.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.cibertec.waS3ventacibertec.model.bd.pk.OrderDetailId;

@Data
@NoArgsConstructor
@Entity
@Table(name="order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId orderDetailId;//llave primaria compuesta

    @Column(name = "UnitPrice")
    private Double unitprice;
    @Column(name="Quantity")
    private Integer quantity;
    @Column(name="Discount")
    private Double discount;

}
