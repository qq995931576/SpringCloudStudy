package com.achang.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/******
 @author 阿昌
 @create 2021-02-02 12:52
 *******
 */

//返回给前端的通用json数据串
@Data   //set/get方法
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data; //泛型，对应类型的json数据

    //自定义两个参数的构造方法
    public CommonResult(Integer code, String msg) {
        this(code,msg,null);
    }

}
