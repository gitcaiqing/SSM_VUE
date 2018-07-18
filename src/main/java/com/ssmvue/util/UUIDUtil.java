/**
 * auth:CQ
 * date:2018/7/18 16:09
 **/
package com.ssmvue.util;

import java.util.UUID;

/**
 * Created by CQ on 2018/7/18.
 */
public class UUIDUtil {

    public static String getUUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}