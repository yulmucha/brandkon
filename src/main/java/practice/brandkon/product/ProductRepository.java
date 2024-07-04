package practice.brandkon.product;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findById(Long id);

    List<Product> findAllByOrderBySalesDesc();

    List<Product> findAllByBrandId(Long brandId);

    List<Product> findAllByBrandIdOrderBySalesDesc(Long brandId);
}
