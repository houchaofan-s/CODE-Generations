/**
* chao 2023
*/
package com.hhcc.modules.test.vo;

import com.hhcc.modules.test.entity.Test;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 视图实体类
 *
 * @author h
 * @since 2023-07-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TestVO对象", description = "TestVO对象")
public class TestVO extends Test {
	private static final long serialVersionUID = 1L;

}
