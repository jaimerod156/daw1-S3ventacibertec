package pe.edu.cibertec.waS3ventacibertec.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data //encapsula los atributo de la clase
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Integer productoid=0;

    //@Column(name = "ProductName")
    private String product_name;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    @Column(name = "quantity_per_unit")
    private String quantityperunit;

    @Column(name = "unit_price")
    private Double unitprice;

    @Column(name = "units_in_stock")
    private Integer unitsinstock;

    @Column(name = "units_on_order")
    private Integer unitsonorder;

    @Column(name = "reorder_level")
    private Integer reorderlevel;

    @Column(name = "Discontinued")
    private Boolean discontinued;


}
