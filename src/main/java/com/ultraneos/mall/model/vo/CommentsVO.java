package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/07/01 17:36
 */

public class CommentsVO {

    /**
     * score : 80
     * specName : 2KG
     * comment : 6666666666666666666666666
     * id : 122
     * time : 2022-07-01 10:22:20
     * user : {"nickname":"rose"}
     * userId : 62
     */
    private int score;
    private String specName;
    private String comment;
    private int id;
    private String time;
    private UserVO user;
    private int userId;

    public CommentsVO(int score, String specName, String comment, int id, String time, UserVO user, int userId) {
        this.score = score;
        this.specName = specName;
        this.comment = comment;
        this.id = id;
        this.time = time;
        this.user = user;
        this.userId = userId;
    }

    public CommentsVO() {
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public String getSpecName() {
        return specName;
    }

    public String getComment() {
        return comment;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public UserVO getUser() {
        return user;
    }

    public int getUserId() {
        return userId;
    }
}
