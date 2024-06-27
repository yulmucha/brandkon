package practice.brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestController {

    @GetMapping("/categories")
    public List<CategoryResponse> findAll() {
        return null;
    }
}
