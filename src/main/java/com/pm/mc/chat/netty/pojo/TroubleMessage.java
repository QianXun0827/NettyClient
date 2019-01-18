package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 故障信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:58
 */
@ToString
public class TroubleMessage {
    private final String iccid;
    private final String troubleName;
    private final int troubleStatus;
    private final int status;

    private TroubleMessage(TroubleBuilder builder) {
        this.iccid = builder.iccid;
        this.troubleName = builder.troubleName;
        this.troubleStatus = builder.troubleStatus;
        this.status = builder.status;
    }

    public String getIccid() {
        return iccid;
    }

    public String getTroubleName() {
        return troubleName;
    }

    public int getTroubleStatus() {
        return troubleStatus;
    }

    public int getStatus() {
        return status;
    }

    public static class TroubleBuilder {
        private String iccid;
        private String troubleName;
        private int troubleStatus;
        private int status;

        public TroubleBuilder() {
        }

        public TroubleBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public TroubleBuilder troubleName(String troubleName) {
            this.troubleName = troubleName;
            return this;
        }

        public TroubleBuilder troubleStatus(int troubleStatus) {
            this.troubleStatus = troubleStatus;
            return this;
        }

        public TroubleBuilder status(int status) {
            this.status = status;
            return this;
        }

        public TroubleMessage build() {
            return new TroubleMessage(this);
        }
    }
}
