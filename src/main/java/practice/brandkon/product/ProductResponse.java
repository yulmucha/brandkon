package practice.brandkon.product;

public record ProductResponse(
        long productId,
        String imageUrl,
        String productName,
        long price,
        String brandName
) {
}
