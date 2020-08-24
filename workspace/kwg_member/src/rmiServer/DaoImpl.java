package rmiServer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.BuildedSqlMapClient;


public class DaoImpl implements IDao{
	
	private static DaoImpl dao;
	private SqlMapClient smc;

	private DaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static DaoImpl getInstance() {
		if(dao == null) dao = new DaoImpl();
		return dao;
	}

	@Override
	public void requestPres(String mem_id, String pharm_id, byte[] data) throws RemoteException {
		
		FileOutputStream fout = null;
		String dir = "C:\\Users\\PC-18\\Desktop\\ó���� ���� ����� �׽�Ʈ";
		System.out.println("���� ���� ����...");
		
		try {
			fout = new FileOutputStream(dir + "0000.jpg");
			
			fout.write(data);	//���� ���� ����
			fout.flush();
			fout.close();
			System.out.println("���� ���� �Ϸ�...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//bis.read()
		
		
		/*
		 * Map<String, String> map = new HashMap<>(); map.put("mem_id", mem_id);
		 * map.put("pharm_id", pharm_id); map.put("file", file);
		 */
		/*
		 * try { Object obj = smc.insert("prescription.insertPres",vo); } catch
		 * (Exception e) { // TODO: handle exception }
		 */
	}
	
	

}
