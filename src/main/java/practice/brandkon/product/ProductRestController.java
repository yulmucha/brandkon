package practice.brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDetailResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
