package com.ssmvue.security;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 查询资源和角色，构建RequestMap
 * security将这种数据类型进行了封装，把它封装成Map<RequestMatcher, Collection<ConfigAttribute>>
 *     这样的类型，其中RequestMatcher接口就是我们数据库中的res_string,其实现类为AntPathRequestMatcher，
 *     构建一个这样的对象只要在new的时候传入res_string就可以了，
 *     Collection<ConfigAttribute>这里对象构建起来就也是类似的，
 *     构建一个ConfigAttribute对象只需要在其实现类SecurityConfig创建的时候传入角色的名字就可以
 */
public class JdbcRequestMapBuilder extends JdbcDaoSupport{

    //查询角色资源的sql,改属于在配置bean的时候传入
    private String resourceQuery = "";

    public String getResourceQuery() {
        return resourceQuery;
    }

    public void setResourceQuery(String resourceQuery) {
        this.resourceQuery = resourceQuery;
    }

    //查询资源
    public List<Resource> findResourceDate(){
        ResourceMapping resourceMapping = new ResourceMapping(getDataSource(), resourceQuery);
        return resourceMapping.execute();
    }

    //创建RequestMatcher对象
    public RequestMatcher getRequestMatcher(String url){
        return new AntPathRequestMatcher(url);
    }

    //拼接角色资源数据
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap(){
        //最终角色资源数据对象
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap =
                new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        //遍历通过查询获取的角色资源，拼装数据
        List<Resource> resourceList = findResourceDate();
        for(Resource resource : resourceList){
            //RequestMatcher
            RequestMatcher requestMatcher = this.getRequestMatcher(resource.getUrl());
            //Collection<ConfigAttribute>
            List<ConfigAttribute> configAttributes = new ArrayList<>();
            configAttributes.add(new SecurityConfig(resource.getRole()));
            requestMap.put(requestMatcher,configAttributes);
        }
        return requestMap;
    }
}























