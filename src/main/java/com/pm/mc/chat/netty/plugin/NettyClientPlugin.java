package com.pm.mc.chat.netty.plugin;

import com.pm.mc.chat.netty.net.UrlEnum;
import com.pm.mc.chat.netty.pipeline.NettyInitializerPipeline;
import com.pm.mc.chat.netty.pojo.Msg;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Netty客户端
 *
 * @Author: Liu Xilin
 * @Date: Created in 2018/08/06 09:19
 */
@Slf4j
public class NettyClientPlugin {

    private static EventLoopGroup group = new NioEventLoopGroup();
    private static Bootstrap bootstrap = new Bootstrap();
    private static Channel channel;

    public static void main(String[] args) throws Exception {
        log.info("客户端启动成功...");
        bootstrap.group(group).channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true);
        bootstrap.remoteAddress(UrlEnum.SERVER_IP_PORT_ICCID.getIp(), UrlEnum.SERVER_IP_PORT_ICCID.getPost());
        bootstrap.handler(new NettyInitializerPipeline());
        channel = bootstrap.connect(UrlEnum.SERVER_IP_PORT_ICCID.getIp(), UrlEnum.SERVER_IP_PORT_ICCID.getPost()).sync().channel();

        //登陆
        Msg.Message.Builder message = Msg.Message.newBuilder();
        Msg.LoginMessage.Builder loginMsg = Msg.LoginMessage.newBuilder();
        loginMsg.setIccid(UrlEnum.SERVER_IP_PORT_ICCID.getIccid())
                .setToken("TestTokenOne")
                .build();
        message.setMessageType(Msg.MessageType.CLIENT_LOGIN)
                .setLoginMessage(loginMsg)
                .build();
        log.info("发送服务器的信息(登录):==========>>>[{}]", message);
        channel.writeAndFlush(message);
    }

}