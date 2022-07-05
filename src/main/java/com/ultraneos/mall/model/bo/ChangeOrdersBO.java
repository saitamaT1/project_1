package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/30 19:59
 */

public class ChangeOrdersBO {

    /**
     * num : 980
     * id : 10
     * state : 0
     * spec : 854
     */
    private int num;
    private String id;
    private int state;
    private int spec;

    public void setNum(int num) {
        this.num = num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setSpec(int spec) {
        this.spec = spec;
    }

    public int getNum() {
        return num;
    }

    public String getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public int getSpec() {
        return spec;
    }
}
