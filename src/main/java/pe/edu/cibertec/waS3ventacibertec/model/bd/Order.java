package pe.edu.cibertec.waS3ventacibertec.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data //encapsula los atributo de la clase
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderid=0;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    @Column(name = "OrderDate")
    private Date orderdate;


}
