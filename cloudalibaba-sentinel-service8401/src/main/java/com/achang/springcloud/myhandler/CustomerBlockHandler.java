package com.achang.springcloud.myhandler;

import com.achang.springcloud.bean.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/******
 @author 阿昌
 @create 2021-02-14 11:48
 *******
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义限流测试，Glogal handlerException ---- 1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义限流测试，Glogal handlerException ---- 2");
    }
}
