package com.pm.mc.chat.netty.handler.client;

import com.pm.mc.chat.netty.net.UrlEnum;
import com.pm.mc.chat.netty.pojo.CmsAdsDownMessage;
import com.pm.mc.chat.netty.pojo.CmsAdsSettingMessage;
import com.pm.mc.chat.netty.pojo.Msg;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 富文本信息发布处理器
 *
 * @author huhaiqiang
 * @date 2018/10/06 10:46
 */
@Service("AdsSettingMessageHandler")
@Scope("prototype")
@ChannelHandler.Sharable
@Slf4j
public class AdsSettingMessageHandler extends SimpleChannelInboundHandler<CmsAdsSettingMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CmsAdsSettingMessage cmsAdsSettingMessage) throws Exception {
        Msg.AdsSettingMessage adsSettingMessage = Msg.AdsSettingMessage.newBuilder()
                .setIccid(UrlEnum.SERVER_IP_PORT_ICCID.getIccid())
                .setSubareaNum(cmsAdsSettingMessage.getSubareaNum())
                .setAdsAreaVoice(cmsAdsSettingMessage.getAdsAreaVoice())
                .setStatus(1)
                .build();
        Msg.Message message = Msg.Message.newBuilder()
                .setMessageType(Msg.MessageType.ADS_SETTING)
                .setAdsSettingMessage(adsSettingMessage)
                .build();
        channelHandlerContext.writeAndFlush(message);
        log.info("返回服务器客户端数据处理成功消息：【{}】", message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("rtfMessage publish exception...");
        ctx.close();
    }
}
