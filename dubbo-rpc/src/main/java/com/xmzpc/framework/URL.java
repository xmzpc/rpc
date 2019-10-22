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
public class URL implements Serializable {
    private String hostname;
    private Integer port;
}
