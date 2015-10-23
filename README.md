# java-netty-websocket-json-server-client

A barebone websocket json server and client based on netty 4.0.32. Basically the example from the netty repo with slight changes to the handler structure.
Added a handler to process TextWebSocketFrame seperately. Gson Json example commented out //

HowTo:

1.	Start RunServer.java
2.	Start RunClient.java
3.	Input a command 

		"ping" for simple pinging the server
		"close" to close the connection
		everything else is handled by the WebSocketTextFrameHandler -> e.g. json messages 
		
	via command line 
4. Now create appropriate POJOs to your JSON messages in order process them efficiently as java objects.
