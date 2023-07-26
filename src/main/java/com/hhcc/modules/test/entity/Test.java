/**
* chao 2023
*/
package com.hhcc.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hhcc.modules.common.utils.core.mp.base.BaseEntity;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author h
 * @since 2023-07-26
 */
@Data
@TableName("blade_test")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Test对象", description = "Test对象")
public class Test extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 美金
     */
    @ApiModelProperty(value = "美金")
    private String countD;
    /**
     * 传参
     */
    @ApiModelProperty(value = "传参")
    private Integer tenantIda;


}
