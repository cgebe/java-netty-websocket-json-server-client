package test;

import server.WebSocketServer;


public class RunServer {
	
    public static void main(String[] args) throws Exception {
    	new WebSocketServer(8080, "/websocket").run();
    }

}
