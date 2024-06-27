package practice.brandkon.product;

public record ProductResponse(
        long productId,
        String imageUrl,
        long price,
        String productName,
        String brandName
) {
}
