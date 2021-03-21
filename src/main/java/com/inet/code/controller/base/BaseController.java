package com.inet.code.controller.base;

import com.inet.code.entity.user.dto.LoginBean;
import com.inet.code.result.Result;
import com.inet.code.stencil.BaseStencil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基本API接口
 * Basic API Interface
 * @author HCY
 * @since 2021/3/17 上午10:17
*/
@CrossOrigin
@RestController
@Api(tags = {"基础模块"})
@RequestMapping("/base")
public class BaseController {

    /**
     * 基础模块的接口
     * The interface of the base module
     * @author HCY
     * @since 2021/3/20 下午1:42
    */
    @Resource
    private BaseStencil baseStencil;

    /**
     * 登陆操作
     * Landing operation
     * @author HCY
     * @since 2021/3/20 下午1:51
     * @param loginBean: 登陆的实体类
     * @param loginBean: Entity class for logging in
     * @return com.inet.code.result.Result
    */
    @PostMapping(value = "/login")
    @ApiOperation(value = "登陆操作，不需要token",httpMethod="POST")
    public Result postLogin(@RequestBody LoginBean loginBean){
        return baseStencil.inetLogin(loginBean,"/base/login");
    }

}
