package com.ssmvue.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            HttpSession session = request.getSession();
            String username = this.obtainUsername(request);
            String password = this.obtainPassword(request);
            //用户输入的验证码
            String captcha = request.getParameter("captcha");

            if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                session.setAttribute("errorMsg", "请输入用户名或密码！");
                throw new AuthenticationServiceException("username or password is not null!");
            }

            //密码加密 TODO
            if(StringUtils.isEmpty(captcha)) {
                session.setAttribute("errorMsg", "请输入验证码！");
                throw new AuthenticationServiceException("captcha is not null!");
            }
            //和session中生成的验证码比较证码输入是否正确，
            String sessionCaptcha = (String) session.getAttribute("captcha");
            if(!captcha.equalsIgnoreCase(sessionCaptcha)){
                session.setAttribute("errorMsg", "验证码输入错误！");

                throw new AuthenticationServiceException("captcha is false!");
            }
            //清空session中的验证码
            session.removeAttribute("captcha");

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