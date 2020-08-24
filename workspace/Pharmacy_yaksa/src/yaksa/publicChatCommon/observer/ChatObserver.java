package yaksa.publicChatCommon.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import yaksa.publicChatCommon.model.User;

/**
 * Created by oshan on 18-Nov-17.
 */
public interface ChatObserver extends Remote{
    boolean update(String username,String message) throws RemoteException;
    ArrayList<User> getOnlineUsers() throws RemoteException;
    User getUsername() throws RemoteException;
    boolean updateUI(ArrayList<User> clientList) throws RemoteException;
}
