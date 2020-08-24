package Server.service;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Server.WaitScreen.WaitScreenable;
import Server.YaksaBoard.YaksaBoardable;
import yaksa.server.rmiCommon.prescription.ObWaitScreen;
import yaksa.server.rmiCommon.prescription.ObYakSaBoard;


public class serviceimpl extends UnicastRemoteObject implements service  { // remoteexception 해줘야함

	
	public serviceimpl() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	private static final YaksaBoardable yaksaboard = new YaksaBoardable();
	private static final WaitScreenable waitscreen = new WaitScreenable();

	@Override
	public boolean CheckYaksa(String name) throws RemoteException { // yaska
		return yaksaboard.CheckYaksa(name);
	}

	@Override
	public boolean addYaksa(String name, ObYakSaBoard obyaksaboard) throws RemoteException { // yaskafx
		
		return yaksaboard.addYaksa(name, obyaksaboard);
	}

	@Override
	public boolean popupYaksa(String ClientId, String YaksaId) throws RemoteException { // yaksafx
		
		System.out.println("service");
		return yaksaboard.popup(ClientId, YaksaId);
	}

	@Override
	public boolean rejectClient(String ClientId, String YaksaId) throws RemoteException { // client fx
		// TODO Auto-generated method stub
		return waitscreen.rejectClient(ClientId, YaksaId);
	}

	@Override
	public boolean ApproveClient(String ClientId, String YaksaId)throws RemoteException { // client fx
		// TODO Auto-generated method stub
		return waitscreen.ApproveClient(ClientId, YaksaId);
	}

	@Override
	public boolean addWaitFX(String ClientId,ObWaitScreen waitScreen)throws RemoteException { // client fx
		// TODO Auto-generated method stub
		return waitscreen.addWaitFX(ClientId, waitScreen);
	}

	
	
	
}
