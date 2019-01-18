package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 情景智能信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:35
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class SceneMessage {
    /**
     * 项目ID
     */
    private int projectId;

    /**
     * 情景智能信息
     */
    private List<SceneInfo> sceneInfos;

    /**
     * 状态信息
     */
    private int status;
}
