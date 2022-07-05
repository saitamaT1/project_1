package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/29 21:39
 */
@Data
public class Orders {
    private Integer id;
    private Integer userId;
    private String nickname;
    private String receiver;
    private String address;
    private String phone;
    private String goods;
    private Integer goodsId;
    private String spec;
    private Integer specId;
    private Integer number;
    private Double amount;
    private Integer stateId;
    private String state;
    private String createTime;
    private Integer score;
    private boolean hasComment;

    public Orders() {
    }

    public Orders(Integer id, Integer userId, String nickname, String receiver, String address, String phone, String goods, Integer goodsId, String spec, Integer specId, Integer number, Double amount, Integer stateId, String state, String createTime, Integer score, boolean hasComment) {
        this.id = id;
        this.userId = userId;
        this.nickname = nickname;
        this.receiver = receiver;
        this.address = address;
        this.phone = phone;
        this.goods = goods;
        this.goodsId = goodsId;
        this.spec = spec;
        this.specId = specId;
        this.number = number;
        this.amount = amount;
        this.stateId = stateId;
        this.state = state;
        this.createTime = createTime;
        this.score = score;
        this.hasComment = hasComment;
    }
}
