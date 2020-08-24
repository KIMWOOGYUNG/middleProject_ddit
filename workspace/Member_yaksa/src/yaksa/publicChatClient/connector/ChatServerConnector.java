package yaksa.publicChatClient.connector;

import java.io.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import yaksa.publicChatCommon.control.ChatController;

/**
 * Created by oshan on 19-Nov-17.
 */
public class ChatServerConnector {
    private static ChatServerConnector serverConnector; // 인스턴스로 묶여서 컨트롤의 지속적인 하나를 가질수 있다.
    private ChatController controller;

    private ChatServerConnector() throws IOException, NotBoundException {
//        Properties properties=new Properties();
//        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("settings.properties");
//        InputStream input = new FileInputStream(new File("dbSettings/settings.properties"));

//        properties.load(input);
//        System.setProperty("java.rmi.server.hostname",properties.getProperty("ip"));
//        System.out.println(properties.getProperty("server-ip"));
    	
    	Registry reg = LocateRegistry.getRegistry("localhost",8888);
		controller = (ChatController)reg.lookup("ChatServer");
		
		
		

    }

    public static ChatServerConnector getServerConnector() throws IOException, NotBoundException {
       if(serverConnector==null){
           serverConnector=new ChatServerConnector();
       }
       return serverConnector;
    }

    public ChatController getController(){
        return controller;
    }
}
