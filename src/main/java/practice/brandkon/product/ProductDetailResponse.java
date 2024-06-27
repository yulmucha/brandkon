package practice.brandkon.product;

public record ProductDetailResponse(
        long productId,
        String productName,
        long brandId,
        String brandName,
        long price,
        int expiryTime
) {
}
