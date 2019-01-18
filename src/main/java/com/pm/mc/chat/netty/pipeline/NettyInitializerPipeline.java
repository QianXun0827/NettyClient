package com.pm.mc.chat.netty.pipeline;

import com.pm.mc.chat.netty.handler.client.AdsMessagePublishHandler;
import com.pm.mc.chat.netty.handler.core.HeartBeatHandler;
import com.pm.mc.chat.netty.handler.core.MsgChatHandler;
import com.pm.mc.chat.netty.pojo.Msg;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 管道处理链配置类
 *
 * @Author: LIU XILIN
 * @Date: Created in 2018/07/30 20:14
 */
@Service("initializerPipeline")
public class NettyInitializerPipeline extends ChannelInitializer<SocketChannel> {

    public NettyInitializerPipeline() {
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //心跳的定时触发器
        pipeline.addLast(new IdleStateHandler(0, 40, 0, TimeUnit.SECONDS));
        //防止TCP丢包编解码
        pipeline.addLast(new LengthFieldBasedFrameDecoder(65535, 0, 2, 0, 2));
        //ProtoBuf解码器
        pipeline.addLast(new ProtobufDecoder(Msg.Message.getDefaultInstance()));
        //TCP丢包解码器
        pipeline.addLast(new LengthFieldPrepender(2));
        //ProtoBuf编码器
        pipeline.addLast(new ProtobufEncoder());


        //除心跳登陆外，所有消息先到MsgHandler中进行分发
        pipeline.addLast(new MsgChatHandler());
        //cmsAds发布
        pipeline.addLast(new AdsMessagePublishHandler());


        //心跳包发送
        pipeline.addLast(new HeartBeatHandler());

    }
}
