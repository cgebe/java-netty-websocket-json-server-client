package server.handler;

import com.google.gson.Gson;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketTextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{

	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
		Gson gson = new Gson();
		//Message msg = gson.fromJson(frame.text(), Message.class);
		System.out.println("received a text frame: " + frame.text());
		//ctx.fireChannelRead(msg);
	}

}
