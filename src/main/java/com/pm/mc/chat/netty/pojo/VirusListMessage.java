package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 盒子黑白名单信息类
 *
 * @author Liu Xilin
 * @date Created in 2018/09/13 10:39
 */
@Getter
@Builder
@ToString
public class VirusListMessage {
    /**
     * 站牌唯一标识
     */
    private String iccid;

    /**
     * 黑白名单包名
     */
    private String packageName;

    /**
     * 版本号
     */
    private String versionNum;

    /**
     * 黑名单等级（白名单默认为0）
     */
    private int level;

    /**
     * 黑白名单类型（白名单：0，黑名单：1）
     */
    private int virusListType;

    /**
     * 白名单操作状态（黑名单默认为0，白名单新增：1，白名单删除：2）
     */
    private int virusListState;

    /**
     * 消息接收状态
     */
    private int state;
}
