package com.pm.mc.chat.netty.handler.core;

import com.pm.mc.chat.netty.pojo.*;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息分发器
 *
 * @author liuxy
 */
@Service("msgChatHandler")
@Scope("prototype")
@Sharable
@Slf4j
public class MsgChatHandler extends SimpleChannelInboundHandler<Msg.Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext chx, Msg.Message message) {
        log.info("服务器[{}]连接成功", chx.channel().remoteAddress());
        System.out.println("<><><><><><><><><><>");
        log.info("接收服务器的信息:==========>>>[{}]", message);

        //通过消息类型进行消息的分发
        switch (message.getMessageType()) {
            //硬件报告
            case HARDWARE_REPORT:
                if (message.getHardwareMessage() != null) {
                    Msg.HardwareMessage hardwareMessage = message.getHardwareMessage();
                    List<HardwareInfo> hardwareInfoList = new ArrayList<>();
                    for (int i = 0; i < hardwareMessage.getHardwareListCount(); i++) {
                        Msg.Hardware hardwareList = hardwareMessage.getHardwareList(i);
                        HardwareInfo hardwareInfo = new HardwareInfo.HardwareInfoBuilder()
                                .hardwareName(hardwareList.getHardwareParam())
                                .hardwareValue(hardwareList.getHardwareValue())
                                .hardwareStatus(hardwareList.getHardwareStatus())
                                .build();
                        hardwareInfoList.add(hardwareInfo);
                    }
                    HardwareMessage msg = HardwareMessage.builder()
                            .iccid(hardwareMessage.getIccid())
                            .protocolId(hardwareMessage.getProtocolId())
                            .hardwareName(hardwareMessage.getHardwareName())
                            .hardwareList(hardwareInfoList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("hardwareMessage == null");
                }
                break;
            //系统报告
            case SYSTEM_REPORT:
                if (message.getSystemMessage() != null) {
                    Msg.SystemMessage systemMessage = message.getSystemMessage();
                    SystemMessage msg = new SystemMessage.SystemBuilder()
                            .iccid(systemMessage.getIccid())
                            .systemName(systemMessage.getSystemName())
                            .systemStatus(systemMessage.getSystemStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("systemMessage == null");
                }
                break;
            //开关状态
            case SWITCH_STATUS:
                if (message.getSwitchMessage() != null) {
                    Msg.SwitchMessage switchMessage = message.getSwitchMessage();

                    List<SwitchInfo> switchInfoList = new ArrayList<>();
                    for (int i = 0; i < switchMessage.getSwitchListCount(); i++) {
                        Msg.Switch switchList = switchMessage.getSwitchList(i);
                        SwitchInfo switchInfo = SwitchInfo.builder()
                                .protocolId(switchList.getProtocolId())
                                .switchName(switchList.getSwitchName())
                                .switchStatus(switchList.getSwitchStatus())
                                .build();
                        switchInfoList.add(switchInfo);
                    }
                    SwitchMessage msg = new SwitchMessage.SwitchBuilder()
                            .iccid(switchMessage.getIccid())
                            .switchList(switchInfoList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("switchMessage == null");
                }
                break;
            //智能调节
            case ADJUST_VALUE:
                if (message.getAdjustMessage() != null) {
                    Msg.AdjustMessage adjustMessage = message.getAdjustMessage();

                    List<AdjustInfo> adjustInfoList = new ArrayList<>();
                    for (int i = 0; i < adjustMessage.getAdjustListCount(); i++) {
                        Msg.Adjust adjustList = adjustMessage.getAdjustList(i);
                        AdjustInfo adjustInfo = AdjustInfo.builder()
                                .protocolId(adjustList.getProtocolId())
                                .adjustName(adjustList.getAdjustName())
                                .adjustValue(adjustList.getAdjustValue())
                                .build();
                        adjustInfoList.add(adjustInfo);
                    }
                    AdjustMessage msg = new AdjustMessage.AdjustBuilder()
                            .iccid(adjustMessage.getIccid())
                            .adjustList(adjustInfoList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("adjustMessage == null");
                }
                break;
            //情景智能
            case SCENE_SMART:
                if (message.getSceneMessage() != null) {
                    Msg.SceneMessage sceneMessage = message.getSceneMessage();

                    List<SceneInfo> sceneInfoList = new ArrayList<>();
                    for (int i = 0; i < sceneMessage.getSceneListCount(); i++) {
                        Msg.Scene sceneInfos = sceneMessage.getSceneList(i);
                        SceneInfo sceneInfo = SceneInfo.builder()
                                .protocolId(sceneInfos.getProtocolId())
                                .switchName(sceneInfos.getSwitchName())
                                .startTime(sceneInfos.getStartTime())
                                .endTime(sceneInfos.getEndTime())
                                .build();
                        sceneInfoList.add(sceneInfo);
                    }
                    SceneMessage msg = SceneMessage.builder()
                            .projectId(sceneMessage.getProjectId())
                            .sceneInfos(sceneInfoList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("sceneMessage == null");
                }
                break;
            //告警信息
            case ALARM_INFO:
                if (message.getAlarmMessage() != null) {
                    Msg.AlarmMessage alarmMessage = message.getAlarmMessage();

                    List<AlarmInfo> alarmInfoList = new ArrayList<>();
                    for (int i = 0; i < alarmMessage.getAlarmListCount(); i++) {
                        Msg.Alarm alarmList = alarmMessage.getAlarmList(i);
                        AlarmInfo alarmInfo = new AlarmInfo.AlarmInfoBuilder()
                                .alarmName(alarmList.getAlarmName())
                                .alarmStatus(alarmList.getAlarmStatus())
                                .build();
                        alarmInfoList.add(alarmInfo);
                    }
                    AlarmMessage msg = new AlarmMessage.AlarmBuilder()
                            .iccid(alarmMessage.getIccid())
                            .alarmType(alarmMessage.getAlarmType())
                            .alarmList(alarmInfoList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("alarmMessage == null");
                }
                break;
            //故障信息
            case TROUBLE_INFO:
                if (message.getTroubleMessage() != null) {
                    Msg.TroubleMessage troubleMessage = message.getTroubleMessage();
                    TroubleMessage msg = new TroubleMessage.TroubleBuilder()
                            .iccid(troubleMessage.getIccid())
                            .troubleName(troubleMessage.getTroubleName())
                            .troubleStatus(troubleMessage.getTroubleStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("troubleMessage == null");
                }
                break;
            //预警信息
            case WARING_INFO:
                if (message.getWarningMessage() != null) {
                    Msg.WarningMessage warningMessage = message.getWarningMessage();

                    List<WarningInfo> warningInfoList = new ArrayList<>();
                    for (int i = 0; i < warningMessage.getWarningListCount(); i++) {
                        Msg.Warning warningList = warningMessage.getWarningList(i);
                        WarningInfo warningInfo = WarningInfo.builder()
                                .warningName(warningList.getWarningName())
                                .warningValue(warningList.getWarningValue())
                                .build();
                        warningInfoList.add(warningInfo);
                    }
                    WarningMessage msg = new WarningMessage.WarningBuilder()
                            .projectId(warningMessage.getProjectId())
                            .warningType(warningMessage.getWarningType())
                            .warningList(warningInfoList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("warningMessage == null");
                }
                break;
            //用电量信息
            case ELECTRICITY_INFO:
                if (message.getElectricityMessage() != null) {
                    Msg.ElectricityMessage electricityMessage = message.getElectricityMessage();
                    ElectricityMessage msg = new ElectricityMessage.ElectricityBuilder()
                            .iccid(electricityMessage.getIccid())
                            .electrValue(electricityMessage.getElectrValue())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("electricityMessage == null");
                }
                break;
            //巡检信息
            case POLLING_CHECK:
                if (message.getPollingCheckMessage() != null) {
                    Msg.PollingCheckMessage pollingCheckMessage = message.getPollingCheckMessage();
                    List<PollingCheck> pollingCheckList = new ArrayList<>();
                    for (int i = 0; i < pollingCheckMessage.getPollingChecksCount(); i++) {
                        Msg.PollingCheck pollingCheckInfo = pollingCheckMessage.getPollingChecks(i);
                        PollingCheck pollingCheck = PollingCheck.builder()
                                .iccid(pollingCheckInfo.getIccid())
                                .shelterName(pollingCheckInfo.getShelterName())
                                .checkStatus(pollingCheckInfo.getCheckStatus())
                                .build();
                        pollingCheckList.add(pollingCheck);
                    }
                    PollingCheckMessage msg = PollingCheckMessage.builder()
                            .checkOrder(pollingCheckMessage.getCheckOrder())
                            .pollingChecks(pollingCheckList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("pollingCheckMessage == null");
                }
                break;
            //点检信息
            case SPOT_CHECK:
                if (message.getSpotCheckMessage() != null) {
                    Msg.SpotCheckMessage spotCheckMessage = message.getSpotCheckMessage();
                    List<SpotCheck> spotCheckList = new ArrayList<>();
                    for (int i = 0; i < spotCheckMessage.getSpotChecksCount(); i++) {
                        Msg.SpotCheck spotCheckInfo = spotCheckMessage.getSpotChecks(i);
                        SpotCheck spotCheck = SpotCheck.builder()
                                .hardwareType(spotCheckInfo.getHardwareType())
                                .checkStatus(spotCheckInfo.getCheckStatus())
                                .build();
                        spotCheckList.add(spotCheck);
                    }
                    SpotCheckMessage msg = SpotCheckMessage.builder()
                            .iccid(spotCheckMessage.getIccid())
                            .shelterName(spotCheckMessage.getShelterName())
                            .checkOrder(spotCheckMessage.getCheckOrder())
                            .spotChecks(spotCheckList)
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("spotCheckMessage == null");
                }
                break;
            case VIDEO_PUBLISH:
                if (message.getVideoMessage() != null) {
                    Msg.VideoMessage videoMessage = message.getVideoMessage();
                    CmsVideoMessage msg = CmsVideoMessage.builder()
                            .iccid(videoMessage.getIccid())
                            .videoId(videoMessage.getVideoId())
                            .shelterMonitor(videoMessage.getShelterMonitor())
                            .status(videoMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("videoMessage == null");
                }
                break;
            case VIDEO_DOWN:
                if (message.getVideoDownMessage() != null) {
                    Msg.VideoDownMessage videoDownMessage = message.getVideoDownMessage();
                    CmsVideoDownMessage msg = CmsVideoDownMessage.builder()
                            .iccid(videoDownMessage.getIccid())
                            .status(videoDownMessage.getStatus())
                            .videoId(videoDownMessage.getVideoId())
                            .shelterMonitor(videoDownMessage.getShelterMonitor())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("videoDownMessage == null");
                }
                break;
            case INFO_PUBLISH:
                if (message.getInfoMessage() != null) {
                    Msg.InfoMessage infoMessage = message.getInfoMessage();
                    CmsInfoMessage msg = CmsInfoMessage.builder()
                            .iccid(infoMessage.getIccid())
                            .infoId(infoMessage.getInfoId())
                            .status(infoMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("infoMessage == null");
                }
                break;
            case INFO_DOWN:
                if (message.getInfoDownMessage() != null) {
                    Msg.InfoDownMessage infoDownMessage = message.getInfoDownMessage();
                    CmsInfoDownMessage msg = CmsInfoDownMessage.builder()
                            .iccid(infoDownMessage.getIccid())
                            .status(infoDownMessage.getStatus())
                            .infoId(infoDownMessage.getInfoId())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("infoDownMessage == null");
                }
                break;
            case APP_INFO:
                if (message.getAppMessage() != null) {
                    Msg.AppMessage appMessage = message.getAppMessage();
                    AppMessage msg = AppMessage.builder()
                            .apkId(appMessage.getApkId())
                            .appName(appMessage.getAppName())
                            .packageName(appMessage.getPackageName())
                            .url(appMessage.getUrl())
                            .updateTime(appMessage.getUpdateTime())
                            .state(appMessage.getState())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("appMessage == null");
                }
                break;
            case VIRUS_LIST:
                if (message.getVirusListMessage() != null) {
                    Msg.VirusListMessage virusListMessage = message.getVirusListMessage();
                    VirusListMessage msg = VirusListMessage.builder()
                            .iccid(virusListMessage.getIccid())
                            .packageName(virusListMessage.getPackageName())
                            .versionNum(virusListMessage.getVersionNum())
                            .level(virusListMessage.getLevel())
                            .virusListType(virusListMessage.getVirusListType())
                            .virusListState(virusListMessage.getVirusListState())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("virusListMessage == null");
                }
                break;
            case BOX_MODEL:
                if (message.getBoxModelMessage() != null) {
                    Msg.BoxModelMessage boxModelMessage = message.getBoxModelMessage();
                    BoxModelMessage msg = BoxModelMessage.builder()
                            .iccid(boxModelMessage.getIccid())
                            .modelName(boxModelMessage.getModelName())
                            .selfCheckTime(boxModelMessage.getSelfCheckTime())
                            .reloadTime(boxModelMessage.getReloadTime())
                            .modelType(boxModelMessage.getModelType())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("boxModelMessage == null");
                }
                break;
            case BOX_STATE:
                if (message.getBoxReportMessage() != null) {
                    Msg.BoxReportMessage boxReportMessage = message.getBoxReportMessage();
                    BoxReportMessage msg = BoxReportMessage.builder()
                            .iccid(boxReportMessage.getIccid())
                            .boxReportId(boxReportMessage.getBoxReportId())
                            .boxName(boxReportMessage.getBoxName())
                            .memoryPer(boxReportMessage.getMemoryPer())
                            .netSignal(boxReportMessage.getNetSignal())
                            .hardDisk(boxReportMessage.getHardDisk())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("boxReportMessage == null");
                }
                break;
            case RTF_DOWN:
                if (message.getRtfDownMessage() != null) {
                    Msg.RtfDownMessage rtfDownMessage = message.getRtfDownMessage();
                    CmsRtfDownMessage msg = CmsRtfDownMessage.builder()
                            .iccid(rtfDownMessage.getIccid())
                            .rftId(rtfDownMessage.getRtfId())
                            .shelterMonitor(rtfDownMessage.getShelterMonitor())
                            .status(rtfDownMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("rtfDownMessage == null");
                }
                break;
            case RTF_PUBLISH:
                if (message.getRtfMessage() != null) {
                    Msg.RtfMessage rtfMessage = message.getRtfMessage();
                    CmsRtfMessage msg = CmsRtfMessage.builder()
                            .iccid(rtfMessage.getIccid())
                            .rtfId(rtfMessage.getRtfId())
                            .shelterMonitor(rtfMessage.getShelterMonitor())
                            .status(rtfMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("rtfPublishMessage == null");
                }
                break;
            case TOL_DOWN:
                if (message.getRtfDownMessage() != null) {
                    Msg.TolDownMessage tolDownMessage = message.getTolDownMessage();
                    CmsRtfDownMessage msg = CmsRtfDownMessage.builder()
                            .iccid(tolDownMessage.getIccid())
                            .rftId(tolDownMessage.getVideoId())
                            .shelterMonitor(tolDownMessage.getShelterMonitor())
                            .status(tolDownMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("tolDownMessage == null");
                }
                break;
            case TOL_PUBLISH:
                if (message.getRtfMessage() != null) {
                    Msg.TolMessage tolMessage = message.getTolMessage();
                    CmsRtfMessage msg = CmsRtfMessage.builder()
                            .iccid(tolMessage.getIccid())
                            .rtfId(tolMessage.getVideoId())
                            .shelterMonitor(tolMessage.getShelterMonitor())
                            .status(tolMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("tolPublishMessage == null");
                }
                break;
            case ADS_SETTING:
                if (message.getAdsMessage() != null) {
                    Msg.AdsSettingMessage adsSettingMessage = message.getAdsSettingMessage();
                    CmsAdsSettingMessage msg = CmsAdsSettingMessage.builder()
                            .iccid(adsSettingMessage.getIccid())
                            .subareaNum(adsSettingMessage.getSubareaNum())
                            .adsAreaVoice(adsSettingMessage.getAdsAreaVoice())
                            .status(adsSettingMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("adsSettingMessage == null");
                }
                break;
            case ADS_PUBLISH:
                if (message.getRtfMessage() != null) {
                    Msg.AdsMessage adsMessage = message.getAdsMessage();
                    CmsAdsMessage msg = CmsAdsMessage.builder()
                            .iccid(adsMessage.getIccid())
                            .adsId(adsMessage.getAdsId())
                            .adsArea(adsMessage.getAdsArea())
                            .adsType(adsMessage.getAdsType())
                            .shelterMonitor(adsMessage.getShelterMonitor())
                            .status(adsMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("adsPublishMessage == null");
                }
                break;
            case ADS_DOWN:
                if (message.getAdsDownMessage() != null) {
                    Msg.AdsDownMessage adsDownMessage = message.getAdsDownMessage();
                    CmsAdsDownMessage msg = CmsAdsDownMessage.builder()
                            .iccid(adsDownMessage.getIccid())
                            .adsId(adsDownMessage.getAdsId())
                            .adsArea(adsDownMessage.getAdsArea())
                            .shelterMonitor(adsDownMessage.getShelterMonitor())
                            .status(adsDownMessage.getStatus())
                            .build();
                    chx.fireChannelRead(msg);
                } else {
                    log.info("adsDownMessage == null");
                }
                break;
            default:
                break;
        }
        ReferenceCountUtil.release(message);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接到服务器:[{}]", ctx.channel().remoteAddress());
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接关闭！");
        ctx.fireChannelInactive();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
