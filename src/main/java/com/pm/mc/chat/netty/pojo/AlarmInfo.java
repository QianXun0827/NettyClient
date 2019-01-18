package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 告警信息实体类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 14:42
 */
@ToString
public class AlarmInfo {
    private final String alarmName;
    private final int alarmStatus;

    private AlarmInfo(AlarmInfoBuilder builder) {
        this.alarmName = builder.alarmName;
        this.alarmStatus = builder.alarmStatus;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public int getAlarmStatus() {
        return alarmStatus;
    }

    public static class AlarmInfoBuilder {
        private String alarmName;
        private int alarmStatus;

        public AlarmInfoBuilder() {
        }

        public AlarmInfoBuilder alarmName(String alarmName) {
            this.alarmName = alarmName;
            return this;
        }

        public AlarmInfoBuilder alarmStatus(int alarmStatus) {
            this.alarmStatus = alarmStatus;
            return this;
        }

        public AlarmInfo build() {
            return new AlarmInfo(this);
        }
    }
}
