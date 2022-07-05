package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/30 18:31
 */
@Data
public class States {
    private Integer id;
    private String name;

    public States(Integer id) {
        this.id = id;
    }

    public States() {
    }
}
