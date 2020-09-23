package com.example.jsondemo.gson;

import com.example.jsondemo.entity.ExposeEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/09/22 15:48:49
 * @Version: 1.0
 */
public class GsonTest2 {

    private static ExposeEntity expose = new ExposeEntity("expose","全球",21);

    private static String tojson(){
        Gson gson = new GsonBuilder()
                //序列化null
                //.serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
                //.setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
                //.disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
                //.generateNonExecutableJson()
                //禁止转义html标签
                //.disableHtmlEscaping()
                //格式化输出
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String str = gson.toJson(expose);
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        tojson();
    }
}
