package com.example.jsondemo.jackson;

import com.example.jsondemo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/08/28 13:50:56
 * @Version: 1.0
 */
public class JacksonTest {

    //Jackson对象映射 序列化
    public static ObjectMapper mapper;
    //将对象转化为json字符串
    private static User user = new User(1,"黄",21);
    private static String tojson(User user) throws JsonProcessingException {
        mapper = new ObjectMapper();
        String jsonstr = mapper.writeValueAsString(user);
        return jsonstr;
    }
    //将json字符串转化为对象  反序列化
    private static User parseobject(String jsonstr) throws JsonProcessingException {
        User user = mapper.readValue(jsonstr,User.class);
        return user;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String str = tojson(user);
        User user = parseobject(str);
        System.out.println(str);
        System.out.println(user.toString());
    }
}
