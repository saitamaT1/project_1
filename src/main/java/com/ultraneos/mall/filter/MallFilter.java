package com.ultraneos.mall.filter;


import com.google.gson.Gson;
import com.ultraneos.mall.util.Constant;
import com.ultraneos.mall.util.Result;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2022/5/17 11:24
 * @Version V1.0
 **/
@WebFilter("/api/mall/*")
public class MallFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //允许访问的来源的域
        //如果希望浏览器允许携带cookie，服务器需要设置该处为前端页面所在的主机、端口号
        response.setHeader("Access-Control-Allow-Origin", Constant.ORIGIN);
        //允许发送的请求的方法
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
        //发送请求时允许携带的头
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
        //是否允许携带cookie的凭证
        response.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
