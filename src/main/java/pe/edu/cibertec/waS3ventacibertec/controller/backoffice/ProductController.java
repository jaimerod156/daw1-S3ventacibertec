package pe.edu.cibertec.waS3ventacibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Category;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Product;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Supplier;
import pe.edu.cibertec.waS3ventacibertec.model.dto.request.ProductRequest;
import pe.edu.cibertec.waS3ventacibertec.model.dto.response.ProductResponse;
import pe.edu.cibertec.waS3ventacibertec.service.IProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    private IProductService iProductService;

    @GetMapping("")
    public String formProduct(Model model){
        model.addAttribute("listProduct", iProductService.listProduct());
        return "backoffice/product/formProduct";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product> listProducts(){
        return iProductService.listProduct();
    }

    @PostMapping("/register")
    @ResponseBody
    public ProductResponse RegisterProduct(@RequestBody ProductRequest productRequest){
        String mensaje = "Producto registrado correctamente";
        boolean respuesta = true;
        try{
            Product product = new Product();
            if(productRequest.getProductId() > 0){
                product.setProductoid(productRequest.getProductId());
            }
            product.setProduct_name(productRequest.getProductname());
            product.setUnitprice(productRequest.getUnitprice());
            product.setDiscontinued(productRequest.getDiscontinued());

            Category category = new Category();
            category.setCategoryid(productRequest.getCategoryid());

            product.setCategory(category);

            Supplier supplier = new Supplier();
            supplier.setSupplierid(productRequest.getSupplierid());

            product.setSupplier(supplier);
            iProductService.RegisterProduct(product);

        }catch(Exception ex){
            mensaje="Producto no registrado. Error en la Base de Datos";
            respuesta = false;
        }

        return ProductResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
