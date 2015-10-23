package test;

import io.netty.channel.ChannelHandler;

import java.util.ArrayList;
import java.util.List;

import server.WebSocketServer;
import server.handler.MessageToTextFrameHandler;
import server.handler.TextFrameToMessageHandler;
import test.handler.ProcessMessageHandler;


public class RunServer {
	
    public static void main(String[] args) throws Exception {
    	List<ChannelHandler> handlers = new ArrayList<ChannelHandler>();
    	// textframe to pojo handler
    	handlers.add(new MessageToTextFrameHandler());
    	handlers.add(new TextFrameToMessageHandler());
    	handlers.add(new ProcessMessageHandler());
    	new WebSocketServer(8080, "/websocket", handlers).run();
    }

}
