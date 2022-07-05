package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/07/01 10:35
 */

public class ReplyVO {
    /**
     * time : 2022-07-01 09:51:17
     * content : 啊啊啊啊
     */
    private String time;
    private String content;

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public ReplyVO(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public ReplyVO() {
    }
}
