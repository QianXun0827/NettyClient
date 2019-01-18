package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 硬件报告信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:08
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class HardwareMessage {

    private String iccid;
    private String protocolId;
    private String hardwareName;
    private int status;
    private List<HardwareInfo> hardwareList;
}
