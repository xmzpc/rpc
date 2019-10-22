package com.xmzpc.framework;

import java.util.List;
import java.util.Random;


/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class LoadBalance {

    public static URL random(List<URL> list) {
        Random random =new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
