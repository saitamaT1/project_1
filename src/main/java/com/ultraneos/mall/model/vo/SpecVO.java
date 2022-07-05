package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/06/29 16:15
 */

public class SpecVO {

    /**
     * unitPrice : 1.0
     * specName : 滑稽
     * stockNum : 1
     * id : 1303
     */
    private double unitPrice;
    private String specName;
    private Integer stockNum;
    private Integer id;

    public void setUnitPrice(double unitPrice) {
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

    public double getUnitPrice() {
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

    public SpecVO(Integer id) {
        this.id = id;
    }

    public SpecVO() {
    }
}
