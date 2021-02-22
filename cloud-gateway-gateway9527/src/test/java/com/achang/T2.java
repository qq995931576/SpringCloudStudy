package com.achang;

import java.time.ZonedDateTime;

/******
 @author 阿昌
 @create 2021-02-09 14:12
 *******
 */
public class T2 {
    public static void main(String[] args) {
        //获取当前时间串
        ZonedDateTime zdt = ZonedDateTime.now();//默认时区
        System.out.println(zdt);
        // 2021-02-09T14:13:15.803+08:00[Asia/Shanghai]
    }



}
