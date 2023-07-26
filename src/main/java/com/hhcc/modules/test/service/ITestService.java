/**
* chao 2023
*/
package com.hhcc.modules.test.service;

import com.hhcc.modules.test.entity.Test;
import com.hhcc.modules.test.vo.TestVO;
import com.hhcc.modules.common.utils.core.mp.base.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务类
 *
 * @author h
 * @since 2023-07-26
 */
public interface ITestService extends BaseService<Test> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param test
	 * @return
	 */
	IPage<TestVO> selectTestPage(IPage<TestVO> page, TestVO test);

}
