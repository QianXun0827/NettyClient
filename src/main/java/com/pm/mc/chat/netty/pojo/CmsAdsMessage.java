package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author huhaiqiang
 * @date 2018/10/06 14:32
 */
@Getter
@Builder
public class CmsAdsMessage {
    
    private String iccid;
    private Integer adsId;
    private Integer shelterAdsId;
    private Integer adsType;
    private String adsArea;
    private String adsFormat;
    private String adsTitle;
    private String adsContent;
    private String shelterMonitor;
    private String startTime;
    private String endTime;
    private Integer status;
}
