package com.ultraneos.mall.model.vo;

import com.ultraneos.mall.util.Constant;

/**
 * @author Saitama
 * @since 2022/06/29 16:15
 */

public class GoodsVO {

    /**
     * unitPrice : 0.0
     * img : http://192.168.1.100:8084/static/image/1656380321908BQ{1~1UZ4){FDYO~%}`P3UX.jpg
     * name :
     * typeId : 190
     * id : 504
     * desc : 看戏
     */
    private double unitPrice;
    private String img;
    private String name;
    private Integer typeId;
    private Integer id;
    private String desc;

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setImg(String img) {
        this.img = Constant.DOMAIN+img;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
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
