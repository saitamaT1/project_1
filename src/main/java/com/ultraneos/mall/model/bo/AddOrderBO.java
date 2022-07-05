package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/30 23:19
 */

public class AddOrderBO {

    /**
     * amount : 200
     * goodsDetailId : 38
     * num : 2
     * state : 0
     * token : 1231231231@qq.com
     */
    private double amount;
    private int goodsDetailId;
    private int num;
    private int state;
    private String token;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setGoodsDetailId(int goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getAmount() {
        return amount;
    }

    public int getGoodsDetailId() {
        return goodsDetailId;
    }

    public int getNum() {
        return num;
    }

    public int getState() {
        return state;
    }

    public String getToken() {
        return token;
    }
}
