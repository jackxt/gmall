package com.atguigu.gmall.gmallusermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.gmallusermanage.mapper.UserAddressMapper;
import com.atguigu.gmall.gmallusermanage.mapper.UserMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public UserInfo getUserInfo(String id) {
        UserInfo userInfo = userMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @Override
    public List<UserInfo> getUserInfo(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName", "%"+userInfo.getNickName()+"%");
        List<UserInfo> userInfoList = userMapper.selectByExample(example);
        return userInfoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void deleteUserInfo(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserAddress> getUseraddressList(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        List<UserAddress> userAddressList = userAddressMapper.select(userAddress);
        return userAddressList;
    }

    @Override
    public void updateUserInfo(UserInfo userInfo, UserInfo userInfoQuery) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("name", "%"+userInfoQuery.getName()+"%");
        userMapper.updateByExampleSelective(userInfo, example);
    }


}
