package com.hhcc.modules.common.utils.core.secure;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BladeUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
        hidden = true
    )
    private String clientId;
    @ApiModelProperty(
        hidden = true
    )
    private Long userId;
    @ApiModelProperty(
        hidden = true
    )
    private String tenantId;
    @ApiModelProperty(
        hidden = true
    )
    private String deptId;
    @ApiModelProperty(
        hidden = true
    )
    private String userName;
    @ApiModelProperty(
        hidden = true
    )
    private String account;
    @ApiModelProperty(
        hidden = true
    )
    private String roleId;
    @ApiModelProperty(
        hidden = true
    )
    private String roleName;
}
