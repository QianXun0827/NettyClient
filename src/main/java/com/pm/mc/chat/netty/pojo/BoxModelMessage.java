package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 盒子建模信息类
 *
 * @author Liu Xilin
 * @date Created in 2018/09/19 15:52
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class BoxModelMessage {
    private String iccid;
    private String modelName;
    private String selfCheckTime;
    private String reloadTime;
    private int modelType;
    private int state;
}
