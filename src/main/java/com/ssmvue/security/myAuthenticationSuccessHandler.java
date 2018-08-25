package com.ssmvue.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class myAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
   // private IUserService userService;

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        // 认证成功后，获取用户信息并添加到session中
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //MangoUser user = userService.getUserByName(userDetails.getUsername());
        //request.getSession().setAttribute("user", user);

        super.onAuthenticationSuccess(request, response, authentication);

    }

}