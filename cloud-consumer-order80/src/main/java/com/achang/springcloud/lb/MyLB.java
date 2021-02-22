package com.achang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/******
 @author 阿昌
 @create 2021-02-05 21:49
 *******
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;//当前值
        int next;//期望值

        do {
            current = this.atomicInteger.get();
            //如果current是最大值，重新计算，否则加1（防止越界）
            next = current >=2147483647 ? 0 : current + 1;

        //进行CAS判断，如果不为true，进行自旋
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("=======next: "+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        //非空判断
        if(serviceInstances.size() <= 0){
            return null;
        }

        //进行取余
        int index = getAndIncrement() % serviceInstances.size();

        //返回选中的服务实例
        return serviceInstances.get(index);

    }


}
