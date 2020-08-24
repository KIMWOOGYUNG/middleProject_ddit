package yaksa.server.service.prescription;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import yaksa.server.dao.prescription.DaoImpl;
import yaksa.server.dao.prescription.IDao;
import yaksa.server.vo.prescription.InboxVO;
import yaksa.server.vo.prescription.ReceiptVO;

public class ServiceImpl extends UnicastRemoteObject implements ISerivce {

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
	public int chkFileName(int fileName) {
		return dao.chkFileName(fileName);
	}

	@Override
	public int insertPhar_inbox(InboxVO inboxVo) {
		return dao.insertPhar_inbox(inboxVo);
	}

	@Override
	public int insertMem_inbox(ReceiptVO receiptVo) {
		return dao.insertMem_inbox(receiptVo);
	}


	
	
	
	
	

}
