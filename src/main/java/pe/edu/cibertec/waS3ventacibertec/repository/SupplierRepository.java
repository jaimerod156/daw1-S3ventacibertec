package pe.edu.cibertec.waS3ventacibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
