package yaksa.publicChatCommon.control;

import yaksa.publicChatCommon.model.User;
import yaksa.publicChatCommon.observer.ChatObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by oshan on 18-Nov-17.
 */
public interface ChatController extends Remote{
    boolean notifyAllClients(String username, String message) throws RemoteException;
    boolean addChatObserver(ChatObserver chatObserver)throws RemoteException;
    boolean removeChatObserver(ChatObserver chatObserver)throws RemoteException;
    boolean updateClientList() throws RemoteException;
}
