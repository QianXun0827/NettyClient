package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author huhaiqiang
 * @date 2018/10/06 14:32
 */
@Getter
@Builder
public class CmsRtfMessage {
    
    private String iccid;
    private Integer rtfId;
    private String rtfType;
    private String rtfArea;
    private String rtfTitle;
    private String rtfMessage;
    private String shelterMonitor;
    private String startTime;
    private String endTime;
    private Integer status;
}
