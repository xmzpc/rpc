package com.xmzpc.framework;

import com.xmzpc.protocol.dubbo.DubboProtocol;
import com.xmzpc.protocol.http.HttpProtocol;


/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {
        // 工厂模式
        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) name = "http";
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
