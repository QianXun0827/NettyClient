package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 盒子监控信息类
 *
 * @author Liu Xilin
 * @date Created in 2018/09/28 16:46
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class BoxReportMessage {
    /**
     * 站牌唯一标识
     */
    private String iccid;

    /**
     * 盒子报告编号
     */
    private String boxReportId;

    /**
     * 盒子名称
     */
    private String boxName;

    /**
     * 内存使用
     */
    private int memoryPer;

    /**
     * 网络信号
     */
    private int netSignal;

    /**
     * 硬盘
     */
    private String hardDisk;

    /**
     *版本号
     */
    private String versionInfo;

    /**
     * 数据接收状态
     */
    private int state;
}
