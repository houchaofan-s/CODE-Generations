/**
* chao 2023
*/
package com.hhcc.modules.test.service.impl;

import com.hhcc.modules.test.entity.Test;
import com.hhcc.modules.test.vo.TestVO;
import com.hhcc.modules.test.mapper.TestMapper;
import com.hhcc.modules.test.service.ITestService;
import com.hhcc.modules.common.utils.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务实现类
 *
 * @author h
 * @since 2023-07-26
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<TestMapper, Test> implements ITestService {

	@Override
	public IPage<TestVO> selectTestPage(IPage<TestVO> page, TestVO test) {
		return page.setRecords(baseMapper.selectTestPage(page, test));
	}

}
