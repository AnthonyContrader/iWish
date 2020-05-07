package com.it.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private Float price;

    @Min(value = 0)
    @Max(value = 5)
    @Column(name = "priority")
    private Integer priority;

    @NotNull
    @Column(name = "proprietario_id", nullable = false)
    private Long proprietario_id;

    @Size(max = 2000000)
    @Column(name = "image", length = 2000000)
    private String image;

    @ManyToOne
    @JsonIgnoreProperties("")
    private WishList wishlist_fk;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Category category_fk;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public Product price(Float price) {
        this.price = price;
        return this;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getPriority() {
        return priority;
    }

    public Product priority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getProprietario_id() {
        return proprietario_id;
    }

    public Product proprietario_id(Long proprietario_id) {
        this.proprietario_id = proprietario_id;
        return this;
    }

    public void setProprietario_id(Long proprietario_id) {
        this.proprietario_id = proprietario_id;
    }

    public String getImage() {
        return image;
    }

    public Product image(String image) {
        this.image = image;
        return this;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public WishList getWishlist_fk() {
        return wishlist_fk;
    }

    public Product wishlist_fk(WishList wishList) {
        this.wishlist_fk = wishList;
        return this;
    }

    public void setWishlist_fk(WishList wishList) {
        this.wishlist_fk = wishList;
    }

    public Category getCategory_fk() {
        return category_fk;
    }

    public Product category_fk(Category category) {
        this.category_fk = category;
        return this;
    }

    public void setCategory_fk(Category category) {
        this.category_fk = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        if (product.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", priority=" + getPriority() +
            ", proprietario_id=" + getProprietario_id() +
            ", image='" + getImage() + "'" +
            "}";
    }
}
