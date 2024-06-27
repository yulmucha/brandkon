package practice.brandkon.brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandRestController {

    private final BrandService brandService;

    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

    // GET /brands?categoryId=6
    @GetMapping("/brands")
    public List<BrandResponse> findAll(@RequestParam Long categoryId) {
        return brandService.findAll(categoryId);
    }
}
