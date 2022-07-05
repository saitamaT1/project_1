package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/07/01 08:53
 */

public class MsgReplyBO {

    /**
     * id : 1
     * content :
     */
    private Integer id;
    private String content;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
