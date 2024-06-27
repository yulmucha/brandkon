package practice.brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @GetMapping("/products")
    public List<ProductResponse> findAll() {
        return null;
    }
}
