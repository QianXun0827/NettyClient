package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 巡检信息类
 *
 * @author Liu Xilin
 * @date Created in 2018/08/15 10:33
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class PollingCheckMessage {
    /**
     * 巡检信息实体
     */
    private List<PollingCheck> pollingChecks;

    /**
     * 巡检指令
     */
    private int checkOrder;

    /**
     * 状态
     */
    private int status;
}
