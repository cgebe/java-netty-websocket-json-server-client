package server.handler;

import test.handler.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import com.google.gson.Gson;

public class TextFrameToMessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
		Gson gson = new Gson();
		Message msg = gson.fromJson(frame.text(), Message.class);
		ctx.fireChannelRead(msg);
	}

}
