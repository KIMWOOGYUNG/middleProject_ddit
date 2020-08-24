package yaksa.server.rmiCommon.prescription;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class ServerConnect {

	
	private static ServerConnect serverConnect;
	
	private Controller controller;
	
	private ServerConnect() throws IOException, NotBoundException{
	
		
		Registry reg = LocateRegistry.getRegistry("localhost",8888);
		controller = (Controller)reg.lookup("Chat");
		
	}
	
	public static ServerConnect getServerConnector() throws IOException, NotBoundException{
		
		if(serverConnect == null) {
			serverConnect = new ServerConnect();
			
		}
		return serverConnect;
		
	}
	
	public Controller getController() {
		return controller;
	}
}
