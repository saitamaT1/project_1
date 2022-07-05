package com.ultraneos.mall.model.vo;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/28 15:14
 */
@Data
public class AdminLoginVO {
    private String token;
    private String name;

    public AdminLoginVO(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public AdminLoginVO() {
    }
}
