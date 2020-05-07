package com.it.contrader.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Progress entity.
 */
public class ProgressDTO implements Serializable {

    private Long id;

    @NotNull
    private Float cash;

    @NotNull
    private LocalDate data;

    @NotNull
    private Double expectation;

    @NotNull
    private Double time;

    private Long prodotto_idId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getExpectation() {
        return expectation;
    }

    public void setExpectation(Double expectation) {
        this.expectation = expectation;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Long getProdotto_idId() {
        return prodotto_idId;
    }

    public void setProdotto_idId(Long productId) {
        this.prodotto_idId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProgressDTO progressDTO = (ProgressDTO) o;
        if (progressDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), progressDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProgressDTO{" +
            "id=" + getId() +
            ", cash=" + getCash() +
            ", data='" + getData() + "'" +
            ", expectation=" + getExpectation() +
            ", time=" + getTime() +
            ", prodotto_id=" + getProdotto_idId() +
            "}";
    }
}
