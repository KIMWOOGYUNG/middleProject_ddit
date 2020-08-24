package yaksa.publicChatClient.observerImpl;

import yaksa.publicChatCommon.model.User;
import yaksa.publicChatCommon.observer.ChatObserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by oshan on 19-Nov-17.
 */
public class ChatObserverImpl extends UnicastRemoteObject implements ChatObserver {

    private ChatObserver observer;

    public ChatObserverImpl(ChatObserver observer) throws RemoteException{
        this.observer = observer;
    }

    @Override
    public boolean update(String username,String message) throws RemoteException {
        return observer.update(username,message);
    }

    @Override
    public ArrayList<User> getOnlineUsers() throws RemoteException {
        return observer.getOnlineUsers();
    }

    @Override
    public User getUsername() throws RemoteException {
        return observer.getUsername();
    }

    @Override
    public boolean updateUI(ArrayList<User> clientList) throws RemoteException {
        return observer.updateUI(clientList);
    }

}
