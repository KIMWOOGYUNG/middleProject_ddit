package yaksa.publicChatServer.service.impl;

import yaksa.publicChatCommon.model.User;
import yaksa.publicChatCommon.observer.ChatObserver;
import yaksa.publicChatServer.observable.ChatObservable;
import yaksa.publicChatServer.service.ChatService;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by oshan on 19-Nov-17.
 */
public class ChatServiceImpl implements ChatService {
    private static final ChatObservable CHAT_OBSERVABLE=new ChatObservable(); // ChatObserval를 static으로 걸어버림


    @Override
    public boolean notifyAllClients(String username, String message) throws RemoteException { // 모든 FXML에게 메세지 보냄
        return CHAT_OBSERVABLE.notifyAllClients(username, message);
    }


    @Override
    public boolean addChatObserver(ChatObserver chatObserver) throws RemoteException { // 해당 FXML추가
        return CHAT_OBSERVABLE.addChatObserver(chatObserver);
    }

    @Override
    public boolean removeChatObserver(ChatObserver chatObserver) throws RemoteException { // 해당 FXML제거
        return CHAT_OBSERVABLE.removeChatObserver(chatObserver);
    }

 

    @Override
    public boolean updateClientList() throws RemoteException { // 모든 FXML에 업그레이드 시킴
        return CHAT_OBSERVABLE.updateView();
    }

 
}
