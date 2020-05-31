package com.zenki.platform.platformmanualintervention.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  Created by shao.guangze on 2020/5/31
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String getHello(){
        return  "hello";
    }
}
