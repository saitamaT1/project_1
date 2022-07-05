package com.ultraneos.mall.model.bo;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/29 18:57
 */

public class UpdateGoodsBO {

    /**
     * img : static/image/c/6/b/f/e/8/7/6/9aeba53c-87b1-4960-83da-3bd7c45062bd-微信图片_20220607170619.jpg
     * name : asddd
     * specList : [{"unitPrice":11,"specName":"111","stockNum":11,"id":29}]
     * typeId : 3
     * id : 18
     * desc :
     */
    private String img;
    private String name;
    private List<UpdateGoodsSpecBO> specList;
    private Integer typeId;
    private Integer id;
    private String desc;

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecList(List<UpdateGoodsSpecBO> specList) {
        this.specList = specList;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public List<UpdateGoodsSpecBO> getSpecList() {
        return specList;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }



}
