package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/07/01 16:50
 */

public class CommentsBO {

    /**
     * score : 80
     * orderId : 25
     * goodsId : 11
     * goodsDetailId : 5
     * content : sad
     * token : 1231231231@qq.com
     */
    private int score;
    private int orderId;
    private int goodsId;
    private int goodsDetailId;
    private String content;
    private String token;

    public void setScore(int score) {
        this.score = score;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsDetailId(int goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getScore() {
        return score;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getGoodsDetailId() {
        return goodsDetailId;
    }

    public String getContent() {
        return content;
    }

    public String getToken() {
        return token;
    }
}
