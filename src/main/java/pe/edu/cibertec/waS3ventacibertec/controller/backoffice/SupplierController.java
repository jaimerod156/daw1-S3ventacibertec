package pe.edu.cibertec.waS3ventacibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Supplier;
import pe.edu.cibertec.waS3ventacibertec.service.ISupplierService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/supplier")
public class SupplierController {

    private ISupplierService supplierService;

    @GetMapping("/get")
    @ResponseBody
    public List<Supplier> listSuppliers(){
        return supplierService.listSuppliers();
    }
}
