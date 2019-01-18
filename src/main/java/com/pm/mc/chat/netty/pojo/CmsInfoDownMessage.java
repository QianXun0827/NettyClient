package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author huhaiqiang
 * @date 2018/08/20 14:34
 */
@Getter
@Builder
public class CmsInfoDownMessage {

    private String iccid;

    private Integer infoId;

    private String shelterMonitor;

    private Integer status;
}

