package practice.brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandRestController {

    @GetMapping("/brands")
    public List<BrandResponse> findAll() {
        return null;
    }
}
