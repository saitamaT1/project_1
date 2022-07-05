package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/30 21:27
 */
@Data
public class Msg {
    private Integer id;
    private String content;
    private String replyContent;
    private String goods;
    private String username;
    private String createTime;
    private String rCreateTime;
    private Integer state;
    private Integer userId;
    private Integer goodsId;

    public Msg() {
    }

    public Msg(Integer id, String content, String replyContent, String goods, String username, String createTime, String rCreateTime, Integer state, Integer userId, Integer goodsId) {
        this.id = id;
        this.content = content;
        this.replyContent = replyContent;
        this.goods = goods;
        this.username = username;
        this.createTime = createTime;
        this.rCreateTime = rCreateTime;
        this.state = state;
        this.userId = userId;
        this.goodsId = goodsId;
    }
}
