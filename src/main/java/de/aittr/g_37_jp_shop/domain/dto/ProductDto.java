package de.aittr.g_37_jp_shop.domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    private Long id;
    private String title;
    private BigDecimal price;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto dto = (ProductDto) o;
        return Objects.equals(id, dto.id) && Objects.equals(title, dto.title) && Objects.equals(price, dto.price) && Objects.equals(image, dto.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, image);
    }

    @Override
    public String toString() {
        return String.format("Product: ID - %d, title - %s, price - %.2f",
                id, title, price);
    }
}