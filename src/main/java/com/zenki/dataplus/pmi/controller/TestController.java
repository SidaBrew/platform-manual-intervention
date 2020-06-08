package com.zenki.dataplus.pmi.controller;

import com.zenki.dataplus.pmi.service.TestService;
import com.zenki.dataplus.pmi.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 *  Created by shao.guangze on 2020/5/31
 */

@Api(value = "Demo2-API", description = "测试Demo2")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private LoginServiceImpl loginService;

    @ApiOperation(value = "创建对象", notes = "根据User对象创建用户")
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String getHello(){


        return  loginService.login();
    }
}
