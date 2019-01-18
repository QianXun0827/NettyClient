package com.pm.mc.chat.netty.handler.client;

import com.pm.mc.chat.netty.net.UrlEnum;
import com.pm.mc.chat.netty.pojo.CmsAdsMessage;
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
@Service("AdsMessagePublishHandler")
@Scope("prototype")
@ChannelHandler.Sharable
@Slf4j
public class AdsMessagePublishHandler extends SimpleChannelInboundHandler<CmsAdsMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CmsAdsMessage cmsAtfMessage) throws Exception {
        Msg.AdsMessage adsMessage = Msg.AdsMessage.newBuilder()
                .setAdsId(cmsAtfMessage.getAdsId())
                .setIccid(UrlEnum.SERVER_IP_PORT_ICCID.getIccid())
                .setAdsType(cmsAtfMessage.getAdsType())
                .setAdsArea(cmsAtfMessage.getAdsArea())
                .setShelterMonitor(cmsAtfMessage.getShelterMonitor())
                .setStatus(1)
                .build();
        Msg.Message message = Msg.Message.newBuilder()
                .setMessageType(Msg.MessageType.ADS_PUBLISH)
                .setAdsMessage(adsMessage)
                .build();
        channelHandlerContext.writeAndFlush(message);
        log.info("返回服务器【ADS_PUBLISH】信息接收成功消息：【{}】", message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("rtfMessage publish exception...");
        ctx.close();
    }
}
