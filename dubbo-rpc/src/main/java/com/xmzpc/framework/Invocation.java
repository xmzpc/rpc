package com.xmzpc.framework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
@Data
@AllArgsConstructor
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramType;
}
