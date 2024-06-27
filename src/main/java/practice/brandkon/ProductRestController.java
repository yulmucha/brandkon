package practice.brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return null;
    }
}
