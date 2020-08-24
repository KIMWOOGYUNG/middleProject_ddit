package kr.or.ddit.rmi.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.rmi.inf.RemoteInterface;
import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

// RMI�슜 �겢�옒�뒪 留뚮뱾湲� ==> UnicastRemoteObject瑜� �긽�냽�븯怨� RMI�슜 �씤�꽣�럹�씠�뒪瑜� 援ы쁽�븯�룄濡� �옉�꽦�븳�떎.
public class RemoteServer extends UnicastRemoteObject implements RemoteInterface{
	
	//�깮�꽦�옄 ==> �깮�꽦�옄�룄 RemoteException�쓣 throws�빐�꽌 �옉�꽦�븳�떎.
	public RemoteServer() throws RemoteException {   }

	//RMI�슜 媛앹껜�쓽 硫붿꽌�뱶�뿉�꽌 
	//留ㅺ컻蹂��닔�뒗 �겢�씪�씠�뼵�듃�뿉�꽌 �꽌踰꾩そ�쑝濡� �쟾�떖�릺�뒗 �뜲�씠�꽣媛� ���옣�릺怨�,
	//硫붿꽌�뱶�쓽 諛섑솚媛믪� �꽌踰꾩뿉�꽌 泥섎━�븳 寃곌낵瑜� �겢�씪�씠�뼵�듃濡� 蹂대궡�뒗 �뜲�씠�꽣媛� �맂�떎.
	@Override
	public int doRemotePrint(String str) throws RemoteException {
		System.out.println("doRemotePrint() 硫붿꽌�뱶 �떆�옉");
		System.out.println("�겢�씪�씠�뼵�듃�뿉�꽌 蹂대궦 �궡�슜 : " + str);
		System.out.println("doRemotePrint() 硫붿꽌�뱶 �옉�뾽 �걹...");
		
		return 200; 	//諛섑솚媛�
	}

	@Override
	public void doPrintList(List<String> list) throws RemoteException {
		System.out.println("doPrintList() 硫붿꽌�뱶 �떆�옉");
		
		for(String str : list) {
			System.out.println(str);
		}
		System.out.println("doPrintList() 硫붿꽌�뱶 �걹...");
		System.out.println();
	}

	@Override
	public void doPrintVo(TestVO vo) throws RemoteException {
		System.out.println("doPrintVo() 硫붿꽌�뱶 �떆�옉");
		System.out.println("�씠由� : " + vo.getName());
		System.out.println("踰덊샇 : " + vo.getNum());
		System.out.println("doPrintVo() 硫붿꽌�뱶 �걹...");
		
	}

	public static void main(String[] args) {
		//RMI�슜 媛앹껜瑜� �겢�씪�씠�뼵�듃�뿉�꽌 �궗�슜�븷 �닔 �엳�룄濡� RMI�솚寃쎌쓣 �꽕�젙�븳�떎.
		try {
			//1. RMI�슜 �씤�꽣�럹�씠�뒪瑜� 援ы쁽�븳 RMI�슜 �겢�옒�뒪�쓽 �씤�뒪�꽩�뒪瑜� �깮�꽦�븳�떎.
			RemoteInterface inf = new RemoteServer();
			
			//2. 援ы쁽�븳 媛앹껜瑜� �겢�씪�씠�뼵�듃媛� 李얠쓣 �닔 �엳�룄濡� 愿�由ы븯�뒗 Registry 媛앹껜 �깮�꽦
			Registry reg = LocateRegistry.createRegistry(9998);	//湲곕낯 �룷�듃 (1099)
			
			//3. RMI�슜 媛앹껜瑜� �꽌踰꾩뿉 �벑濡앺븳�떎.
			// �삎�떇) Registry 媛앹껜 蹂��닔.rebind("媛앹껜�쓽 Alias", RMI媛앹껜�쓽 �씤�뒪�꽩�뒪);
			reg.rebind("server", inf);
			
			System.out.println("�꽌踰꾧� 以�鍮꾨릺�뿀�뒿�땲�떎.");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	//�겢�씪�씠�뼵�듃媛� 蹂대궡�삩 FileInfoVO媛앹껜瑜� �씠�슜�빐�꽌 �뙆�씪�쓣 ���옣�븳�떎.
	@Override
	public void setFile(FileInfoVO fileVo) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "d:/d_Other/rmiData/";
		System.out.println("�뙆�씪 ���옣 �떆�옉...");
		
		try {
			fout = new FileOutputStream(dir + fileVo.getFileName());
			
			fout.write(fileVo.getFileData());	//�뙆�씪 �궡�슜 ���옣
			fout.flush();
			fout.close();
			System.out.println("�뙆�씪 ���옣 �셿猷�...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
