package server;

import server.handler.WebSocketHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class WebSocketServerChannelInitializer extends ChannelInitializer<SocketChannel> {
	
	private WebSocketServer server;
	
	public WebSocketServerChannelInitializer(WebSocketServer server) {
		this.server = server;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		if (server.getSslContext() != null) {
            pipeline.addLast(server.getSslContext().newHandler(ch.alloc()));
        }
		pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast("websocket", new WebSocketHandler(server));
        
        // add additional handlers
        for (int i = 0; i < server.getHandlers().size(); i++) {
        	pipeline.addLast("handler_" + i, server.getHandlers().get(i));
        }
	}

}
