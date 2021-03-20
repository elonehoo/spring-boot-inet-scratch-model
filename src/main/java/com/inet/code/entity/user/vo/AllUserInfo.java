package com.inet.code.entity.user.vo;

import com.inet.code.entity.userPower.vo.RealmPermissions;
import com.inet.code.entity.userRole.vo.RealmPart;
import lombok.*;

import java.util.List;

/**
 * 用户的全数据
 * @author HCY
 * @since 2021/3/19 下午9:21
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AllUserInfo {

    /**
     * 用户信息
     */
    private RealmUser user;

    /**
     *  角色
     */
    private RealmPart part;

    /**
     * 权限集合
     */
    private List<RealmPermissions> permissionsList;


}
