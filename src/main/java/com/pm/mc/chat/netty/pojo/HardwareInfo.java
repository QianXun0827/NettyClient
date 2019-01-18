package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 硬件报告实体类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 13:58
 */
@ToString
public class HardwareInfo {
    private final String hardwareParam;
    private final String hardwareValue;
    private final String hardwareStatus;

    private HardwareInfo(HardwareInfoBuilder builder) {
        this.hardwareParam = builder.hardwareName;
        this.hardwareValue = builder.hardwareValue;
        this.hardwareStatus = builder.hardwareStatus;
    }

    public String getHardwareParam() {
        return hardwareParam;
    }

    public String getHardwareValue() {
        return hardwareValue;
    }

    public String getHardwareStatus() {
        return hardwareStatus;
    }

    /**
     * 静态内部类
     */
    public static class HardwareInfoBuilder {
        private String hardwareName;
        private String hardwareValue;
        private String hardwareStatus;

        public HardwareInfoBuilder() {
        }

        public HardwareInfoBuilder hardwareName(String hardwareName) {
            this.hardwareName = hardwareName;
            return this;
        }

        public HardwareInfoBuilder hardwareValue(String hardwareValue) {
            this.hardwareValue = hardwareValue;
            return this;
        }

        public HardwareInfoBuilder hardwareStatus(String hardwareStatus) {
            this.hardwareStatus = hardwareStatus;
            return this;
        }

        public HardwareInfo build() {
            return new HardwareInfo(this);
        }
    }
}
