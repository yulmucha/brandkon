package practice.brandkon.product;

public record ProductDao(
        Long id,
        String productImageUrl,
        String productName,
        Long price,
        String brandName
) {
}
