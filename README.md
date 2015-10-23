# java-netty-websocket-json-server-client

A barebone websocket json server and client based on netty 4.0.32. Basically the example from the netty repo with slight changes to the handler structure.
Added handlers to transform TextWebSocketFrame seperately to a POJO.

HowTo:

1.	Start RunServer.java
2.	Start RunClient.java
3.	Input a command 

		ping - for simple pinging the server
		close - to close the connection
		everything else will send an example JSON message to the server
		
	via command line 
4.  Adjust Message and ProcessMessageHandler to your needs