package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 智能调节实体类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:25
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class AdjustInfo {
    private String protocolId;
    private String adjustName;
    private String adjustValue;

}
