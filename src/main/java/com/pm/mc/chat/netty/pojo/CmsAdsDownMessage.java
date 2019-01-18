package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author huhaiqiang
 * @date 2018/10/5/17:50
 */
@Getter
@Builder(toBuilder = true)
public class CmsAdsDownMessage {

    private Integer adsId;
    private Integer shelterAdsId;
    private String shelterMonitor;
    private String adsArea;
    private String iccid;
    private Integer status;
}
