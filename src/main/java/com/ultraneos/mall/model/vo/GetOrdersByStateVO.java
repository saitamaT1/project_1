package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/07/01 11:36
 */

public class GetOrdersByStateVO {

    /**
     * amount : 20
     * createtime : 2022-07-01 11:22:20
     * goodsDetailId : 1269
     * goods : {"unitPrice":20,"img":"http://192.168.1.100:8084/static/image/1571232357917156699698343520190828203349.jpg","goodsDetailId":1269,"name":"新西兰进口番薯","id":490,"spec":"2KG"}
     * id : 1861
     * state : 0
     * hasComment : false
     * goodsNum : 1
     */
    private Double amount;
    private String createtime;
    private int goodsDetailId;
    private GoodsOfOrdersVO goods;
    private int id;
    private int state;
    private boolean hasComment;
    private int goodsNum;

    public GetOrdersByStateVO(Double amount, String createtime, int goodsDetailId, GoodsOfOrdersVO goods, int id, int state, boolean hasComment, int goodsNum) {
        this.amount = amount;
        this.createtime = createtime;
        this.goodsDetailId = goodsDetailId;
        this.goods = goods;
        this.id = id;
        this.state = state;
        this.hasComment = hasComment;
        this.goodsNum = goodsNum;
    }

    public GetOrdersByStateVO() {
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setGoodsDetailId(int goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public void setGoods(GoodsOfOrdersVO goods) {
        this.goods = goods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public int getGoodsDetailId() {
        return goodsDetailId;
    }

    public GoodsOfOrdersVO getGoods() {
        return goods;
    }

    public int getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

}
