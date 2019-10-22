package com.xmzpc.provider;

import com.xmzpc.framework.Protocol;
import com.xmzpc.framework.ProtocolFactory;
import com.xmzpc.framework.URL;
import com.xmzpc.provider.api.HelloService;
import com.xmzpc.provider.impl.HelloServiceImpl;
import com.xmzpc.register.RemoteMapRegister;

/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class Provider {

    private static boolean isRun = true;

    public static void main(String[] args) {
        // 注册服务
        URL url = new URL("localhost", Integer.valueOf(System.getProperty("port")));
        RemoteMapRegister.regist(HelloService.class.getName(), url);
        //ZookeeperRegister.regist(HelloService.class.getName(), url);
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 启动Tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);


    }
}
