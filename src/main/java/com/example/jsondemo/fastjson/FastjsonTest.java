package com.example.jsondemo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.jsondemo.entity.User;

import java.util.*;

/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/09/23 10:35:17
 * @Version: 1.0
 */
public class FastjsonTest {

    private static User user = new User(12, "中国1", 19);
    private static User user1 = new User(13, "中国2", 20);
    private static User user2 = new User(14, "中国3", 21);

    //将对象转换成json
    private static String tojson() {
        //格式化json,默认是false
        String str = JSON.toJSONString(user, true);
        //非格式化json
        //String str = JSON.toJSONString(user,false);
        //String str = JSON.toJSONString(user);
        System.out.println(str);
        return str;
    }

    //对象转换json
    private static void parseobject() {
        String json = tojson();
        User user = JSON.parseObject(json, User.class);
        System.out.println(user.toString());
    }

    //复杂对象转json
    private static String tojsoncomplex(){
        List list = new ArrayList();
        list.add(user);
        list.add(user1);
        list.add(user2);
        Map map = new HashMap();
        map.put("test","test");
        map.put("user",list);
        String str = JSON.toJSONString(map);
        System.out.println(str);
        return str;
    }
    //json转复杂对象
    private static void parseobjectcomplex(){
        String json = tojsoncomplex();
        Map map = JSON.parseObject(json,new TypeReference<Map>(){});
        JSONObject jsonObject = JSON.parseObject(json);
        String test = jsonObject.getString("test");
        List list = jsonObject.getJSONArray("user");
        System.out.println(list);
        System.out.println(test);
        System.out.println(map);
        jsonObject.remove("test");
        System.out.println(jsonObject.toString());
        jsonObject.put("test2", "test2");
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.containsKey("test2"));
        System.out.println(jsonObject.containsValue(list));
        jsonObject.put("test2", "test3");
        System.out.println(jsonObject.toString());
        Object obj = new Date();
        String str = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(str);
        User user3 = new User();
        user3.setAge(22);
        user3.setId(15);
        //改为不忽略NULL值
        String jsonstring = JSON.toJSONString(user3, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonstring);
    }

    public static void main(String[] args) {
//        tojson();
//        parseobject();
//        tojsoncomplex();
        parseobjectcomplex();
    }
}
