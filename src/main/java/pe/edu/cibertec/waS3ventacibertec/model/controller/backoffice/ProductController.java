package pe.edu.cibertec.waS3ventacibertec.model.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.waS3ventacibertec.model.service.IProductService;

@AllArgsConstructor
@Controller
@RequestMapping("/Product")
public class ProductController {

    private IProductService iProductService;

    public String formProduct(Model model){
        model.addAttribute("lista", iProductService.listProduct());
        return "backoffice/product/formProduct";
    }

}
