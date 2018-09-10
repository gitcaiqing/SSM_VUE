package com.ssmvue.security;

/**
 * 资源信息类
 */
public class Resource {
    private String url;//资源访问路径
    private String role;//所需权限

    public Resource(String url, String role) {
        this.url = url;
        this.role = role;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}