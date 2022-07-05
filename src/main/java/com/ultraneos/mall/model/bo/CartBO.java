package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/07/01 14:14
 */

public class CartBO {

    /**
     * amount : 1000
     * id : 17
     * goodsNum : 10
     */
    private Double amount;
    private int id;
    private int goodsNum;

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public int getGoodsNum() {
        return goodsNum;
    }
}
