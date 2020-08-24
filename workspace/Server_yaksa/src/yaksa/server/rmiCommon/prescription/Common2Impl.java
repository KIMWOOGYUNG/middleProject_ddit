package yaksa.server.rmiCommon.prescription;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import yaksa.server.service.prescription.ISerivce;
import yaksa.server.service.prescription.ServiceImpl;
import yaksa.server.vo.prescription.ReceiptVO;

public class Common2Impl extends UnicastRemoteObject implements ICommon2{
	private static Common2Impl common2;
	
	public static Common2Impl getInstance() throws RemoteException {
		if(common2 == null) common2 = new Common2Impl();
		return common2;
	}
	
	ISerivce service;

	protected Common2Impl() throws RemoteException {
		super();
		service = ServiceImpl.getInstance();
	}

	@Override
	public byte[] requestFile(String fileName) throws RemoteException {

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

	@Override
	public void sendReceipt(String mem_id, String pharm_id, String pres_code, byte[] data) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "C:\\Users\\PC-18\\Desktop\\영수증 서버 저장용 테스트";
		System.out.println("파일 저장 시작...");
		
		try {
			fout = new FileOutputStream(dir + "\\" + pres_code + ".jpg");
			
			fout.write(data);	//파일 내용 저장
			fout.flush();
			fout.close();
			System.out.println("파일 저장 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ReceiptVO rcVo = new ReceiptVO();
		rcVo.setInbox_memid(mem_id);
		rcVo.setInbox_phid(pharm_id);
		rcVo.setInbox_file(pres_code);
		
		service.insertMem_inbox(rcVo);
		
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
}
