package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author huhaiqiang
 * @date 2018/10/06 14:32
 */
@Getter
@Builder
public class CmsAdsSettingMessage {

    private Integer adsSetId;
    private String iccid;
    private Integer subareaNum;
    private String adsAreaVoice;
    private Integer status;
}
