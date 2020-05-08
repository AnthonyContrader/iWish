package com.it.contrader.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Wallet.
 */
@Entity
@Table(name = "wallet")
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "totalmoney", nullable = false)
    private Float totalmoney;

    @NotNull
    @Column(name = "revenue", nullable = false)
    private Float revenue;

    @NotNull
    @Column(name = "outputs", nullable = false)
    private Float outputs;

    @NotNull
    @Column(name = "proprietario_id", nullable = false)
    private Integer proprietario_id;

    @NotNull
    @Column(name = "jhi_date", nullable = false)
    private Instant date;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public Wallet totalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
        return this;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Float getRevenue() {
        return revenue;
    }

    public Wallet revenue(Float revenue) {
        this.revenue = revenue;
        return this;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public Float getOutputs() {
        return outputs;
    }

    public Wallet outputs(Float outputs) {
        this.outputs = outputs;
        return this;
    }

    public void setOutputs(Float outputs) {
        this.outputs = outputs;
    }

    public Integer getProprietario_id() {
        return proprietario_id;
    }

    public Wallet proprietario_id(Integer proprietario_id) {
        this.proprietario_id = proprietario_id;
        return this;
    }

    public void setProprietario_id(Integer proprietario_id) {
        this.proprietario_id = proprietario_id;
    }

    public Instant getDate() {
        return date;
    }

    public Wallet date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
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
        Wallet wallet = (Wallet) o;
        if (wallet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), wallet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Wallet{" +
            "id=" + getId() +
            ", totalmoney=" + getTotalmoney() +
            ", revenue=" + getRevenue() +
            ", outputs=" + getOutputs() +
            ", proprietario_id=" + getProprietario_id() +
            ", date='" + getDate() + "'" +
            "}";
    }
}
