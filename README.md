# java-netty-websocket-json-server-client

A barebone websocket json server and client based on netty 4.0.32. Basically the example from the netty repo with slight changes to the handler structure.
Added a handler to process TextWebSocketFrame seperately. Gson JSON example commented out //

HowTo:

1.	Start RunServer.java
2.	Start RunClient.java
3.	Input a command 

		ping - for simple pinging the server
		close - to close the connection
		everything else is handled by the WebSocketTextFrameHandler -> e.g. JSON messages 
		
	via command line 
4. Now create appropriate POJO to your JSON messages in order process them efficiently as java objects.
5. Adjust WebSocketTextFrameHandler gson.fromJson(frame.text(), Message.class) for your POJO and comment out //ctx.fireChannelRead(msg); or add your own WebSocketTextFrameHandler in order to send your POJO upstream
6. Create appropriate upstream handler(s) for your POJO.
7. Pass your handlers in a list as parameter for the server, which automatically adds them after the WebSocketTextFrameHandler in the channel pipeline. 