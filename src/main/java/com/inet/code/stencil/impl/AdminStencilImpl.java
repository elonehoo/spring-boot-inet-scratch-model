package com.inet.code.stencil.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.inet.code.entity.user.dto.EnrollBean;
import com.inet.code.result.Result;
import com.inet.code.stencil.AdminStencil;
import org.springframework.stereotype.Service;

/**
 * 管理员模板的实现类
 * @author HCY
 * @since 2021/3/20 上午8:17
*/
@Service
public class AdminStencilImpl implements AdminStencil {

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
    public Result enroll(EnrollBean enrollBean, String path) {
        //判断用户名是否是中文
        if (!Validator.isChinese(enrollBean.getUserName())) {
            return new Result().result403("用户名不合法",path);
        }
        //将用户名变成拼音
        String pinYinAccount = PinyinUtil.getPinyin(enrollBean.getUserName(), "");
        return null;
    }
}
