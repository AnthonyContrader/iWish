package com.it.contrader.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Progress.
 */
@Entity
@Table(name = "progress")
public class Progress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "cash", nullable = false)
    private Float cash;

    @NotNull
    @Column(name = "data", nullable = false)
    private LocalDate data;

    @NotNull
    @Column(name = "expectation", nullable = false)
    private Double expectation;

    @NotNull
    @Column(name = "jhi_time", nullable = false)
    private Double time;

    @OneToOne
    @JoinColumn(unique = true)
    private Product prodotto_id;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCash() {
        return cash;
    }

    public Progress cash(Float cash) {
        this.cash = cash;
        return this;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public LocalDate getData() {
        return data;
    }

    public Progress data(LocalDate data) {
        this.data = data;
        return this;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getExpectation() {
        return expectation;
    }

    public Progress expectation(Double expectation) {
        this.expectation = expectation;
        return this;
    }

    public void setExpectation(Double expectation) {
        this.expectation = expectation;
    }

    public Double getTime() {
        return time;
    }

    public Progress time(Double time) {
        this.time = time;
        return this;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Product getProdotto_id() {
        return prodotto_id;
    }

    public Progress prodotto_id(Product product) {
        this.prodotto_id = product;
        return this;
    }

    public void setProdotto_id(Product product) {
        this.prodotto_id = product;
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
        Progress progress = (Progress) o;
        if (progress.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), progress.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Progress{" +
            "id=" + getId() +
            ", cash=" + getCash() +
            ", data='" + getData() + "'" +
            ", expectation=" + getExpectation() +
            ", time=" + getTime() +
            "}";
    }
}
