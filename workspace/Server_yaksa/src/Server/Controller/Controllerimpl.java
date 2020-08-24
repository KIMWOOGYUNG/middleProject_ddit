package Server.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Server.service.service;
import Server.service.serviceimpl;
import yaksa.server.rmiCommon.prescription.Controller;
import yaksa.server.rmiCommon.prescription.ObWaitScreen;
import yaksa.server.rmiCommon.prescription.ObYakSaBoard;


public class Controllerimpl extends UnicastRemoteObject implements Controller { // unicastRemote 해야함

	
	
	
	service service = new serviceimpl();
	
	public Controllerimpl() throws RemoteException{
	}

	@Override
	public boolean CheckYaksa(String name)throws RemoteException {
		return service.CheckYaksa(name);
	}

	@Override
	public boolean addYaksa(String name, ObYakSaBoard yaksaboard) throws RemoteException{
		
		return service.addYaksa(name, yaksaboard);
	}

	@Override
	public boolean popupYaksa(String ClientId, String YaksaId)throws RemoteException {
		return service.popupYaksa(ClientId, YaksaId);
	}

	@Override
	public boolean rejectClient(String ClientId, String YaksaId)throws RemoteException {
		return service.rejectClient(ClientId, YaksaId);
	}

	@Override
	public boolean ApproveClient(String ClientId, String YaksaId)throws RemoteException {
		return service.ApproveClient(ClientId, YaksaId);
	}

	@Override
	public boolean addWaitFX(String ClientId, ObWaitScreen waitScreen)throws RemoteException {
		return service.addWaitFX(ClientId, waitScreen);
	}

	
	
}
