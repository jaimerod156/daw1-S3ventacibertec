package pe.edu.cibertec.waS3ventacibertec.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data //encapsula los atributo de la clase
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Integer employeeid=0;

    @Column(name = "LastName")
    private String lastname;

    @Column(name = "FirstName")
    private String firstname;

    @Column(name = "Title")
    private String title;

    @Column(name = "TitleOfCourtesy")
    private String titleofcourtesy;

    @Column(name = "BirthDate")
    private Date birthdate;

    @Column(name = "HireDate")
    private Date hiredate;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "PostalCode")
    private String postalcode;

    @Column(name = "Country")
    private String country;

    @Column(name = "HomePhone")
    private String homephone;

    @Column(name = "Extension")
    private String extension;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "Reportsto")
    private Integer reportsto;

    @Column(name = "PhotoPath")
    private String photopath;

    @Column(name = "Salary")
    private Double salary;


    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Order> listaOrdersEmployee;
}
