package com.ultraneos.mall.model.bo;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/07/01 15:56
 */

public class CartListBo {

    /**
     * cartList : [{"amount":80,"id":16,"goodsNum":2},
     * {"amount":1000,"id":17,"goodsNum":10},
     * {"amount":40,"id":19,"goodsNum":1},
     * {"amount":40,"id":23,"goodsNum":1},
     * {"amount":40,"id":24,"goodsNum":1}]
     */
    private List<CartBO> cartList;

    public void setCartList(List<CartBO> cartList) {
        this.cartList = cartList;
    }

    public List<CartBO> getCartList() {
        return cartList;
    }



}
