package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author huhaiqiang
 * @date 2018/08/20 14:34
 */
@Getter
@Builder
public class CmsInfoMessage {

    private String iccid;

    private Integer infoId;

    private Integer infoType;

    private String infoTitle;

    private String infoMessage;

    private String shelterMonitor;

    private String startTime;

    private String endTime;

    private Integer status;

}
