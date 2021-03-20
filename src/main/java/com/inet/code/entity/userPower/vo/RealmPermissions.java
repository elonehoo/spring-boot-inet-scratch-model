package com.inet.code.entity.userPower.vo;

import lombok.*;

/**
 * 用户权限
 * @author HCY
 * @since 2021/3/19 下午9:35
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RealmPermissions {
    /**
     * 权限序号
     */
    private String powerId;

    /**
     * 权限名称
     */
    private String powerName;
}
