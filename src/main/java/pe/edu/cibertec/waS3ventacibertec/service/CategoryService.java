package pe.edu.cibertec.waS3ventacibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Category;
import pe.edu.cibertec.waS3ventacibertec.repository.CategoryRepository;

import java.util.List;

//inyectamos a traves de Lombok
@AllArgsConstructor
@Service
public class CategoryService implements ICategoryService {

    private CategoryRepository repo;

    public List<Category> listarCategorias(){
        return repo.findAll();
    }
}
