package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 系统报告信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:19
 */
@ToString
public class SystemMessage {
    private final String iccid;
    private final String systemName;
    private final int systemStatus;
    private final int status;

    private SystemMessage(SystemBuilder builder) {
        this.iccid = builder.iccid;
        this.systemName = builder.systemName;
        this.systemStatus = builder.systemStatus;
        this.status = builder.status;
    }

    public String getIccid() {
        return iccid;
    }

    public String getSystemName() {
        return systemName;
    }

    public int getSystemStatus() {
        return systemStatus;
    }

    public int getStatus() {
        return status;
    }

    public static class SystemBuilder {
        private String iccid;
        private String systemName;
        private int systemStatus;
        private int status;

        public SystemBuilder() {
        }

        public SystemBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public SystemBuilder systemName(String systemName) {
            this.systemName = systemName;
            return this;
        }

        public SystemBuilder systemStatus(int systemStatus) {
            this.systemStatus = systemStatus;
            return this;
        }

        public SystemBuilder status(int status) {
            this.status = status;
            return this;
        }

        public SystemMessage build() {
            return new SystemMessage(this);
        }
    }
}
