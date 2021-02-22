package com.achang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/******
 @author 阿昌
 @create 2021-02-05 21:43
 *******
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);




}
