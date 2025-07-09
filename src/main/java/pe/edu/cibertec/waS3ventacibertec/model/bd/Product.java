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

    @Column(name = "ProductName")
    private String productname;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    @Column(name = "QuantityPerUnit")
    private String quantityperunit;

    @Column(name = "UnitPrice")
    private Double unitprice;

    @Column(name = "UnitsInStock")
    private Integer unitsinstock;

    @Column(name = "UnitsOnOrder")
    private Integer unitsonorder;

    @Column(name = "ReorderLevel")
    private Integer reorderlevel;

    @Column(name = "Discontinued")
    private Boolean discontinued;


}
