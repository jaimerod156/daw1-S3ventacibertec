package pe.edu.cibertec.waS3ventacibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Product;
import pe.edu.cibertec.waS3ventacibertec.service.IProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/Product")
public class ProductController {

    private IProductService iProductService;

    public String formProduct(Model model){
        model.addAttribute("lista", iProductService.listProduct());
        return "backoffice/product/formProduct";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product> listProducts(){
        return iProductService.listProduct();
    }

    public void RegisterProduct(Product p){
        iProductService.RegisterProduct(p);
    }

}
