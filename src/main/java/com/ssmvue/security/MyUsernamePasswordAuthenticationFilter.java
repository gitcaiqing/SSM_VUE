package com.ssmvue.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置自定义认证处理的过滤器，并加入到FilterChain的过程。
 * 将自定义的Filter加入到security中的FilterChain中去
 * 其实和默认的UsernamePasswordAuthenticationFilter并没有什么区别，
 * 但是这里主要是学会将自定义的Filter加入到security中的FilterChain中去，实际上这个方法中，
 * 一般会直接验证用户输入的和通过用户名从数据库里面查到的用户的密码是否一致，如果不一致，就抛异常，否则继续向下执行。
 */

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private String usernameParameter = "username";
    private String passwordParameter = "password";

    /**
     * 用户验证登陆的入口
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = this.obtainUsername(request);
            String password = this.obtainPassword(request);
            if(username == null) {
                username = "";
            }

            if(password == null) {
                password = "";
            }

            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        Object object = request.getParameter(this.passwordParameter);
        return null == object ? "" : object.toString().trim().toLowerCase();
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        Object object = request.getParameter(this.usernameParameter);
        return null == object ? "" : object.toString().trim().toLowerCase();
    }
}