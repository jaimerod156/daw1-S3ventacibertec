package pe.edu.cibertec.waS3ventacibertec.model.dto.request;

import lombok.Data;

@Data
public class ProductRequest {

    private Integer productId;
    private String productname;
    private Double unitprice;
    private Boolean discontinued;
    private Integer supplierid;
    private Integer categoryid;
}
