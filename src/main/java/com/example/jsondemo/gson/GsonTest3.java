package com.example.jsondemo.gson;

import com.example.jsondemo.entity.User;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/09/22 17:06:42
 * @Version: 1.0
 */
public class GsonTest3 {

    private static User user = new User(1,"全球",21);
    private static String json = "[{\"id\":\"1\",\"name\":\"Json技术\"},{\"id\":\"2\",\"name\":\"java技术\"}]";

    //    格式化Json
    private static void setPretty(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        json = gson.toJson(je);
        System.out.println(json);
        String str = gson.toJson(user);
        System.out.println(str);
        JsonObject jsonObject = jp.parse(str).getAsJsonObject();
        String name = jsonObject.get("name_test").getAsString();
        System.out.println(name);
    }

//    判断字符串是否是json对象
    private static boolean jsonflag() {
        boolean jsonFlag;
        try {
            new JsonParser().parse(json).getAsJsonObject();
            jsonFlag = true;
        } catch (Exception e) {
            jsonFlag = false;
        }
        return jsonFlag;
    }

    private static boolean jsonflag2(){
        boolean jsonFlag;
        try{
            String str = new Gson().toJson(user);
            JsonParser jsonParser = new JsonParser();
            JsonElement element = jsonParser.parse(str);
            JsonObject jsonObj = element.getAsJsonObject();
            System.out.println(jsonObj.get("name_test").getAsString());
            System.out.println(jsonObj.get("age").getAsInt());
            jsonFlag = true;
        }catch (Exception e){
            jsonFlag = false;
        }
        return jsonFlag;
    }

    //删除json中的属性
    private static void delect(){
        String json1 = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "id";
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json1);
        JsonObject jsonObj = element.getAsJsonObject();
        jsonObj.remove(propertyName);
        json1 = jsonObj.toString();
        System.out.println(json1);
    }

    //增加json中的属性
    private static void add(){
        String json1 = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "desc";
        Object propertyValue = "json各种技术的调研";
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json1);
        JsonObject jsonObj = element.getAsJsonObject();
        jsonObj.addProperty(propertyName, new Gson().toJson(propertyValue));
        json1 = jsonObj.toString();
        System.out.println(json1);
    }

    //修改json中的属性
    private static void update(){
        String json1 = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "name";
        Object propertyValue = "json各种技术的调研";
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json1);
        JsonObject jsonObj = element.getAsJsonObject();
        jsonObj.remove(propertyName);
        jsonObj.addProperty(propertyName, new Gson().toJson(propertyValue));
        json1 = jsonObj.toString();
        System.out.println(json1);
    }

    //判断json中是否有属性
    private static void haselement(){
        String json1 = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "name";
        boolean isContains = false ;
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json1);
        JsonObject jsonObj = element.getAsJsonObject();
        isContains = jsonObj.has(propertyName);
    }
    //json中日期格式的处理
    private static void datafomate(){
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Gson gson = builder.create();
    }
//    private static void test(){
//        JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
//        JsonArray jsonArray = jsonObj.get("obj").getAsJsonArray();
//        Iterator<JsonElement> iter = jsonArray.iterator();
//        List<String> objs = new ArrayList<String>();
//        while(iter.hasNext()){
//            objs.add(iter.next().getAsString());
//        }
//
//    }

    public static void main(String[] args) {
//        setPretty();
//        System.out.println(jsonflag());
//        System.out.println(jsonflag2());
//        delect();
        add();
    }
}
