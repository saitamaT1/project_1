package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/29 09:46
 */
@Data
public class Spec {

    private Integer id;

    private String name;

    private Integer stockNum;

    private Double price;

    private Integer goodsId;

    public Spec(Integer id, String name, Integer stockNum, Double price, Integer goodsId) {
        this.id = id;
        this.name = name;
        this.stockNum = stockNum;
        this.price = price;
        this.goodsId = goodsId;
    }

    public Spec() {
    }
}
