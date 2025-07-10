package pe.edu.cibertec.waS3ventacibertec.model.service;

import pe.edu.cibertec.waS3ventacibertec.model.bd.Product;

import java.util.List;

public interface IProductService {

    List<Product> listProduct();
    void RegisterProduct(Product p);

}
