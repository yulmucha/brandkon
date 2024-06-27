package practice.brandkon;

public record ProductResponse(
        long productId,
        String imageUrl,
        long price,
        String productName,
        String brandName
) {
}
