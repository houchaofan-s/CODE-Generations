/**
* chao 2023
*/
package com.hhcc.modules.test.mapper;

import com.hhcc.modules.test.entity.Test;
import com.hhcc.modules.test.vo.TestVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author h
 * @since 2023-07-26
 */
public interface TestMapper extends BaseMapper<Test> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param test
	 * @return
	 */
	List<TestVO> selectTestPage(IPage page, TestVO test);

}
