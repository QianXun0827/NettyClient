package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

import java.util.List;

/**
 * 智能调节信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:29
 */
@ToString
public class AdjustMessage {
    private final String iccid;
    private final int status;
    private final List<AdjustInfo> adjustList;

    private AdjustMessage(AdjustBuilder builder) {
        this.iccid = builder.iccid;
        this.status = builder.status;
        this.adjustList = builder.adjustList;
    }

    public String getIccid() {
        return iccid;
    }

    public int getStatus() {
        return status;
    }

    public List<AdjustInfo> getAdjustList() {
        return adjustList;
    }

    public static class AdjustBuilder {
        private String iccid;
        private int status;
        private List<AdjustInfo> adjustList;

        public AdjustBuilder() {
        }

        public AdjustBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public AdjustBuilder status(int status) {
            this.status = status;
            return this;
        }

        public AdjustBuilder adjustList(List<AdjustInfo> adjustList) {
            this.adjustList = adjustList;
            return this;
        }

        public AdjustMessage build() {
            return new AdjustMessage(this);
        }
    }
}
