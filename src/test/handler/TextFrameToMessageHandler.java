package test.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import com.google.gson.Gson;

public class TextFrameToMessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
		System.out.println("received a text frame: " + frame.text());
		Gson gson = new Gson();
		Message msg = gson.fromJson(frame.text(), Message.class);
		ctx.fireChannelRead(msg);
	}

}
