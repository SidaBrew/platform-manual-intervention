package com.zenki.dataplus.pmi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/***
 *  Created by shao.guangze on 2020/6/8
 */
@Service
public class LoginServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    public String login() {
        logger.debug("使用slf4j进行日志记录！");
        return "welcome to spring boot world！";
    }
}
