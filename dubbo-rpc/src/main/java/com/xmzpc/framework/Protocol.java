package com.xmzpc.framework;


/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public interface Protocol {

    void start(URL url);
    String send(URL url, Invocation invocation);
}
