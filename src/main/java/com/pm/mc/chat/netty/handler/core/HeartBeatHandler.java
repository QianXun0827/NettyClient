package com.pm.mc.chat.netty.handler.core;

import com.pm.mc.chat.netty.net.UrlEnum;
import com.pm.mc.chat.netty.pojo.Msg;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 心跳处理器
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/06 10:44
 */
@Service("HeartBeatHandler")
@ChannelHandler.Sharable
@Slf4j
public class HeartBeatHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.WRITER_IDLE) {
                Channel channel = ctx.channel();
                Msg.Message.Builder message = Msg.Message.newBuilder();
                Msg.PingMessage pingMessage = Msg.PingMessage.newBuilder()
                        .setIccid(UrlEnum.SERVER_IP_PORT_ICCID.getIccid())
                        .build();
                message.setPingMessage(pingMessage)
                        .setMessageType(Msg.MessageType.HEAT_BEAT_CLIENT)
                        .build();
                channel.writeAndFlush(message);
                log.info("发送心跳信息:【{}】", message);
            }
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
