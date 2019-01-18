package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 点检信息类
 *
 * @author Liu Xilin
 * @date Created in 2018/08/15 10:44
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class SpotCheckMessage {

    /**
     * 站牌唯一标识
     */
    private String iccid;

    /**
     * 站牌名称
     */
    private String shelterName;

    /**
     * 点检指令
     */
    private int checkOrder;

    /**
     * 状态
     */
    private int status;

    /**
     * 点检信息实体
     */
    private List<SpotCheck> spotChecks;
}
