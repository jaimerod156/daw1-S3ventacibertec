package pe.edu.cibertec.waS3ventacibertec.model.bd;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //encapsula los atributo de la clase
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "CustomerID")
    private String customerid="";

    @Column(name = "CompanyName")
    private String companyname;

    @Column(name = "ContactName")
    private String contactname;

    @Column(name = "ContactTitle")
    private String contactitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String Region;

    @Column(name = "PostalCode")
    private String postalcode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

}
