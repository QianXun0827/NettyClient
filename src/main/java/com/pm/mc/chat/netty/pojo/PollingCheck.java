package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 巡检信息实体类
 *
 * @author Liu Xilin
 * @date Created in 2018/09/11 16:09
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class PollingCheck {
    /**
     * 站牌唯一标识
     */
    private String iccid;

    /**
     * 站牌名称
     */
    private String shelterName;

    /**
     * 检查状态
     */
    private int checkStatus;
}
