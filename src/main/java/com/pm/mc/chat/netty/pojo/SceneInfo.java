package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 情景智能实体类
 *
 * @author Liu Xilin
 * @date Created in 2018/08/25 14:52
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class SceneInfo {

    /**
     * 硬件协议号
     */
    private String protocolId;

    /**
     * 开关名称
     */
    private String switchName;

    /**
     * 开关定时开启时间
     */
    private String startTime;

    /**
     * 开关定时关闭时间
     */
    private String endTime;
}
