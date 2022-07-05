package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/29 16:41
 */

public class AddSpecBO {

    /**
     * unitPrice :
     * specName :
     * goodsId : 11
     * stockNum :
     */
    private double unitPrice;
    private String specName;
    private Integer goodsId;
    private Integer stockNum;

    public AddSpecBO() {
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public Integer getGoodsId() {
        return goodsId;
    }

    public Integer getStockNum() {
        return stockNum;
    }
}
