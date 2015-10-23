package test.handler;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import com.google.gson.Gson;

public class MessageToTextFrameHandler extends MessageToMessageEncoder<Message> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
		Gson gson = new Gson();
		String json = gson.toJson(msg);
		System.out.println("sending json frame: " + json);
		out.add(new TextWebSocketFrame(json));
	}

}
