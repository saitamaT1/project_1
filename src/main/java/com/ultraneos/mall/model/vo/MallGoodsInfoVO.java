package com.ultraneos.mall.model.vo;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/30 11:56
 */

public class MallGoodsInfoVO {

    /**
     * unitPrice : 0
     * specs : [{"unitPrice":1000,"specName":"型号一","stockNum":976,"id":1248},{"unitPrice":2000,"specName":"型号二","stockNum":1000,"id":1249}]
     * img : http://192.168.1.100:8084/static/image/1571231038163156699833630520190828211347.jpg
     * name : 摄像机
     * typeId : 191
     * desc : 值得拥有,旅行必备12
     */
    private double unitPrice;
    private List<SpecVO> specs;
    private String img;
    private String name;
    private int typeId;
    private String desc;

    public MallGoodsInfoVO(double unitPrice, List<SpecVO> specs, String img, String name, int typeId, String desc) {
        this.unitPrice = unitPrice;
        this.specs = specs;
        this.img = img;
        this.name = name;
        this.typeId = typeId;
        this.desc = desc;
    }

    public MallGoodsInfoVO() {
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSpecs(List<SpecVO> specs) {
        this.specs = specs;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public List<SpecVO> getSpecs() {
        return specs;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getDesc() {
        return desc;
    }

}
