package com.inet.code.stencil;

import com.inet.code.entity.user.dto.LoginBean;
import com.inet.code.result.Result;

/**
 * 通用模板接口
 * @author HCY
 * @since 2021/3/20 上午8:18
*/
public interface BaseStencil {

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
    Result inetLogin(LoginBean loginBean, String path);
}
