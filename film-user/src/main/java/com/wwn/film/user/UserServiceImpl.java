package com.wwn.film.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwn.film.api.service.user.UserInfoModel;
import com.wwn.film.api.service.user.UserModel;
import com.wwn.film.api.service.user.UserService;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 15:12
 */

@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService{

    @Override
    public int login(String username, String password) {
        System.out.println("this is userService. username:" + username + " password:" + password);
        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {
        return false;
    }

    @Override
    public boolean checkUserName(String username) {
        return false;
    }

    @Override
    public UserInfoModel getUserInfoModel(int uuid) {
        return null;
    }

    @Override
    public UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel) {
        return null;
    }
}
