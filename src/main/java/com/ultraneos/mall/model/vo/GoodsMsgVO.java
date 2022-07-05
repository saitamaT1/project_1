package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/07/01 10:32
 */

public class GoodsMsgVO {

    /**
     * asker : admin
     * id : 334
     * time : 2022-07-01 08:47:33
     * reply : {"time":"2022-07-01 09:51:17","content":"啊啊啊啊"}
     * content : 你这番薯上过大学吗？
     */
    private String asker;
    private int id;
    private String time;
    private ReplyVO reply;
    private String content;

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setReply(ReplyVO reply) {
        this.reply = reply;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAsker() {
        return asker;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public ReplyVO getReply() {
        return reply;
    }

    public String getContent() {
        return content;
    }

    public GoodsMsgVO(String asker, int id, String time, ReplyVO reply, String content) {
        this.asker = asker;
        this.id = id;
        this.time = time;
        this.reply = reply;
        this.content = content;
    }

    public GoodsMsgVO() {
    }
}
