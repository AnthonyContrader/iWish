package com.it.contrader.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Wallet entity.
 */
public class WalletDTO implements Serializable {

    private Long id;

    @NotNull
    private Float totalmoney;

    @NotNull
    private Float revenue;

    @NotNull
    private Float outputs;

    @NotNull
    private Instant date;

    @NotNull
    private String ownerUsername;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public Float getOutputs() {
        return outputs;
    }

    public void setOutputs(Float outputs) {
        this.outputs = outputs;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WalletDTO walletDTO = (WalletDTO) o;
        if (walletDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), walletDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WalletDTO{" +
            "id=" + getId() +
            ", totalmoney=" + getTotalmoney() +
            ", revenue=" + getRevenue() +
            ", outputs=" + getOutputs() +
            ", date='" + getDate() + "'" +
            ", ownerUsername='" + getOwnerUsername() + "'" +
            "}";
    }
}
