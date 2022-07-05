package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/07/01 10:54
 */

public class AskMsgBO {

    /**
     * msg : 这番薯，不买能发货吗
     * goodsId : 490
     * token : admin
     */
    private String msg;
    private Integer goodsId;
    private String token;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public String getToken() {
        return token;
    }
}
