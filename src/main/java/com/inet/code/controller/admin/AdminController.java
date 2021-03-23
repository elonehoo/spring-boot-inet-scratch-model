package com.inet.code.controller.admin;

import com.inet.code.entity.slideshow.dto.SlideshowBean;
import com.inet.code.entity.user.dto.EnrollBean;
import com.inet.code.result.Result;
import com.inet.code.stencil.AdminStencil;
import com.inet.code.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 注册操作，需要 --> [超级管理员、普通管理员] -- [注册权限]
     * Register operation, need --> [super administrator, normal administrator] -- [register permissions]
     * @author HCY
     * @since 2021/3/23 上午9:08
     * @param enrollBean: 注册实体类,需要 -- [用户名]
     * @param enrollBean: To register an entity class, you need -- [user name]
     * @return com.inet.code.result.Result
    */
    @PostMapping(value = "/enroll")
    @ApiOperation(value = "注册操作，需要 --> [超级管理员、普通管理员] -- [注册权限]",httpMethod="POST")
    @RequiresPermissions(logical = Logical.AND, value = {"enroll"})
    @RequiresRoles(logical = Logical.OR,value = {"superAdministrator","generalAdministrator"})
    public Result postEnroll(@RequestBody EnrollBean enrollBean){
        return adminStencil.enroll(enrollBean,"/admin/enroll");
    }

    /**
     * 查看轮播图
     * Check out the rotation chart
     * @author HCY
     * @since 2021/3/22 下午1:39
     * @param current: 页数
     * @param current: Number of pages
     * @param size: 条目数
     * @param size: Number of entries
     * @return com.inet.code.result.Result
    */
    @GetMapping("/slideshow")
    @RequiresRoles(logical = Logical.OR,value = {"superAdministrator","generalAdministrator"})
    @RequiresPermissions(logical = Logical.AND, value = {"slideshow"})
    public Result getSlideshow(@RequestParam(value = "current",defaultValue = "1") Integer current,
                               @RequestParam(value = "size",defaultValue = "10") Integer size){
        return adminStencil.getSlideshow(current,size,"/admin/slideshow");
    }

    /**
     * 通过轮播图序号进行删除
     * Delete the figure by rotating the sequence number
     * @author HCY
     * @since 2021/3/23 上午9:00
     * @param id: 轮播图序号
     * @param id: Rotate the map sequence number
     * @return com.inet.code.result.Result
    */
    @DeleteMapping("/slideshow")
    @RequiresRoles(logical = Logical.OR,value = {"superAdministrator"})
    @RequiresPermissions(logical = Logical.AND, value = {"slideshow"})
    public Result deleteSlideshow(@RequestParam(value = "id",defaultValue = "") String id){
        return adminStencil.deleteSlideshow(id,"/admin/slideshow");
    }

    /**
     * 通过轮播图的序号进行修改轮播图的上架和下架
     * Modify the loading and unloading of the rotation by the serial number of the rotation
     * @author HCY
     * @since 2021/3/23 上午9:52
     * @param slideshowBean: 轮播图序号的实体类 --> [轮播图序号]
     * @param slideshowBean: Entity class of rotation number -> [rotation number]
     * @return com.inet.code.result.Result
    */
    @PutMapping("/slideshow")
    @RequiresRoles(logical = Logical.OR,value = {"superAdministrator","generalAdministrator"})
    @RequiresPermissions(logical = Logical.AND, value = {"slideshow"})
    public Result putSlideshow(@RequestBody SlideshowBean slideshowBean){
        return adminStencil.putSlideshow(slideshowBean,"/admin/slideshow");
    }

    /**
     * 上传轮播图
     * Upload the rotation map
     * @author HCY
     * @since 2021/3/23 上午11:10
     * @param file: 文件
     * @param file: The file field
     * @return com.inet.code.result.Result
    */
    @PostMapping("/slideshow")
    public Result postSlideshow(@RequestParam MultipartFile file){
        return FileUtils.getUploading(file,"/admin/slideshow");
    }

}
