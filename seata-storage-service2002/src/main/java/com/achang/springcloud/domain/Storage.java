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
public class Storage {
    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
