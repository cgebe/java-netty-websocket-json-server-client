package test;

import io.netty.channel.ChannelHandler;

import java.util.ArrayList;
import java.util.List;

import server.WebSocketServer;
import server.handler.WebSocketTextFrameHandler;


public class RunServer {
	
    public static void main(String[] args) throws Exception {
    	List<ChannelHandler> handlers = new ArrayList<ChannelHandler>();
    	// textframe to pojo handler
    	handlers.add(new WebSocketTextFrameHandler());
    	new WebSocketServer(8080, "/websocket", handlers).run();
    }

}
