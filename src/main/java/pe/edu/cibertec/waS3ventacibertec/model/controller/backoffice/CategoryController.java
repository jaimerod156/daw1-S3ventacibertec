package pe.edu.cibertec.waS3ventacibertec.model.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Category;
import pe.edu.cibertec.waS3ventacibertec.model.service.ICategoryService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {


    private ICategoryService icategoryService;


    @GetMapping("/listar")
    public String listarCategorias(Model model){
        List<Category> lista = icategoryService.listarCategorias();
        model.addAttribute("categorias", lista);
        return "backoffice/category/frmcategory";
    }
}
