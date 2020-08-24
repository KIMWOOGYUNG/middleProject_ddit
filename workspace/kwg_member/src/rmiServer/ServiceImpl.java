package rmiServer;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements IService {

	private static ServiceImpl service;
	
	private IDao dao;
	
	private ServiceImpl() throws RemoteException{
		dao = DaoImpl.getInstance();
	}
	
	public static ServiceImpl getInstance() {
		try {
			if(service == null) service = new ServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;			
	}

	@Override
	public void requestPres(String mem_id, String pharm_id, byte[] data) throws RemoteException {
		dao.requestPres(mem_id, pharm_id, data);
	}
	

}
