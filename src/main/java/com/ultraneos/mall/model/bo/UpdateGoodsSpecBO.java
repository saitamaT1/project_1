package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/29 18:58
 */

public class UpdateGoodsSpecBO {
    /**
     * unitPrice : 11
     * specName : 111
     * stockNum : 11
     * id : 29
     */
    private Integer unitPrice;
    private String specName;
    private Integer stockNum;
    private Integer id;

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public String getSpecName() {
        return specName;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public Integer getId() {
        return id;
    }
}
