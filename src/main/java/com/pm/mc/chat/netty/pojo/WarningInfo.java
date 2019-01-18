package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 预警实体类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 15:03
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class WarningInfo {
    private String warningName;
    private String warningValue;

}
