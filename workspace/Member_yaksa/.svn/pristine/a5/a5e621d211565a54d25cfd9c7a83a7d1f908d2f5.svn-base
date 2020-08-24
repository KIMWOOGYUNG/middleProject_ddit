package yaksa.member.controller.map.wait;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import yaksa.server.rmiCommon.prescription.ObWaitScreen;



public class WaitScreenimpl  extends UnicastRemoteObject implements ObWaitScreen{

	
	private ObWaitScreen obsever;
	
	public WaitScreenimpl(ObWaitScreen obsever) throws RemoteException{
		this.obsever = obsever;
		
	}
	
	@Override
	public boolean Accept(String ClientId) throws RemoteException {
		return obsever.Accept(ClientId);
	}

	@Override
	public boolean Reject(String ClientId) throws RemoteException {
		return obsever.Reject(ClientId);
	}
	

}
