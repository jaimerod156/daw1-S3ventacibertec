package pe.edu.cibertec.waS3ventacibertec.model.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.waS3ventacibertec.model.bd.Supplier;
import pe.edu.cibertec.waS3ventacibertec.model.repository.SupplierRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierService implements ISupplierService{

    private SupplierRepository supplierRepo;
    @Override
    public List<Supplier> listSuppliers() {
        return supplierRepo.findAll();
    }
}
