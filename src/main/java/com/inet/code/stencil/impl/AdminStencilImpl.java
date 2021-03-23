package com.inet.code.stencil.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.code.entity.cipher.po.Cipher;
import com.inet.code.entity.slideshow.dto.SlideshowBean;
import com.inet.code.entity.slideshow.po.Slideshow;
import com.inet.code.entity.user.dto.EnrollBean;
import com.inet.code.entity.user.po.User;
import com.inet.code.entity.userRole.po.UserRole;
import com.inet.code.result.Result;
import com.inet.code.service.*;
import com.inet.code.stencil.AdminStencil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 管理员模板的实现类
 * @author HCY
 * @since 2021/3/20 上午8:17
*/
@Service
public class AdminStencilImpl implements AdminStencil {

    /**
     * 用户接口
     * The user interface
     * @author HCY
     * @since 2021/3/21 下午2:12
    */
    @Resource
    private UserService userService;

    /**
     * 密码接口
     * The password interface
     * @author HCY
     * @since 2021/3/21 下午4:48
    */
    @Resource
    private CipherService cipherService;

    /**
     * 图片接口
     * Image interface
     * @author HCY
     * @since 2021/3/21 下午2:15
    */
    @Resource
    private PictureService pictureService;

    /**
     * 角色接口
     * Role interface
     * @author HCY
     * @since 2021/3/21 下午5:06
    */
    @Resource
    private RoleService roleService;

    /**
     * 轮播图接口
     * slideshow interface
     * @author HCY
     * @since 2021/3/22 下午2:11
    */
    @Resource
    private SlideshowService slideshowService;

    /**
     * 用户角色接口
     * User role interface
     * @author HCY
     * @since 2021/3/21 下午5:07
    */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 注册的操作
     * Operation of registration
     * @author HCY
     * @since 2021/3/21 上午11:15
     * @param enrollBean: 注册的需要的用户名
     * @param enrollBean: The user name required for registration
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result enroll(EnrollBean enrollBean, String path) {
        //判断用户名是否是中文
        if (!Validator.isChinese(enrollBean.getUserName())) {
            return new Result().result403("用户名不合法",path);
        }
        //设置sm4加密程序
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4");
        //将用户名变成拼音 ---> 同时也是密码
        String accountAndPassword = PinyinUtil.getPinyin(enrollBean.getUserName(), "");
        //账号进行sm4加密账号
        String account = sm4.encryptHex(accountAndPassword);
        //密码进行md5加密密码
        String password = SecureUtil.md5(accountAndPassword);
        //产生一个默认的头像地址
        String pictureUrl = pictureService.getRandomPictureUrl();
        //判断账号是否重复 [true -> 重复];[false -> 未重复]
        if (userService.getByAccount(account)) {
            return new Result().result401("账号重复了，请重新设置用户名",path);
        }
        //进行存储用户
        userService.save(new User(account,enrollBean.getUserName(),pictureUrl));
        //通过用户账号获取用户的序号
        String userId = userService.accountByUserId(account);
        //进行存储密码
        cipherService.save(new Cipher(userId,password));
        //存储角色 [注册的用户 -> 普通用户]
        userRoleService.save(new UserRole(
                 userId
                ,roleService.getByUserName("elementaryUser").getId()));
        return new Result().result200("注册成功",path);
    }

    /**
     * 查看轮播图
     * Check out the rotation chart
     * @author HCY
     * @since 2021/3/22 下午1:45
     * @param current: 页数
     * @param current: Number of pages
     * @param size: 条目数
     * @param size: Number of entries
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
     */
    @Override
    public Result getSlideshow(Integer current, Integer size, String path) {
        return new Result().result200(
                 slideshowService.pageSlideshow(new Page<>(current,size))
                ,path);
    }

    /**
     * 通过轮播图序号删除轮播图
     * Delete the rotation map by the rotation map serial number
     * @author HCY
     * @since 2021/3/23 上午9:02
     * @param id: 轮播图序号
     * @param id: Rotate the map sequence number
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
     */
    @Override
    public Result deleteSlideshow(String id, String path) {
        //删除操作
        if (slideshowService.removeById(id)) {
            //删除成功
            return new Result().result200("删除成功",path);
        }
        //删除失败
        return new Result().result500("删除失败",path);
    }

    /**
     * 通过轮播图的序号修改轮播图的状态
     * Modify the state of the carousel by its serial number
     * @author HCY
     * @since 2021/3/23 上午9:55
     * @param slideshowBean: 轮播图的序号实体类 --> [序号]
     * @param slideshowBean: Ordinal Entity Class of Rotating Graph --> [Ordinal]
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
     */
    @Override
    public Result putSlideshow(SlideshowBean slideshowBean, String path) {
        //通过序号获取到轮播图的实体类
        Slideshow slideshow = slideshowService.getById(slideshowBean.getId());
        //进行轮播图的修改
        slideshow.setSlideshowStatus(!slideshow.getSlideshowStatus());
        //进行修改
        if (slideshowService.updateById(slideshow)) {
            //修改成功
            return new Result().result200("修改成功",path);
        }
        //修改失败
        return new Result().result500("修改失败",path);
    }
}
