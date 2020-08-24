package yaksa.publicChatServer.service;

import yaksa.publicChatCommon.model.User;
import yaksa.publicChatCommon.observer.ChatObserver;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by oshan on 19-Nov-17.
 */
public interface ChatService {
    boolean notifyAllClients(String username, String message) throws RemoteException;
    boolean addChatObserver(ChatObserver chatObserver)throws RemoteException;
    boolean removeChatObserver(ChatObserver chatObserver)throws RemoteException;
    boolean updateClientList() throws RemoteException;
 
}
