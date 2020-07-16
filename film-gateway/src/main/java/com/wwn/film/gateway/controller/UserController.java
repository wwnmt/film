package com.wwn.film.gateway.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwn.film.api.service.user.UserModel;
import com.wwn.film.api.service.user.UserService;
import com.wwn.film.gateway.common.user.CurrentUser;
import com.wwn.film.gateway.response.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:00
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @Reference(interfaceClass = UserService.class)
    private UserService userService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<?> test() {
        System.out.println(CurrentUser.getUserId());
        return ResponseVO.success("ok");
    }

    @RequestMapping(value="register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO<?> register(UserModel userModel){
        if(userModel.getUsername() == null || userModel.getUsername().trim().length()==0){
            return ResponseVO.serviceFail("用户名不能为空");
        }
        if(userModel.getPassword() == null || userModel.getPassword().trim().length()==0){
            return ResponseVO.serviceFail("密码不能为空");
        }

        boolean isSuccess = userService.register(userModel);
        if(isSuccess){
            return ResponseVO.success("注册成功");
        }else{
            return ResponseVO.serviceFail("注册失败");
        }
    }
}
