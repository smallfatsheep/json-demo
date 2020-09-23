package com.example.jsondemo.entity;

import lombok.*;
import com.google.gson.annotations.Expose;

/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/09/22 15:46:53
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExposeEntity {
    //    @Expose提供了两个属性，且都有默认值（默认值是true），开发者可以根据需要设置不同的值。
//    @Expose 注解从名字上就可以看出是暴露的意思，所以该注解是用于对外暴露字段的。
//    可是我们以前用Gson的时候也没有@Expose 注解还不是正确的序列化为JSON了么?
//    是的，所以该注解在使用new Gson() 时是不会发生作用。
//    毕竟最常用的API要最简单，所以该注解必须和GsonBuilder配合使用。
//    @Expose(deserialize = true,serialize = true) //序列化和反序列化都都生效，等价于上一条
//    @Expose(deserialize = true,serialize = false) //反序列化时生效
//    @Expose(deserialize = false,serialize = true) //序列化时生效
//    @Expose(deserialize = false,serialize = false) // 和不写注解一样
//    使用方法： 简单说来就是需要导出的字段上加上@Expose 注解，不导出的字段不加。【注意】不导出的不加。

    @Expose(deserialize = true,serialize = false) //反序列化时生效
    private String expose;
    @Expose
    private String name;
    @Expose
    private int age;
}
