package com.pattysung.springbootmall.dto;

import javax.validation.constraints.NotNull;

public class BuyItem {
    private Integer productId;
    private Integer quantity;

    @NotNull
    public Integer getProductId() {
        return productId;
    }
    @NotNull
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
