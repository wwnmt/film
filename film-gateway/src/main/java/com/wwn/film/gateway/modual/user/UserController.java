package com.wwn.film.gateway.modual.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwn.film.api.service.user.vo.UserInfoModel;
import com.wwn.film.api.service.user.vo.UserModel;
import com.wwn.film.api.service.user.UserService;
import com.wwn.film.gateway.response.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:00
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Reference(interfaceClass = UserService.class, check = false)
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

    @RequestMapping(value="check",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO<?> check(String username){
        if (username != null && username.trim().length() > 0) {
            boolean notExist = userService.checkUserName(username);
            if (notExist) {
                return ResponseVO.success("用户名不存在");
            } else {
                return ResponseVO.success("用户名已存在");
            }
        } else {
            return ResponseVO.success("用户名不能为空");
        }
    }

    @RequestMapping(value="logout",method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<?> logout(UserModel userModel){
        /*
            1.前端存储jwt 7天：jwt刷新
            2.服务器端存储活动用户信息 30分钟
            3.JWT里的userId为key，查找活跃用户

            退出：
                1.前端删除jwt
                2.后端删除活跃用户缓存
         */
        return ResponseVO.success("用户退出成功");
    }

    @RequestMapping(value="getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<?> getUserInfo(){
        //获取当前用户
        String userId = CurrentUser.getUserId();
        if (userId != null && userId.trim().length() > 0) {
            int uuid = Integer.parseInt(userId);

            UserInfoModel userInfoModel = userService.getUserInfoModel(uuid);
            if (userInfoModel != null) {
                return ResponseVO.success(userInfoModel);
            } else {
                return ResponseVO.appFail("获取用户信息失败");
            }
        } else {
            return ResponseVO.success("用户未登录");
        }
    }

    @RequestMapping(value="updateUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO<?> updateUserInfo(UserInfoModel userInfoModel){
        //获取当前用户
        String userId = CurrentUser.getUserId();
        if (userId != null && userId.trim().length() > 0) {
            int uuid = Integer.parseInt(userId);
            if (uuid != userInfoModel.getUuid()) {
                return ResponseVO.serviceFail("请修改个人的用户信息");
            }
            UserInfoModel newUserInfo = userService.updateUserInfoModel(userInfoModel);
            if (newUserInfo != null) {
                return ResponseVO.success("用户信息修改成功");
            } else {
                return ResponseVO.serviceFail("用户信息修改失败");
            }
        } else {
            return ResponseVO.success("用户未登录");
        }
    }
}
