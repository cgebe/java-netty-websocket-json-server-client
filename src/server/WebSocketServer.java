package server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;


public class WebSocketServer {
	
	private int port;
	private String webSocketPath;
	
	private boolean ssl = System.getProperty("ssl") != null;
	private SslContext sslCtx;
	
    public WebSocketServer(int port, String webSocketPath) {
    	this.setPort(port);
    	this.setWebSocketPath(webSocketPath);
    }
    
    public void run() throws Exception {
    	// Configure SSL.
        if (ssl) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new WebSocketServerChannelInitializer(this));

            Channel ch = b.bind(port).sync().channel();

            // test via browser also possible
            // System.out.println("Open your web browser and navigate to " + (ssl? "https" : "http") + "://127.0.0.1:" + port + '/');

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    
    public int getPort() {
    	return port;
    }
    
    public void setPort(int port) {
    	this.port = port;
    }
    
    public boolean isSsl() {
    	return ssl;
    }
    
    public SslContext getSslContext() {
    	return this.sslCtx;
    }
    
    public void setSslContext(SslContext sslCtx) {
    	this.sslCtx = sslCtx;
    }
  
	public String getWebSocketPath() {
		return webSocketPath;
	}

	public void setWebSocketPath(String webSocketPath) {
		this.webSocketPath = webSocketPath;
	}

    
}
