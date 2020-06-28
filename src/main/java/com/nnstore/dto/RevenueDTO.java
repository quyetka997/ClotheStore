package com.nnstore.dto;

public class RevenueDTO {

    private Integer month;

    private Double amount;

    public RevenueDTO() {
    }

    public RevenueDTO(Integer month, Double amount) {
        this.month = month;
        this.amount = amount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
