package pe.edu.cibertec.waS3ventacibertec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
