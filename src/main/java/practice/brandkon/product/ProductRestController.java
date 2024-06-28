package practice.brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductRestController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/products/mybatis")
    public List<ProductDao> findAllMybatis(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String sort
    ) {
        return productMapper.findAll(brandId, categoryId, sort);
    }

    // GET /products?sort=POPULAR
    // GET /products?brandId=34&sort=RECENT
    // GET /products?brandId=34&sort=POPULAR
    // GET /products?categoryId=6&sort=POPULAR
    @GetMapping("/products")
    public List<ProductResponse> findAll(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam String sort
    ) {
        return productService.findAll(brandId, categoryId, sort);
    }

    @GetMapping("/products/{id}")
    public ProductDetailResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
