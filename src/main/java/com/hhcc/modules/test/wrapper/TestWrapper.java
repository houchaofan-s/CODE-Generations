/**
* chao 2023
*/
package com.hhcc.modules.test.wrapper;

import com.hhcc.modules.common.utils.BeanUtil;
import com.hhcc.modules.common.utils.core.mp.support.BaseEntityWrapper;
import com.hhcc.modules.test.entity.Test;
import com.hhcc.modules.test.vo.TestVO;

/**
 * 包装类,返回视图层所需的字段
 *
 * @author h
 * @since 2023-07-26
 */
public class TestWrapper extends BaseEntityWrapper<Test, TestVO>  {

    public static TestWrapper build() {
        return new TestWrapper();
    }

	@Override
	public TestVO entityVO(Test test) {

		TestVO testVO = BeanUtil.copy(test, TestVO.class);

		return testVO;
	}

}
