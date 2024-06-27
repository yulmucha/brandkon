package practice.brandkon.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll(Long brandId, Long categoryId, String sort) {
        if (brandId != null) {
            if (sort.equals("POPULAR")) {
                return productRepository.findAllByBrandIdOrderBySalesDesc(brandId).stream()
                        .map(p -> new ProductResponse(
                                p.getId(),
                                p.getImageUrl(),
                                p.getPrice(),
                                p.getName(),
                                p.getBrand().getName()))
                        .toList();
            } else {
                return productRepository.findAllByBrandId(brandId)
                        .stream()
                        .map(p -> new ProductResponse(
                                p.getId(),
                                p.getImageUrl(),
                                p.getPrice(),
                                p.getName(),
                                p.getBrand().getName()))
                        .toList();
            }
        }

        if (categoryId != null) {
            if (sort.equals("POPULAR")) {
                return productRepository.findAllByCategoryIdOrderBySalesDesc(categoryId)
                        .stream()
                        .map(p -> new ProductResponse(
                                p.getId(),
                                p.getImageUrl(),
                                p.getPrice(),
                                p.getName(),
                                p.getBrand().getName()))
                        .toList();
            } else {
                return productRepository.findAllByCategoryId(categoryId)
                        .stream()
                        .map(p -> new ProductResponse(
                                p.getId(),
                                p.getImageUrl(),
                                p.getPrice(),
                                p.getName(),
                                p.getBrand().getName()))
                        .toList();
            }
        }

        if (sort.equals("POPULAR")) {
            return productRepository.findAllByOrderBySalesDesc()
                    .stream()
                    .map(p -> new ProductResponse(
                            p.getId(),
                            p.getImageUrl(),
                            p.getPrice(),
                            p.getName(),
                            p.getBrand().getName()))
                    .toList();
        }

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

    public ProductDetailResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElse(null);

        if (product == null) {
            throw new NoSuchElementException("상품을 찾을 수 없습니다 id: " + id);
        }

        return new ProductDetailResponse(
                product.getId(),
                product.getName(),
                product.getBrand().getId(),
                product.getBrand().getName(),
                product.getPrice(),
                product.getExpiryDays());
    }
}
