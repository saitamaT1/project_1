package com.ultraneos.mall.util;

import lombok.Data;

/**
 * @Description 该类用来封装返回给前端的结果
 *
 * @author Saitama
 * @since 2022/06/28 14:27
 */
@Data
public class Result {

    /**
     * code 取值为0或10000, 0表示成功，10000表示失败
     * 其中如果失败，则必须要返回message
     */
    private Integer code;

    private String message;

    /**
     * 在成功时，前端需要数据的话，则返回data；
     */
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public static Result error(String message){
        return new Result(10000, message, null);
    }
}
