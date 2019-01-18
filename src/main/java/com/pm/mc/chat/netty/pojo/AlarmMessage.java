package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

import java.util.List;

/**
 * 告警信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:46
 */
@ToString
public class AlarmMessage {
    private final String iccid;
    private final String alarmType;
    private final int status;
    private final List<AlarmInfo> alarmList;

    private AlarmMessage(AlarmBuilder alarmBuilder) {
        this.iccid = alarmBuilder.iccid;
        this.alarmType = alarmBuilder.alarmType;
        this.status = alarmBuilder.status;
        this.alarmList = alarmBuilder.alarmList;
    }

    public String getIccid() {
        return iccid;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public int getStatus() {
        return status;
    }

    public List<AlarmInfo> getAlarmList() {
        return alarmList;
    }

    public static class AlarmBuilder {
        private String iccid;
        private String alarmType;
        private int status;
        private List<AlarmInfo> alarmList;

        public AlarmBuilder() {
        }

        public AlarmBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public AlarmBuilder alarmType(String alarmType) {
            this.alarmType = alarmType;
            return this;
        }

        public AlarmBuilder status(int status) {
            this.status = status;
            return this;
        }

        public AlarmBuilder alarmList(List<AlarmInfo> alarmList) {
            this.alarmList = alarmList;
            return this;
        }

        public AlarmMessage build() {
            return new AlarmMessage(this);
        }
    }
}
