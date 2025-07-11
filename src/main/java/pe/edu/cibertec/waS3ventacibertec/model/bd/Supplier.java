package pe.edu.cibertec.waS3ventacibertec.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //encapsula los atributo de la clase
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplierid=0;

    @Column(name = "company_name")
    private String companyname;

    @Column(name = "contact_name")
    private String contactname;

    @Column(name = "contact_title")
    private String contactitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String Region;

    @Column(name = "postal_code")
    private String postalcode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "home_page")
    private String homepage;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Product> listaProductos;

}
