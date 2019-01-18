package com.pm.mc.chat.netty.net;

/**
 * 功能描述：
 * 【】
 *
 * @author huhaiqiang
 * @version V1.0
 * @date 2019/01/17 17:34
 */
public enum UrlEnum {

    /**
     * 服务器IP、端口号、iccid
     */
//    SERVER_IP_PORT_ICCID("47.98.225.240",10201,"10001");
    SERVER_IP_PORT_ICCID("192.168.2.139",10012,"10001");

    private String ip;
    private Integer post;
    private String iccid;

    UrlEnum(String ip, Integer post, String iccid) {
        this.ip = ip;
        this.post = post;
        this.iccid = iccid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}
