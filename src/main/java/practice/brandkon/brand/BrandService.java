package practice.brandkon.brand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

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
