package com.wwn.film.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwn.film.api.service.user.UserInfoModel;
import com.wwn.film.api.service.user.UserModel;
import com.wwn.film.api.service.user.UserService;
import com.wwn.film.user.dao.UserDOMapper;
import com.wwn.film.user.entity.UserDO;
import com.wwn.film.user.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 15:12
 */

@Component
@Service(interfaceClass = UserService.class, loadbalance = "roundrobin")
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public int login(String username, String password) {
        log.info(username + " login...");
        UserDO userDO = userDOMapper.selectByUsername(username);
        if (userDO != null && userDO.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (md5Password.equals(userDO.getUserPwd())) {
                log.info(username + " login success");
                return userDO.getUuid();
            }
        }
        log.info(username + " login failed");
        return -1;
    }

    @Override
    public boolean register(UserModel userModel) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userModel.getUsername());
        userDO.setEmail(userModel.getEmail());
        userDO.setAddress(userModel.getAddress());
        userDO.setUserPhone(userModel.getPhone());

        //数据加密 【MD5混淆加密 + 盐值 Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        userDO.setUserPwd(md5Password);
        int id = userDOMapper.insert(userDO);
        if (id > 0) {
            log.info("New User: " + userModel.getUsername() + " phone: " + userModel.getPhone());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUserName(String username) {
        log.info("Check username: " + username);
        Integer result = userDOMapper.validateRecord(username);
        if (result != null && result >= 1) {
            log.info(username + " failed verification. Exist:" + result);
            return false;
        } else {
            log.info(username + " pass verification");
            return true;
        }
    }

    @Override
    public UserInfoModel getUserInfoModel(int uuid) {
        //根据主键查询UserDO
        //把UserDO转换为UserInfoModel，返回
        UserDO userDO = userDOMapper.selectByPrimaryKey(uuid);
        if (userDO == null || userDO.getUuid() != uuid) {
            log.info(uuid + " not exist");
            return null;
        }
        return do2UserInfoModel(userDO);
    }

    @Override
    public UserInfoModel updateUserInfoModel(UserInfoModel userInfoModel) {
        //转换数据
        UserDO userDO = model2UserDO(userInfoModel);
        System.out.println(userInfoModel);
        //更新数据库
        int result = userDOMapper.updateByPrimaryKeySelective(userDO);
        if (result > 0) {
            //通过id读取数据库
            return getUserInfoModel(userInfoModel.getUuid());
        } else {
            return userInfoModel;
        }
    }

    private Date time2Date(long time) {
        return new Date(time);
    }

    private long date2Long(Date date) {
        return date.getTime();
    }

    private UserDO model2UserDO(UserInfoModel userInfoModel) {
        UserDO userDO = new UserDO();
        userDO.setUserPhone(userInfoModel.getPhone());
        userDO.setUserName(userInfoModel.getUsername());
        userDO.setNickName(userInfoModel.getNickname());
        userDO.setLifeState(userInfoModel.getLifeState());
        userDO.setHeadUrl(userInfoModel.getHeadAddress());
        userDO.setEmail(userInfoModel.getEmail());
        userDO.setBirthday(userInfoModel.getBirthday());
        userDO.setBiography(userInfoModel.getBiography());
        userDO.setAddress(userInfoModel.getAddress());
        userDO.setUuid(userInfoModel.getUuid());
        userDO.setUserSex(userInfoModel.getSex());

        if (userInfoModel.getUpdateTime() != 0) {
            userDO.setUpdateTime(time2Date(userInfoModel.getUpdateTime()));
        } else {
            userDO.setUpdateTime(new Date());
        }
        if (userInfoModel.getCreateTime() != 0) {
            userDO.setBeginTime(time2Date(userInfoModel.getCreateTime()));
        } else {
            userDO.setBeginTime(null);
        }
        return userDO;
    }

    private UserInfoModel do2UserInfoModel(UserDO userDO) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(userDO.getUuid());
        userInfoModel.setUsername(userDO.getUserName());
        userInfoModel.setSex(userDO.getUserSex());
        userInfoModel.setPhone(userDO.getUserPhone());
        userInfoModel.setNickname(userDO.getNickName());
        userInfoModel.setLifeState(userDO.getLifeState());
        userInfoModel.setHeadAddress(userDO.getHeadUrl());
        userInfoModel.setEmail(userDO.getEmail());
        userInfoModel.setBirthday(userDO.getBirthday());
        userInfoModel.setBiography(userDO.getBiography());
        userInfoModel.setAddress(userDO.getAddress());
        userInfoModel.setUpdateTime(date2Long(userDO.getUpdateTime()));
        userInfoModel.setCreateTime(date2Long(userDO.getBeginTime()));

        return userInfoModel;
    }
}
