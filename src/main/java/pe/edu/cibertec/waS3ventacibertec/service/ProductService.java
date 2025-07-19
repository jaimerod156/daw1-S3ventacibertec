package pe.edu.cibertec.waS3ventacibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Product;
import pe.edu.cibertec.waS3ventacibertec.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements IProductService{

    private ProductRepository productRepo;

    @Override
    public List<Product> listProduct() {
        return productRepo.findAll();
    }

    @Override
    public void RegisterProduct(Product p) {
        productRepo.save(p);
    }
}
