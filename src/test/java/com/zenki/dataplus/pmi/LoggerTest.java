package com.zenki.dataplus.pmi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 *  Created by shao.guangze on 2020/6/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private  final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){

        logger.debug("in debug......");
        logger.info("in info........");
        logger.error("in error..........");

    }
}
