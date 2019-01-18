package com.pm.mc.chat.netty.listener;

import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * 配置chat监听器
 * @author Administrator
 *
 */
public class ChatListener implements GenericFutureListener<ChannelFuture> {

	@Override
	public void operationComplete(ChannelFuture channelFuture) throws Exception {
		channelFuture.sync();
	}
}