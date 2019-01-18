package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author hepeng
 * @ProjectName mc
 * @date 2018/8/14/16:58
 * @Description:
 */
@Getter
@Builder
public class CmsVideoMessage {

    private String iccid;

    private String videoTitle;

    private int videoType;

    private String videoUrl;

    private String startTime;

    private String shelterMonitor;

    private String endTime;

    private int status;

    private int videoId;

}
