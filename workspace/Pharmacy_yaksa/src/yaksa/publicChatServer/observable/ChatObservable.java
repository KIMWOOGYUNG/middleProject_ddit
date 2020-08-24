package yaksa.publicChatServer.observable;

import java.rmi.RemoteException;
import java.util.ArrayList;

import yaksa.publicChatCommon.model.User;
import yaksa.publicChatCommon.observer.ChatObserver;

/**
 * Created by oshan on 19-Nov-17.
 */
public class ChatObservable {
    private final ArrayList<ChatObserver> chatObserverList=new ArrayList<>();

    public boolean addChatObserver(ChatObserver chatObserver) throws RemoteException{
        return chatObserverList.add(chatObserver);
    }

    public boolean removeChatObserver(ChatObserver chatObserver)throws RemoteException{
        return chatObserverList.remove(chatObserver);
    }

    public boolean notifyAllClients(String username, String message) throws RemoteException {
        for(ChatObserver observer : chatObserverList){
            observer.update(username,message);
        }
        return true;
    }

    public boolean isReserved(String username) throws RemoteException {
        for(ChatObserver observer : chatObserverList){
            if(observer.getUsername().equals(username)) return true;
        }
        return false;
    }

    public boolean updateView() throws RemoteException {
        ArrayList<User> usersList=new ArrayList<>();
        for(ChatObserver observer : chatObserverList){
            usersList.add( observer.getUsername()) ; // observer에 서버에 접속한 사용자들의 정보들을 가지고있음.
        }
        for(ChatObserver observer : chatObserverList){
            observer.updateUI(usersList);
        }
        return true;
    }
}
