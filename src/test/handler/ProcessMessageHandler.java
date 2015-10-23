package test.handler;

import com.google.gson.Gson;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProcessMessageHandler extends SimpleChannelInboundHandler<Message>{

	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		// do something with the Message object
		msg.setFoo("updated foo");
		Gson gson = new Gson();
		System.out.println("altered object in json: " + gson.toJson(msg));
		
		// when finished write out a new Message object (newMsg)
		Message msg2 = new Message();
		msg2.setFoo(msg.getFoo());
		msg2.setBar("back");
		ctx.writeAndFlush(msg2);
	}
}
