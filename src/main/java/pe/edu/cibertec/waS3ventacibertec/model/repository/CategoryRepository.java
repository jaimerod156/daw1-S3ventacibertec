package pe.edu.cibertec.waS3ventacibertec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
