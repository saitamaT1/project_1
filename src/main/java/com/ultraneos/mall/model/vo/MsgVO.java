package com.ultraneos.mall.model.vo;

import com.ultraneos.mall.model.po.Goods;
import com.ultraneos.mall.model.po.User;

/**
 * @author Saitama
 * @since 2022/06/30 21:54
 */

public class MsgVO {

    /**
     * createtime : 2022-06-30 08:03:30
     * goodsId : 497
     * goods : {"name":"简约餐桌"}
     * id : 317
     * replyContent : 不影响使用亲亲
     * state : 0
     * userId : 1
     * user : {"name":"admin"}
     * content : 敏感肌能用么
     */
    private String createtime;
    private Integer goodsId;
    private Goods goods;
    private Integer id;
    private String replyContent;
    private Integer state;
    private Integer userId;
    private User user;
    private String content;

    public MsgVO(String createtime, Integer goodsId, Goods goods, Integer id, String replyContent, Integer state, Integer userId, User user, String content) {
        this.createtime = createtime;
        this.goodsId = goodsId;
        this.goods = goods;
        this.id = id;
        this.replyContent = replyContent;
        this.state = state;
        this.userId = userId;
        this.user = user;
        this.content = content;
    }

    public MsgVO() {
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public Integer getId() {
        return id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public Integer getState() {
        return state;
    }

    public Integer getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }




}
