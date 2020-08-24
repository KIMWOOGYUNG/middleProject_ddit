package yaksa.chemist.controller.main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import yaksa.server.rmiCommon.prescription.ObYakSaBoard;



public class Mainimpl extends UnicastRemoteObject implements ObYakSaBoard{

	
	private ObYakSaBoard observer;
	
	public Mainimpl(ObYakSaBoard observer) throws RemoteException {
		
		this.observer = observer;
				
	}
	
	
	@Override
	public boolean Popup(String ClientName) throws RemoteException {
		
		return observer.Popup(ClientName);
	}
	

}
