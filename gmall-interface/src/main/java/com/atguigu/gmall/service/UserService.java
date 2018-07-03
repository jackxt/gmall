package com.atguigu.gmall.service;



import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {

    public UserInfo getUserInfo(String id);
    public List<UserInfo> getUserInfo(UserInfo userINfo);
    public void addUser(UserInfo userInfo);
    public void updateUserInfo(UserInfo userInfo, UserInfo userInfoQuery);
    public void updateUserInfo(UserInfo userInfo);
    public void deleteUserInfo(String id);

    public List<UserAddress> getUseraddressList(String userId);
}
