package com.xmzpc.comsumer;

import com.xmzpc.framework.ProxyFactory;
import com.xmzpc.provider.api.HelloService;
/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        for (;;) {
            try {
                String result = helloService.sayHello("World");
                System.out.println(result);
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }

    }
}
