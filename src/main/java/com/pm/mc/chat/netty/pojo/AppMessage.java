package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * APP信息类
 *
 * @author Liu Xilin
 * @date Created in 2018/08/23 15:26
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class AppMessage {
    private int apkId;
    private String appName;
    private String packageName;
    private String url;
    private String updateTime;
    private int state;
}
