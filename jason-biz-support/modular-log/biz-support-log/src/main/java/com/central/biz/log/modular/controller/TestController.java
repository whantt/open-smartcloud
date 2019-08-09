package com.central.biz.log.modular.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.central.core.model.reqres.request.RequestData;
import com.central.core.utils.RequestDataHolder;
import com.central.core.utils.ToolUtil;
import com.smartcloud.logger.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "测试服务")
@RequestMapping("/test")
@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);


	@ApiOperation(value = "hello test")
	@GetMapping("/hello")
	public String hello() {
		return "hello log server";
	}


	@ApiOperation(value = "测试RequestData解析dictId")
	@SentinelResource("testRequestdata")
	@PostMapping("/requestdata")
	public Long login(RequestData requestData) {
		Long dictTypeId = requestData.getLong("dictId");
		RequestData d  = RequestDataHolder.get();
		return dictTypeId;
	}

	@ApiOperation(value = "测试手工写一条日志")
	@GetMapping("/addLogMsg")
	public void addLogMsg() {
		String romStr = ToolUtil.getRandomString(10);
		LogUtil.debug("测试手工写一条日志" + romStr);
	}
}
