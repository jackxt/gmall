package com.atguigu.gmall.gmallorderweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Reference
    UserService userService;
    @RequestMapping("/trade")
    @ResponseBody
    public List<UserAddress> trade(HttpServletRequest request){
        //商品信息
        //用户地址信息
        String userId = request.getParameter("userId");

        List<UserAddress> useraddressList = userService.getUseraddressList(userId);

        return useraddressList;
        //支付信息
    }

    @RequestMapping("/saveOrder")
    @ResponseBody
    public String saveOrder(HttpServletRequest request){
        int localPort = request.getLocalPort();
        return "use port:"+localPort;
    }
}
