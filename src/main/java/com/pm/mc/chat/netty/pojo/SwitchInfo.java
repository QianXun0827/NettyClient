package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 开关信息实体类
 *
 * @Author: LIU XILIN
 * @Date: Created in 2018/08/01 10:13
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class SwitchInfo {
    private String protocolId;
    private String switchName;
    private String switchStatus;
}
