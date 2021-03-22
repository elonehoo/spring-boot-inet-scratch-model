package com.inet;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.code.entity.picture.po.Picture;
import com.inet.code.entity.power.po.Power;
import com.inet.code.entity.role.po.Role;
import com.inet.code.entity.slideshow.po.Slideshow;
import com.inet.code.service.PictureService;
import com.inet.code.service.PowerService;
import com.inet.code.service.RoleService;
import com.inet.code.service.SlideshowService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InetApplicationTests {

    @Resource
    private RoleService roleService;

    @Resource
    private PowerService powerService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SlideshowService slideshowService;

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

    /**
     * 进行图片的初始化操作
     * Initialize the image
     * @author HCY
     * @since 2021/3/21 下午2:07
     * @return void
    */
    @Test
    void contextLoads_3(){
//        pictureService.save(new Picture("https://ss.im5i.com/2020/11/16/5cdbecc5e7bce720f6f0117b.jpg"));
//        System.out.println(pictureService.count());
    }

    /**
     * 判断轮播图
     * @author HCY
     * @since 2021/3/22 下午3:56
     * @return void
    */
    @Test
    void contextLoads_4(){
//        System.out.println(slideshowService.pageSlideshow(new Page<>(1, 5)).getRecords());
    }

    /**
     * 插入轮播图
     * @author HCY
     * @since 2021/3/22 下午4:04
     * @return void
    */
    @Test
    void contextLoads_5(){
//        slideshowService.save(new Slideshow("https://i.im5i.com/2021/03/12/h37zn.png",true));
    }

}
