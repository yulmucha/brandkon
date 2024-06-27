package practice.brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandRestController {

    private final BrandRepository brandRepository;

    public BrandRestController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brands")
    public List<BrandResponse> findAll() {
        return brandRepository.findAll()
                .stream()
                .map(b -> new BrandResponse(
                        b.getId(),
                        b.getImageUrl(),
                        b.getName()))
                .toList();
    }
}
