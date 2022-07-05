package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/29 09:43
 */
@Data
public class Goods {

    private  Integer id;

    private String name;

    private Integer typeId;

    private String image;

    private String description;

    private Double price;

    private Integer stockNum;

    public Goods(Integer id, String name, Integer typeId, String image, String description, Double price, Integer stockNum) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.image = image;
        this.description = description;
        this.price = price;
        this.stockNum = stockNum;
    }

    public Goods() {
    }

    public Goods(String name) {
        this.name = name;
    }
}
