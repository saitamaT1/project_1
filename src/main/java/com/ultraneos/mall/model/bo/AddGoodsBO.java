package com.ultraneos.mall.model.bo;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/29 10:26
 */

public class AddGoodsBO {

    /**
     * img :
     * name :
     * specList : [{"unitPrice":"1","specName":"默认","stockNum":"1"}]
     * typeId : 1
     * desc :
     */
    private String img;
    private String name;
    private List<AddGoodsSpecBO> specList;
    private Integer typeId;
    private String desc;


    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecList(List<AddGoodsSpecBO> specList) {
        this.specList = specList;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    public List<AddGoodsSpecBO> getSpecList() {
        return specList;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getDesc() {
        return desc;
    }
}
