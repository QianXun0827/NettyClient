package com.pm.mc.chat.netty.handler.client;

import com.pm.mc.chat.netty.net.UrlEnum;
import com.pm.mc.chat.netty.pojo.CmsAdsDownMessage;
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
@Service("AdsMessageDownHandler")
@Scope("prototype")
@ChannelHandler.Sharable
@Slf4j
public class AdsDownMessageHandler extends SimpleChannelInboundHandler<CmsAdsDownMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CmsAdsDownMessage cmsAdsDownMessage) throws Exception {
        Msg.AdsDownMessage adsDownMessage = Msg.AdsDownMessage.newBuilder()
                .setIccid(UrlEnum.SERVER_IP_PORT_ICCID.getIccid())
                .setAdsId(cmsAdsDownMessage.getAdsId())
                .setAdsArea(cmsAdsDownMessage.getAdsArea())
                .setShelterMonitor(cmsAdsDownMessage.getShelterMonitor())
                .setStatus(1)
                .build();
        Msg.Message message = Msg.Message.newBuilder()
                .setMessageType(Msg.MessageType.ADS_DOWN)
                .setAdsDownMessage(adsDownMessage)
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
