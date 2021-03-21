package com.inet;

import cn.hutool.core.util.StrUtil;
import com.inet.code.entity.power.po.Power;
import com.inet.code.entity.role.po.Role;
import com.inet.code.service.PowerService;
import com.inet.code.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InetApplicationTests {

    @Resource
    private RoleService roleService;

    @Resource
    private PowerService powerService;

    /**
     * 测试String字符串
     * @author HCY
     * @since 2021/3/21 上午10:49
     * @return void
    */
    @Test
    void contextLoads_0() {
//        String account = " ";
//        System.out.println(StrUtil.isEmpty(account));
//        System.out.println(StrUtil.isBlank(account));
    }

    /**
     * 进行初始化角色
     * Initialize the role
     * @author HCY
     * @since 2021/3/21 上午9:33
     * @return void
    */
    @Test
    void contextLoads_1(){
//        roleService.save(new Role("elementaryUser"));
    }

    /**
     * 进行初始化权限
     * Initialize permissions
     * @author HCY
     * @since 2021/3/21 上午9:34
     * @return void
    */
    @Test
    void contextLoads_2(){
//        powerService.save(new Power("enroll"));
    }

}
