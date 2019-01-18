package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author hepeng
 * @ProjectName mc
 * @date 2018/8/13/18:43
 * @Description:
 */
@Getter
@Builder
public class CmsVideoDownMessage {

    private String iccid;

    private Integer videoId;

    private String shelterMonitor;

    private Integer status;
}
