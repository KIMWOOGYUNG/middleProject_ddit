package yaksa.server.rmiCommon.prescription;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.server.dao.prescription.DaoImpl;
import yaksa.server.service.pay.PayServiceImpl;
import yaksa.server.service.prescription.ISerivce;
import yaksa.server.service.prescription.ServiceImpl;
import yaksa.server.util.prescription.BuildedSqlMapClient;
import yaksa.server.vo.pay.PayVO;
import yaksa.server.vo.prescription.InboxVO;

public class CommonImpl extends UnicastRemoteObject implements ICommon{
	
	
	private static CommonImpl common;
	
	public static CommonImpl getInstance() throws RemoteException {
		if(common == null) common = new CommonImpl();
		return common;
	}
		
	ISerivce service;

	
	public CommonImpl() throws RemoteException {
		super();
		service = ServiceImpl.getInstance();
		
	}

	@Override
	public void requestPres(String mem_id, String pharm_id, byte[] data) throws RemoteException {
		int fileName = 0;
		// SQL 파일명이 안겹칠때까지 while 돌려야지 고유번호를 얻음
		while(true) {
			
			fileName = (int)(Math.random() * 9999)+ 1;
			if(service.chkFileName(fileName) == 0) {
				break;
			}
		}
		PayVO payVo = new PayVO();
		
		//PayVO에 셋팅

		payVo.setApp_code(""+fileName);
		payVo.setApp_cost(1000);
		payVo.setApp_ph_star(0);
		
		PayServiceImpl.getInstance().insertPay(payVo);
		
		
		FileOutputStream fout = null;
		String dir = "C:\\Users\\PC-18\\Desktop\\처방전 서버 저장용 테스트";
		System.out.println("파일 저장 시작...");
		
		try {
			fout = new FileOutputStream(dir + "\\" + fileName + ".jpg");
			
			fout.write(data);	//파일 내용 저장
			fout.flush();
			fout.close();
			System.out.println("파일 저장 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		InboxVO inboxVo = new InboxVO();
		inboxVo.setMem_id("nar0328");
		inboxVo.setPharm_id("a001");
		inboxVo.setFileName(fileName);
		
		service.insertPhar_inbox(inboxVo);
		
	}

	@Override
	public byte[] receiveReceipt(String fileName) throws RemoteException {
		File file = new File("C:\\Users\\PC-18\\Desktop\\영수증 서버 저장용 테스트\\"+fileName+".jpg");
		byte[] data = null;
		if(file !=  null) {
			
			long fSize = file.length();
			data = new byte[(int)fSize];
			
			try {		
				FileInputStream fin = new FileInputStream(file);
				fin.read(data);
				
				fin.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return data;
	}

	@Override
	public byte[] receivePres(String fileName) throws RemoteException {
		File file = new File("C:\\Users\\PC-18\\Desktop\\처방전 서버 저장용 테스트\\"+fileName+".jpg");
		byte[] data = null;
		if(file !=  null) {
			
			long fSize = file.length();
			data = new byte[(int)fSize];
			
			try {		
				FileInputStream fin = new FileInputStream(file);
				fin.read(data);
				
				fin.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return data;
	}

}
