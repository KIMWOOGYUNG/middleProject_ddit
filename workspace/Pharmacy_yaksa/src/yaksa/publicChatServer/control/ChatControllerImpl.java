package yaksa.publicChatServer.control;

import yaksa.publicChatCommon.control.ChatController;
import yaksa.publicChatCommon.model.User;
import yaksa.publicChatCommon.observer.ChatObserver;
import yaksa.publicChatServer.service.ChatService;
import yaksa.publicChatServer.service.impl.ChatServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by oshan on 19-Nov-17.
 */
public class ChatControllerImpl extends UnicastRemoteObject implements ChatController {

    private ChatService service=new ChatServiceImpl();

    public ChatControllerImpl() throws RemoteException {
    }

    @Override
    public boolean notifyAllClients(String username, String message) throws RemoteException {
        return service.notifyAllClients(username,message);
    }

    @Override
    public boolean addChatObserver(ChatObserver chatObserver) throws RemoteException {
        return service.addChatObserver(chatObserver);
    }

    @Override
    public boolean removeChatObserver(ChatObserver chatObserver) throws RemoteException {
        return service.removeChatObserver(chatObserver);
    }

  
  

    @Override
    public boolean updateClientList() throws RemoteException {
        return service.updateClientList();
    }

   
}
