package com.example.jsondemo.gson;

import com.example.jsondemo.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.*;

/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/09/22 14:27:45
 * @Version: 1.0
 */
/*Gson是一个Java库，
可用于将Java对象转换为其JSON表示形式。
它还可以用于将JSON字符串转换为等效的Java对象。
 Gson可以处理任意Java对象，包括您没有源代码的现有对象。*/
public class GsonTest {

    private static User user = new User(1,"中国1",100);
    private static User user2 = new User(2,"中国2",200);
    private static User user3 = new User(3,"中国3",300);
    private static User user4 = new User(4,"中国4",400);
    private static Gson gson = null;

    //对象转json字符串
    private static String tojson() {
        gson = new Gson();
        String str = gson.toJson(user);
        System.out.println("对象转json字符串:" + str);
        return str;
    }

    //json字符串转对象
    private static void fromjson(){
        String str = tojson();
        gson = new Gson();
        User user = gson.fromJson(str,User.class);
        System.out.println(user);
    }

    //复杂bean对象转json
    private static String tojsonlist(){
        List list = new ArrayList();
        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        gson = new Gson();
        String str = gson.toJson(list);
        System.out.println(str);
        return str;
    }

    //json转list
    private static void formjsonlist(){
        String str = tojsonlist();
        gson = new Gson();
        List<User> list = gson.fromJson(str,new TypeToken<List<User>>(){}.getType());
        for (User user : list){
            System.out.println(user);
        }
    }

    //复杂对象转json
    private static String tojsonset(){
        Set set = new HashSet();
        set.add(user);
        set.add(user2);
        set.add(user3);
        set.add(user4);
//        gson = new Gson();
        GsonBuilder gsonBuilder;
        gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(set);
        System.out.println(str);
        return str;
    }

    //json转set
    private static void formjsonset(){
        String str = tojsonset();
        gson = new GsonBuilder().setPrettyPrinting().create();
        Set<User> set = gson.fromJson(str,new TypeToken<Set<User>>(){}.getType());
        for (User user : set){
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
//        tojson();
//        fromjson();
//        tojsonlist();
//        tojsonset();
//        formjsonlist();
//        formjsonset();
    }
}
