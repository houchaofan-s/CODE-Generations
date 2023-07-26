/**
* chao 2023
*/
package com.hhcc.modules.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hhcc.modules.common.utils.Func;
import com.hhcc.modules.common.utils.core.mp.support.Condition;
import com.hhcc.modules.common.utils.core.mp.support.Query;
import com.hhcc.modules.common.utils.core.tool.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.hhcc.modules.test.entity.Test;
import com.hhcc.modules.test.vo.TestVO;
import com.hhcc.modules.test.wrapper.TestWrapper;
import com.hhcc.modules.test.service.ITestService;

/**
 *  控制器
 *
 * @author h
 * @since 2023-07-26
 */
@RestController
@AllArgsConstructor
@RequestMapping("/test")
@Api(value = "", tags = "接口")
public class TestController {

	private ITestService testService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入test")
	public R<TestVO> detail(Test test) {
		Test detail = testService.getOne(Condition.getQueryWrapper(test));
		return R.data(TestWrapper.build().entityVO(detail));
	}

	/**
	 * 分页
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入test")
	public R<IPage<TestVO>> list(Test test, Query query) {
		IPage<Test> pages = testService.page(Condition.getPage(query), Condition.getQueryWrapper(test));
		return R.data(TestWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入test")
	public R<IPage<TestVO>> page(TestVO test, Query query) {
		IPage<TestVO> pages = testService.selectTestPage(Condition.getPage(query), test);
		return R.data(pages);
	}

	/**
	 * 新增
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入test")
	public R save(@Valid @RequestBody Test test) {
		return R.status(testService.save(test));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入test")
	public R update(@Valid @RequestBody Test test) {
		return R.status(testService.updateById(test));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入test")
	public R submit(@Valid @RequestBody Test test) {
		return R.status(testService.saveOrUpdate(test));
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(testService.deleteLogic(Func.toLongList(ids)));
	}


}
