package com.ultraneos.mall.model.vo;


import com.ultraneos.mall.util.Constant;


public class GetGoodsByTypeVO {

    private String img;
    private Double price;
    private String name;
    private Integer stockNum;
    private Integer typeId;
    private Integer id;

    public void setImg(String img) {
        this.img =  Constant.DOMAIN + img;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getStockNum() {
        return stockNum;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getId() {
        return id;
    }
}
