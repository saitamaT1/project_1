package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/06/29 22:26
 */

public class OrderInfoVO {

    /**
     * amount : 220
     * goodsDetailId : 1240
     * stateId : 1
     * goods : 新品外套
     * id : 1782
     * state : 未发货
     * userId : 1
     * goodsNum : 1
     * user : {"address":"admin","phone":"11111111111","nickname":"admin","name":"admin"}
     * spec : 米黄
     */
    private Double amount;
    private Integer goodsDetailId;
    private Integer stateId;
    private String goods;
    private Integer id;
    private String state;
    private Integer userId;
    private Integer goodsNum;
    private UserOfOrdersVO user;
    private String spec;

    public OrderInfoVO(Double amount, Integer goodsDetailId, Integer stateId, String goods, Integer id, String state, Integer userId, Integer goodsNum, UserOfOrdersVO user, String spec) {
        this.amount = amount;
        this.goodsDetailId = goodsDetailId;
        this.stateId = stateId;
        this.goods = goods;
        this.id = id;
        this.state = state;
        this.userId = userId;
        this.goodsNum = goodsNum;
        this.user = user;
        this.spec = spec;
    }

    public OrderInfoVO() {
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public void setUser (UserOfOrdersVO user) {
        this.user = user;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public String getGoods() {
        return goods;
    }

    public Integer getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public UserOfOrdersVO getUser() {
        return user;
    }

    public String getSpec() {
        return spec;
    }
}
