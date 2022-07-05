package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/29 21:39
 */

public class OrdersByPageBO {

    /**
     * address :
     * moneyLimit2 :
     * moneyLimit1 :
     * pagesize : 5
     * name :
     * goods :
     * state : -1
     * id :
     * currentPage : 2
     */
    private String address;
    private String moneyLimit2;
    private String moneyLimit1;
    private Integer pagesize;
    private String name;
    private String goods;
    private Integer state;
    private String id;
    private Integer currentPage;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMoneyLimit2(String moneyLimit2) {
        this.moneyLimit2 = moneyLimit2;
    }

    public void setMoneyLimit1(String moneyLimit1) {
        this.moneyLimit1 = moneyLimit1;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getAddress() {
        return address;
    }

    public String getMoneyLimit2() {
        return moneyLimit2;
    }

    public String getMoneyLimit1() {
        return moneyLimit1;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public String getName() {
        return name;
    }

    public String getGoods() {
        return goods;
    }

    public Integer getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }
}
