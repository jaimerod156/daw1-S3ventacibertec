package pe.edu.cibertec.waS3ventacibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.waS3ventacibertec.model.bd.OrderDetail;
import pe.edu.cibertec.waS3ventacibertec.model.bd.pk.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,OrderDetailId> {
}
