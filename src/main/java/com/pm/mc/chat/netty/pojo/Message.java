package com.pm.mc.chat.netty.pojo;

import com.pm.mc.chat.netty.pojo.Msg.MessageType;
import lombok.ToString;

/**
 * 消息总类
 *
 * @author LIU XILIN
 */
@ToString
public class Message {
    private final MessageType messageType;
    private final LoginMessage loginMessage;
    private final PingMessage pingMessage;
    private final HardwareMessage hardwareMessage;
    private final SystemMessage systemMessage;
    private final SwitchMessage switchMessage;
    private final AdjustMessage adjustMessage;
    private final SceneMessage sceneMessage;
    private final AlarmMessage alarmMessage;
    private final TroubleMessage troubleMessage;
    private final WarningMessage warningMessage;
    private final ElectricityMessage electricityMessage;

    private Message(MessageBuilder builder) {
        this.messageType = builder.messageType;
        this.loginMessage = builder.loginMessage;
        this.pingMessage = builder.pingMessage;
        this.hardwareMessage = builder.hardwareMessage;
        this.systemMessage = builder.systemMessage;
        this.switchMessage = builder.switchMessage;
        this.adjustMessage = builder.adjustMessage;
        this.sceneMessage = builder.sceneMessage;
        this.alarmMessage = builder.alarmMessage;
        this.troubleMessage = builder.troubleMessage;
        this.warningMessage = builder.warningMessage;
        this.electricityMessage = builder.electricityMessage;
    }

    public Msg.MessageType getMessageType() {
        return messageType;
    }

    public LoginMessage getLoginMessage() {
        return loginMessage;
    }

    public PingMessage getPingMessage() {
        return pingMessage;
    }

    public HardwareMessage getHardwareMessage() {
        return hardwareMessage;
    }

    public SystemMessage getSystemMessage() {
        return systemMessage;
    }

    public SwitchMessage getSwitchMessage() {
        return switchMessage;
    }

    public AdjustMessage getAdjustMessage() {
        return adjustMessage;
    }

    public SceneMessage getSceneMessage() {
        return sceneMessage;
    }

    public AlarmMessage getAlarmMessage() {
        return alarmMessage;
    }

    public TroubleMessage getTroubleMessage() {
        return troubleMessage;
    }

    public WarningMessage getWarningMessage() {
        return warningMessage;
    }

    public ElectricityMessage getElectricityMessage() {
        return electricityMessage;
    }

    public static class MessageBuilder {
        private Msg.MessageType messageType;
        private LoginMessage loginMessage;
        private PingMessage pingMessage;
        private HardwareMessage hardwareMessage;
        private SystemMessage systemMessage;
        private SwitchMessage switchMessage;
        private AdjustMessage adjustMessage;
        private SceneMessage sceneMessage;
        private AlarmMessage alarmMessage;
        private TroubleMessage troubleMessage;
        private WarningMessage warningMessage;
        private ElectricityMessage electricityMessage;

        public MessageBuilder() {
        }

        public MessageBuilder loginMessage(LoginMessage loginMessage) {
            this.loginMessage = loginMessage;
            return this;
        }

        public MessageBuilder pingMessage(PingMessage pingMessage) {
            this.pingMessage = pingMessage;
            return this;
        }

        public MessageBuilder messageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public MessageBuilder hardwareMessage(HardwareMessage hardwareMessage) {
            this.hardwareMessage = hardwareMessage;
            return this;
        }

        public MessageBuilder systemMessage(SystemMessage systemMessage) {
            this.systemMessage = systemMessage;
            return this;
        }

        public MessageBuilder switchMessage(SwitchMessage switchMessage) {
            this.switchMessage = switchMessage;
            return this;
        }

        public MessageBuilder adjustMessage(AdjustMessage adjustMessage) {
            this.adjustMessage = adjustMessage;
            return this;
        }

        public MessageBuilder sceneMessage(SceneMessage sceneMessage) {
            this.sceneMessage = sceneMessage;
            return this;
        }

        public MessageBuilder alarmMessage(AlarmMessage alarmMessage) {
            this.alarmMessage = alarmMessage;
            return this;
        }

        public MessageBuilder troubleMessage(TroubleMessage troubleMessage) {
            this.troubleMessage = troubleMessage;
            return this;
        }

        public MessageBuilder warningMessage(WarningMessage warningMessage) {
            this.warningMessage = warningMessage;
            return this;
        }

        public MessageBuilder electricityMessage(ElectricityMessage electricityMessage) {
            this.electricityMessage = electricityMessage;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
