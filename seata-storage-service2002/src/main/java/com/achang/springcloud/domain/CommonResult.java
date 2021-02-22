package com.achang.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/******
 @author 阿昌
 @create 2021-02-14 20:35
 *******
 */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CommonResult<T> {
        private Integer code;
        private String message;
        private T data;

        public CommonResult(Integer code, String message) {
            this(code, message, null);
        }
    }
