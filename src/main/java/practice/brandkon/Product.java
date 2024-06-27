package practice.brandkon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    @Column(nullable = false)
    private Long price;

    private Integer expiryDays;

    private Long sales;

    @ManyToOne
    private Brand brand;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getExpiryDays() {
        return expiryDays;
    }
}