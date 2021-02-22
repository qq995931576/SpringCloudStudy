package com.achang.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/******
 @author 阿昌
 @create 2021-02-02 12:48
 *******
 */
//这三个注解是lombok的，除了导入依赖，idea还需要安装插件（具体操作问度娘）
@Data   //set/get方法
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
