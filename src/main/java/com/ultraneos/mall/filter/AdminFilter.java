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
 * @author Saitama
 * @since 2022/06/28 10:16
 */
@WebFilter("/api/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //允许访问的来源的域
        //如果希望浏览器允许携带cookie，服务器需要设置该处为前端页面所在的主机、端口号
        response.setHeader("Access-Control-Allow-Origin", Constant.ORIGIN);
        //允许发送的请求的方法
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        //发送请求时允许携带的头
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Content-Type");
        //是否允许携带cookie的凭证
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if (!"OPTIONS".equals(request.getMethod())) {
            if (!"/api/admin/admin/login".equals(request.getRequestURI())) {
                //如果请求的地址不是/api/admin/admin/login那么表示的是需要验证登录状态
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("loginAdmin");
                if (username == null) {
//需要登录后才可以访问，但是此时没有登录
                    response.getWriter().println(new Gson().toJson(Result.error("当前接口仅允许登录后才可以访问")));
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
