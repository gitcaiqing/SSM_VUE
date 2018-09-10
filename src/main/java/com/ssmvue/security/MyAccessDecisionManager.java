package com.ssmvue.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

public class MyAccessDecisionManager implements AccessDecisionManager{
    /**
     * 该方法决定该权限是否有权限访问该资源，其实object就是一个资源的地址，authentication是当前用户的对应权限，
     * 如果没登陆就为游客，登陆了就是该用户对应的权限
     * @param authentication 当前用户的对应权限
     * @param o 一个资源的地址
     * @param configAttributes 请求的地址对应的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(configAttributes == null){
            return;
        }
        //如果请求的地址所需的权限和登陆的用户所拥有的权限有匹配的则可以访问该有权限访问
        //遍历请求地址所有权限
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while(iterator.hasNext()){
            ConfigAttribute configAttribute = iterator.next();
            //所需权限
            String needPermission = configAttribute.getAttribute();
            System.out.println("访问地址："+o.toString()+"需要的权限："+needPermission);

            //遍历登陆用户权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for(GrantedAuthority ga : authorities){
                if(needPermission.equals(ga.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("无访问权限！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}