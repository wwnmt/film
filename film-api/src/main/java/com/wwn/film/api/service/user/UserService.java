package com.wwn.film.api.service.user;

import com.wwn.film.api.service.user.vo.UserInfoModel;
import com.wwn.film.api.service.user.vo.UserModel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 15:09
 */
public interface UserService {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUserName(String username);

    UserInfoModel getUserInfoModel(int uuid);

    UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel);

}
