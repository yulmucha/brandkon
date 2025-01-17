package practice.brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    // GET /products?sort=POPULAR
    // GET /products?brandId=34&sort=RECENT
    // GET /products?brandId=34&sort=POPULAR
    // GET /products?categoryId=6&sort=POPULAR
    @GetMapping("/products")
    public List<ProductResponse> findAll(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String sort
    ) {
        System.out.println("GET /products 요청 받음 " + LocalDateTime.now());
        return productService.findAll(brandId, categoryId, sort);
    }

    @GetMapping("/products/{id}")
    public ProductDetailResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PatchMapping("/products/{id}")
    public void purchase(@PathVariable Long id) {
        System.out.println("PATCH /product/{id} 요청 받음 " + LocalDateTime.now());
        productService.incrementSales(id);
    }
}
