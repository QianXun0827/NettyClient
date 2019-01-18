package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 点检信息实体类
 *
 * @author Liu Xilin
 * @date Created in 2018/09/11 16:25
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class SpotCheck {
    /**
     * 硬件类型
     */
    private String hardwareType;

    /**
     * 检查状态
     */
    private int checkStatus;
}
