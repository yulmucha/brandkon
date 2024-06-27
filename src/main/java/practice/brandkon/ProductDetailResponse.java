package practice.brandkon;

public record ProductDetailResponse(
        long productId,
        String productName,
        long brandId,
        String brandName,
        long price,
        int expiryTime
) {
}
