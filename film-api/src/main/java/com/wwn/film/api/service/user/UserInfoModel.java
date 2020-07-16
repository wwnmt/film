package com.wwn.film.api.service.user;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:32
 */
public class UserInfoModel implements Serializable {

    private int uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private int sex;
    private String birthday;
    private int lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private long createTime;
    private long updateTime;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getLifeState() {
        return lifeState;
    }

    public String getBiography() {
        return biography;
    }

    public String getAddress() {
        return address;
    }

    public String getHeadAddress() {
        return headAddress;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setLifeState(int lifeState) {
        this.lifeState = lifeState;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHeadAddress(String headAddress) {
        this.headAddress = headAddress;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfoModel.class.getSimpleName() + "[", "]")
                .add("uuid=" + uuid)
                .add("username='" + username + "'")
                .add("nickname='" + nickname + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .add("sex=" + sex)
                .add("birthday='" + birthday + "'")
                .add("lifeState=" + lifeState)
                .add("biography='" + biography + "'")
                .add("address='" + address + "'")
                .add("headAddress='" + headAddress + "'")
                .add("createTime=" + createTime)
                .add("updateTime=" + updateTime)
                .toString();
    }
}
