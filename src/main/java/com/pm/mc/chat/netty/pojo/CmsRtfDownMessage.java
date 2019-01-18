package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author hepeng
 * @ProjectName mc
 * @date 2018/10/5/17:50
 * @Description:
 */
@Getter
@Builder(toBuilder = true)
public class CmsRtfDownMessage {
    /**
     * 视频id
     */
    private Integer rftId;

    /**
     * 显示器标识
     */
    private String shelterMonitor;

    /**
     * 富文本区域
     */
    private String rtfArea;

    /**
     * 站牌唯一标识
     */
    private String iccid;

    /**
     * 终端执行成功状态
     */
    private Integer status;
}
