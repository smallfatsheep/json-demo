package com.example.jsondemo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/08/28 13:42:54
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    private int id;
    //三个属性(email_address、email、emailAddress)都中出现任意一个时均可以得到正确的结果
    //@SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
    //SerializedName 保留了前端、后台各自的命名习惯
    @SerializedName(value = "name_test",alternate = {"name"})
    private String name;
    private int age;

}
