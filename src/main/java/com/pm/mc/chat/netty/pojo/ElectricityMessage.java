package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 用电量信息类
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/03 15:15
 */
@ToString
public class ElectricityMessage {
    private final String iccid;
    private final double electrValue;
    private final int status;

    private ElectricityMessage(ElectricityBuilder builder) {
        this.iccid = builder.iccid;
        this.electrValue = builder.electrValue;
        this.status = builder.status;
    }

    public String getIccid() {
        return iccid;
    }

    public double getElectrValue() {
        return electrValue;
    }

    public int getStatus() {
        return status;
    }

    public static class ElectricityBuilder {
        private String iccid;
        private double electrValue;
        private int status;

        public ElectricityBuilder() {
        }

        public ElectricityBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public ElectricityBuilder electrValue(double electrValue) {
            this.electrValue = electrValue;
            return this;
        }

        public ElectricityBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ElectricityMessage build() {
            return new ElectricityMessage(this);
        }
    }
}
