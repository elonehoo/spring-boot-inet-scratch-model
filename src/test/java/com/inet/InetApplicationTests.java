package com.inet;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InetApplicationTests {

    @Test
    void contextLoads_0() {
        String account = " ";
        System.out.println(StrUtil.isEmpty(account));
        System.out.println(StrUtil.isBlank(account));
    }

}
