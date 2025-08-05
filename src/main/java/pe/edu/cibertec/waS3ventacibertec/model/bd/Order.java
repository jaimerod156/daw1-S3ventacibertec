package pe.edu.cibertec.waS3ventacibertec.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data //encapsula los atributo de la clase
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderid=0;

    @Column(name = "OrderDate")
    private Date orderdate;

    @Column(name = "RequiredDate")
    private Date requireddate;

    @Column(name = "ShippedDate")
    private Date shippeddate;

    @Column(name = "ShipVia")
    private Integer shipvia;

    @Column(name = "Freight")
    private Double freight;

    @Column(name = "ShipName")
    private String shipname;

    @Column(name = "ShipAddress")
    private String shipaddress;

    @Column(name = "ShipCity")
    private String shipcity;

    @Column(name = "ShipRegion")
    private String shipregion;

    @Column(name = "ShipPostalCode")
    private String shippostalcode;

    @Column(name = "ShipCountry")
    private String shipcountry;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;


}
