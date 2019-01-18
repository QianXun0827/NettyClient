package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 心跳信息类
 *
 * @author liuxy
 */
@ToString
public class PingMessage {

    private final String iccid;
    private final String token;

    private PingMessage(PingBuilder builder) {
        this.iccid = builder.iccid;
        this.token = builder.token;
    }

    public String getIccid() {
        return iccid;
    }

    public String getToken() {
        return token;
    }

    public static class PingBuilder {
        private final String iccid;
        private final String token;

        public PingBuilder(String iccid, String token) {
            this.iccid = iccid;
            this.token = token;
        }

        public PingMessage build() {
            return new PingMessage(this);
        }
    }
}
