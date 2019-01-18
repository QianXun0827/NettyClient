package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

import java.util.List;

/**
 * 智能开关信息
 *
 * @Author: LIU XILIN
 * @Date: Created in 2018/08/01 10:10
 */
@ToString
public class SwitchMessage {
    private final String iccid;
    private final int status;
    private final List<SwitchInfo> switchList;

    private SwitchMessage(SwitchBuilder builder) {
        this.iccid = builder.iccid;
        this.status = builder.status;
        this.switchList = builder.switchList;
    }

    public String getIccid() {
        return iccid;
    }

    public int getStatus() {
        return status;
    }

    public List<SwitchInfo> getSwitchList() {
        return switchList;
    }

    public static class SwitchBuilder {
        private String iccid;
        private int status;
        private List<SwitchInfo> switchList;

        public SwitchBuilder() {

        }

        public SwitchBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public SwitchBuilder status(int status) {
            this.status = status;
            return this;
        }

        public SwitchBuilder switchList(List<SwitchInfo> switchList) {
            this.switchList = switchList;
            return this;
        }

        public SwitchMessage build() {
            return new SwitchMessage(this);
        }
    }
}
