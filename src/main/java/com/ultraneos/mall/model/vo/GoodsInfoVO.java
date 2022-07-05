package com.ultraneos.mall.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/29 15:29
 */
@Data
public class GoodsInfoVO {

    private List<SpecVO> specs;
    private GoodsVO goods;

    public GoodsInfoVO(List<SpecVO> specs, GoodsVO goods) {
        this.specs = specs;
        this.goods = goods;
    }

    public GoodsInfoVO() {
    }
}
