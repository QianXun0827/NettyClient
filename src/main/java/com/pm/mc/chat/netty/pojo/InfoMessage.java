package com.pm.mc.chat.netty.pojo;

/**
 * @author hepeng
 * @ProjectName mc
 * @date 2018/8/14/16:58
 * @Description:
 */
public class InfoMessage {

    private final String iccid;

    private final int infoType;

    private final String infoTitle;

    private final String infoMessage;

    private final String startTime;

    private final String endTime;

    private final int status;

    private InfoMessage(InfoMessage.InfoBuilder builder) {
        this.iccid = builder.iccid;
        this.infoType = builder.infoType;
        this.infoTitle = builder.infoTitle;
        this.infoMessage = builder.infoMessage;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
    }

    public String getIccid() {
        return iccid;
    }

    public int getInfoType() {
        return infoType;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getStatus() {
        return status;
    }

    public static class InfoBuilder {

        private  String iccid;

        private  int infoType;

        private  String infoTitle;

        private  String infoMessage;

        private  String startTime;

        private  String endTime;

        private  int status;

        public InfoBuilder() {
        }

        public InfoMessage.InfoBuilder iccid(String iccid) {
            this.iccid = iccid;
            return this;
        }

        public InfoMessage.InfoBuilder infoTitle(String infoTitle) {
            this.infoTitle = infoTitle;
            return this;
        }

        public InfoMessage.InfoBuilder infoType(int infoType) {
            this.infoType = infoType;
            return this;
        }

        public InfoMessage.InfoBuilder infoMessage(String infoMessage) {
            this.infoMessage = infoMessage;
            return this;
        }

        public InfoMessage.InfoBuilder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public InfoMessage.InfoBuilder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public InfoMessage.InfoBuilder status(int status) {
            this.status = status;
            return this;
        }

        public InfoMessage build() {
            return new InfoMessage(this);
        }
    }

}
