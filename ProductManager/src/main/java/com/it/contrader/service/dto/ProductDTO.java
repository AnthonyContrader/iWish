package com.it.contrader.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Product entity.
 */
public class ProductDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Float price;

    @Min(value = 0)
    @Max(value = 5)
    private Integer priority;

    @NotNull
    private Long proprietario_id;

    @Size(max = 2000000)
    private String image;

    private Long wishlist_fkId;

    private Long category_fkId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getProprietario_id() {
        return proprietario_id;
    }

    public void setProprietario_id(Long proprietario_id) {
        this.proprietario_id = proprietario_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getWishlist_fkId() {
        return wishlist_fkId;
    }

    public void setWishlist_fkId(Long wishListId) {
        this.wishlist_fkId = wishListId;
    }

    public Long getCategory_fkId() {
        return category_fkId;
    }

    public void setCategory_fkId(Long categoryId) {
        this.category_fkId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (productDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", priority=" + getPriority() +
            ", proprietario_id=" + getProprietario_id() +
            ", image='" + getImage() + "'" +
            ", wishlist_fk=" + getWishlist_fkId() +
            ", category_fk=" + getCategory_fkId() +
            "}";
    }
}
