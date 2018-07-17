package com.ssmvue.common;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomObjectMapper extends ObjectMapper{
	/** 
	 * @Fields serialVersionUID : TODO 
	 *
	 */ 
	private static final long serialVersionUID = -6693962117887833330L;

	public CustomObjectMapper(){  
        super();  
        //设置null转换""  
        getSerializerProvider().setNullValueSerializer(new NullSerializer());  
        //设置日期转换yyyy-MM-dd HH:mm:ss  
        setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));  
    }  
      
    /** 
     * 
     * @ClassName: NullSerializer
     * @Description: null的JSON序列 
     * @author BJC
     * @date 2016年8月18日 上午10:49:35 
     *  
     *
     */
    private class NullSerializer extends JsonSerializer<Object> {  
        public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException,JsonProcessingException {  
            jgen.writeString("");  
        }  
    }  
}
