package com.xmzpc.protocol.http;

import com.xmzpc.framework.Invocation;
import com.xmzpc.framework.Protocol;
import com.xmzpc.framework.URL;

/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(),invocation);
    }
}
