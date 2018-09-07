/**
 * auth:CQ
 * date:2018/7/27 18:09
 **/
package com.ssmvue.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by CQ on 2018/7/27.
 */
public class Configuration{

    private static Properties properties = new Properties();

    private static String configFileLocation = "classpath*:config/*.properties";

    private static void init() {

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = null;
        try {
            resources = resourcePatternResolver.getResources(configFileLocation);
            String fileName = "";
            for(Resource resource:resources){
                fileName = resource.getFilename();
                if (fileName.endsWith(".properties")) {
                    System.out.println("加载配置文件: ------ "+fileName);
                    properties.load(resource.getInputStream());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if(properties.isEmpty()){
            init();
        }
        String value = properties.getProperty(key);

        if (null != value) {
            value = value.trim();
        }

        return value;
    }

    public static void setFilePath(String name) {
        synchronized (Configuration.class) {
            configFileLocation = name;
        }
    }
}