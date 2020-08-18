package com.zenki.dataplus.pmi.controller;

import com.zenki.dataplus.pmi.entity.User;
import com.zenki.dataplus.pmi.service.UserService;
import com.zenki.dataplus.pmi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: SysRegistControll
 * @Author: luolei
 * Date:     2020/8/18 17:36
 * Description:
 * History:
 */
@RestController
@RequestMapping("register")
public class SysRegisterController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String register(User user){

        userService.insert(user);

        return "200";
    }
}
