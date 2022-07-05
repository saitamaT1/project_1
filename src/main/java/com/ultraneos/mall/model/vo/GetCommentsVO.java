package com.ultraneos.mall.model.vo;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/07/01 18:09
 */

public class GetCommentsVO {

    /**
     * commentList : [{"score":80,"specName":"2KG","comment":"6666666666666666666666666","id":122,"time":"2022-07-01 10:22:20","user":{"nickname":"rose"},"userId":62},{"score":100,"specName":"4KG","comment":"卧槽，无语了","id":125,"time":"2022-07-01 11:42:33","user":{"nickname":"admin"},"userId":1},{"score":100,"specName":"2KG","comment":"好次捏","id":130,"time":"2022-07-01 16:30:51","user":{"nickname":"asdf"},"userId":90},{"score":100,"specName":"2KG","comment":"rgrhehhegherg","id":132,"time":"2022-07-01 16:39:35","user":{"nickname":"admin"},"userId":1}]
     * rate : 75
     */
    private List<CommentsVO> commentList;
    private String rate;

    public void setCommentList(List<CommentsVO> commentList) {
        this.commentList = commentList;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<CommentsVO> getCommentList() {
        return commentList;
    }

    public String getRate() {
        return rate;
    }

    public GetCommentsVO(List<CommentsVO> commentList, String rate) {
        this.commentList = commentList;
        this.rate = rate;
    }

    public GetCommentsVO() {
    }
}
