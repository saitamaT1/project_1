package com.ultraneos.mall.model.po;

/**
 * @author Saitama
 * @since 2022/06/29 09:14
 */

public class Type {

    /**
     * name : 电脑
     * id : 203
     */
    private String name;
    private Integer id;

    public Type(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Type() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
