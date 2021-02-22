package com.achang.springcloud.dao;

import com.achang.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/******
 @author 阿昌
 @create 2021-02-14 18:14
 *******
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态,从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
