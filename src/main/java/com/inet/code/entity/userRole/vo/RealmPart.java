package com.inet.code.entity.userRole.vo;

import lombok.*;

/**
 * 用户的角色
 * @author HCY
 * @since 2021/3/19 下午9:40
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RealmPart {
    /**
     * 角色序号
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;
}
