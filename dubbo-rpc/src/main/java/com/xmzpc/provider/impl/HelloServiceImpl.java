package com.xmzpc.provider.impl;

import com.xmzpc.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        return "Hello: " + userName;
    }
}
