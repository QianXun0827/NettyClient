package com.pm.mc.chat.netty.pojo;

import lombok.ToString;

/**
 * 登陆信息实体类
 *
 * @author liuxy
 */
@ToString
public class LoginMessage {
    //用户id
    private final String iccid;
    //登陆认证
    private final String token;
    //登陆状态
    private final int status;

    private LoginMessage(LoginBuilder builder) {
        this.iccid = builder.iccid;
        this.token = builder.token;
        this.status = builder.status;
    }

    public String getIccid() {
        return iccid;
    }

    public String getToken() {
        return token;
    }

    public int getStatus() {
        return status;
    }

    public static class LoginBuilder {
        private String iccid;
        private String token;
        private int status;

        public LoginBuilder() {
        }

        public LoginBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public LoginBuilder token(String token) {
            this.token = token;
            return this;
        }

        public LoginBuilder status(int status) {
            this.status = status;
            return this;
        }

        public LoginMessage build() {
            return new LoginMessage(this);
        }
    }
}
