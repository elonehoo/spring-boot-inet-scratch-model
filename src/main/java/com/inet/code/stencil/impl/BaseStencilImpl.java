package com.inet.code.stencil.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.inet.code.entity.user.dto.LoginBean;
import com.inet.code.entity.user.vo.AllUserInfo;
import com.inet.code.entity.user.vo.RealmUser;
import com.inet.code.entity.userPower.vo.RealmPermissions;
import com.inet.code.entity.userRole.vo.RealmPart;
import com.inet.code.result.Result;
import com.inet.code.service.PowerService;
import com.inet.code.service.RoleService;
import com.inet.code.service.UserService;
import com.inet.code.stencil.BaseStencil;
import com.inet.code.utils.BeanUtil;
import com.inet.code.utils.JwtUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 通用模板实现类
 * @author HCY
 * @since 2021/3/20 上午8:18
*/
@Service
public class BaseStencilImpl implements BaseStencil {

    /**
     * 用户的接口
     * User interface
     * @author HCY
     * @since 2021/3/20 下午2:01
    */
    @Resource
    private UserService userService;

    /**
     * 角色接口
     * @author HCY
     * @since 2021/3/20 上午8:32
     */
    @Resource
    private RoleService roleService;

    /**
     * Redis对象
     * @author HCY
     * @since 2021/3/20 下午3:34
    */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 权限接口
     * @author HCY
     * @since 2021/3/20 上午8:44
     */
    @Resource
    private PowerService powerService;


    /**
     * 完成登陆的接口
     * Complete the login interface
     * @author HCY
     * @since 2021/3/20 下午1:57
     * @param loginBean: 登陆的实体类（含有账号和密码）
     * @param loginBean: Entity class for login (with account and password)
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
     */
    @Override
    public Result inetLogin(LoginBean loginBean, String path) {
        //创建SM4加密对象
        SymmetricCrypto sm4 = new SymmetricCrypto("sm4");
        //账号SM4加密操作
        String account = sm4.encryptHex(loginBean.getAccount());
        //密码SM5加密操作
        String cipher = SecureUtil.md5(loginBean.getCipher());
        //通过用户主键获取用户基本信息
        String userId = userService.getByAccountAndCipher(account,cipher);
        //判断userId是否存在
        if (StrUtil.isBlank(userId)) {
            return new Result().result404("账号密码错误",path);
        }
        //通过用户序号获取到用户的User实体类 ---> 再次使用Bean实体类将其转换成为RealmUser实体类
        RealmUser realmUser = BeanUtil.copy(userService.getById(userId),RealmUser.class);
        //通过用户序号获取到角色的Role实体类 ---> 再次使用Bean实体类将其转换为RealmPart实体类
        RealmPart realmPart = BeanUtil.copy(roleService.getByUserId(userId), RealmPart.class);
        //通过用户序号获取到权限的实体类集合 ---> 再次使用Bean实体类将其转换成为实体类集合
        List<RealmPermissions> realmPermissions = BeanUtil.batchCopy(powerService.getByUserId(userId), RealmPermissions.class);
        AllUserInfo allUserInfo = new AllUserInfo(realmUser,realmPart,realmPermissions);
        //创建token的参数
        Map<String, String> map = new HashMap<>(2);
        map.put("userId",allUserInfo.getUser().getId());
        map.put("userName",allUserInfo.getUser().getAccount());
        //设置token
        String token = JwtUtils.getToken(map);
        //设置返回值
        Map<String, Object> result = new HashMap<>(2);
        //设置token
        result.put("token",token);
        //设置info
        result.put("info","登陆成功");
        //存储进入redis
        redisTemplate.opsForValue().set(token,allUserInfo,7, TimeUnit.DAYS);
        return new Result().result200(result,path);
    }
}
