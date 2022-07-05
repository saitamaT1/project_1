package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/07/01 11:40
 */

public class GoodsOfOrdersVO {
    /**
     * unitPrice : 20
     * img : http://192.168.1.100:8084/static/image/1571232357917156699698343520190828203349.jpg
     * goodsDetailId : 1269
     * name : 新西兰进口番薯
     * id : 490
     * spec : 2KG
     */
    private Double unitPrice;
    private String img;
    private int goodsDetailId;
    private String name;
    private int id;
    private String spec;

    public GoodsOfOrdersVO(Double unitPrice, String img, int goodsDetailId, String name, int id, String spec) {
        this.unitPrice = unitPrice;
        this.img = img;
        this.goodsDetailId = goodsDetailId;
        this.name = name;
        this.id = id;
        this.spec = spec;
    }

    public GoodsOfOrdersVO() {
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGoodsDetailId(int goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public String getImg() {
        return img;
    }

    public int getGoodsDetailId() {
        return goodsDetailId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSpec() {
        return spec;
    }
}
