package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

import java.util.List;

/**
 * 预警信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 15:09
 */
@ToString
public class WarningMessage {
    private final int projectId;
    private final String warningType;
    private final int status;
    private final List<WarningInfo> warningList;

    private WarningMessage(WarningBuilder builder) {
        this.projectId = builder.projectId;
        this.warningType = builder.warningType;
        this.status = builder.status;
        this.warningList = builder.warningList;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getWarningType() {
        return warningType;
    }

    public int getStatus() {
        return status;
    }

    public List<WarningInfo> getWarningList() {
        return warningList;
    }

    public static class WarningBuilder {
        private int projectId;
        private String warningType;
        private int status;
        private List<WarningInfo> warningList;

        public WarningBuilder() {
        }

        public WarningBuilder projectId(int projectId) {
            this.projectId = projectId;
            return this;
        }

        public WarningBuilder warningType(String warningType) {
            this.warningType = warningType;
            return this;
        }

        public WarningBuilder status(int status) {
            this.status = status;
            return this;
        }

        public WarningBuilder warningList(List<WarningInfo> warningList) {
            this.warningList = warningList;
            return this;
        }

        public WarningMessage build() {
            return new WarningMessage(this);
        }
    }
}
