package practice.brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductRestController {

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponse(
                        p.getId(),
                        p.getImageUrl(),
                        p.getPrice(),
                        p.getName(),
                        p.getBrand().getName()))
                .toList();
    }

    @GetMapping("/products/{id}")
    public ProductDetailResponse findById(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new NoSuchElementException("상품을 찾을 수 없습니다 id: " + id);
        }

        return new ProductDetailResponse(
                product.getId(),
                product.getName(),
                product.getBrand().getId(),
                product.getBrand().getName(),
                product.getPrice(),
                product.getExpiryDays());
    }
}
