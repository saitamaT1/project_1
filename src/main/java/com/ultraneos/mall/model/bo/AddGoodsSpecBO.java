package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/29 10:28
 */

public class AddGoodsSpecBO {
    /**
     * unitPrice : 1
     * specName : 默认
     * stockNum : 1
     */
    private double unitPrice;
    private String specName;
    private Integer stockNum;

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getSpecName() {
        return specName;
    }

    public Integer getStockNum() {
        return stockNum;
    }
}
