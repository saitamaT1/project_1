package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/07/01 17:00
 */
@Data
public class Comments {
    private Integer id;
    private String comment;
    private Integer score;
    private Integer goodsId;
    private String specName;
    private String time;
    private String nickname;
    private Integer userId;
    private Integer orderId;

    public Comments(Integer id, String comment, Integer score, Integer goodsId, String specName, String time, String nickname, Integer userId, Integer orderId) {
        this.id = id;
        this.comment = comment;
        this.score = score;
        this.goodsId = goodsId;
        this.specName = specName;
        this.time = time;
        this.nickname = nickname;
        this.userId = userId;
        this.orderId = orderId;
    }

    public Comments() {
    }

}
