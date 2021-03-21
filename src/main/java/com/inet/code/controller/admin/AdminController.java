package com.inet.code.controller.admin;

import com.inet.code.entity.user.dto.EnrollBean;
import com.inet.code.result.Result;
import com.inet.code.stencil.AdminStencil;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理员的API接口
 * The administrator's API interface
 * @author HCY
 * @since 2021/3/17 上午10:15
*/
@CrossOrigin
@RestController
@Api(tags = {"管理模块"})
@RequestMapping("/admin")
public class AdminController {

    /**
     * 管理员的自定义接口
     * A custom interface for administrators
     * @author HCY
     * @since 2021/3/21 上午9:19
    */
    @Resource
    private AdminStencil adminStencil;

    @PostMapping(value = "/enroll")
    @RequiresRoles(logical = Logical.OR,value = {"superAdministrator","generalAdministrator"})
    @RequiresPermissions(logical = Logical.AND, value = {"enroll"})
    public Result postEnroll(@RequestBody EnrollBean enrollBean){
        return adminStencil.enroll(enrollBean,"/admin/enroll");
    }
}
