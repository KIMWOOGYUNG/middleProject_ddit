package kr.or.ddit.rmi.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.rmi.inf.RemoteInterface;
import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

//�겢�씪�씠�뼵�듃履쎌쓽 VO�굹 �씤�꽣�럹�씠�뒪�뒗  �꽌踰꾩쓽 VO�굹 �씤�꽣�럹�씠�뒪媛� �엳�뒗 �뙣�궎吏��쓽 援ъ“�� �뙆�씪紐�, 洹몃━怨� �궡�슜源뚯� �룞�씪�븯寃� 援ъ꽦�릺�뼱 �엳�뼱�빞 �븳�떎.

public class RemoteClient {

	public static void main(String[] args) {
		try {
			//�벑濡앸맂 �꽌踰꾨�� 李얘린 �쐞�빐 Registry 媛앹껜瑜� �깮�꽦�븳�떎. (�꽌踰� �젒�냽)
			Registry reg = LocateRegistry.getRegistry("localhost", 9998);
			
			//�궗�슜�븷 媛앹껜�뒗 �꽌踰꾩뿉 �벑濡앸맂  Alias濡� 李얠븘�꽌 媛앹껜瑜� 遺덈윭�삩�떎.
			//�삎�떇) Registry 媛앹껜蹂��닔, lookup("媛앹껜�쓽 Alias");
			RemoteInterface inf = (RemoteInterface) reg.lookup("server");
			
			//�씠 �씠�썑遺��꽣�뒗 遺덈윭�삩 媛앹껜�쓽 硫붿꽌�뱶瑜� �샇異쒗빐�꽌 �븘�슜�븷 �닔 �엳�떎.
			int a = inf.doRemotePrint("�븞�뀞�븯�꽭�슂 �겢�씪�씠�뼵�듃�엯�땲�떎.");
			System.out.println("諛섑솚媛�" + a);
			System.out.println("------------------------------------------------");
			
			System.out.println("doPrintList()硫붿꽌�뱶 �샇異�");
			List<String> nameList = new ArrayList<String>();
			nameList.add("源��슦寃�");
			nameList.add("�궓�븘由�");
			nameList.add("�엫�닔吏�");
			nameList.add("諛뺤젙誘�");
			nameList.add("源�以��슦");
			inf.doPrintList(nameList);
			System.out.println("------------------------------------------------");
			
			System.out.println("doPrintVo()硫붿꽌�뱶 �샇異�");
			TestVO test = new TestVO();
			test.setName("源��슦寃�");
			test.setNum(2020);
			inf.doPrintVo(test);
			System.out.println("------------------------------------------------");
			
			//�뙆�씪 �쟾�넚�븯湲�
			System.out.println("�뙆�씪 �쟾�넚 �떆�옉...");
			
			//�쟾�넚�븷 �뙆�씪�쓽 File媛앹껜 �깮�꽦
			File file = new File("D:/d_Other/koala.jpg");
			if(!file.exists()) {
				System.out.println("�쟾�넚�븷 �뙆�씪�씠 �뾾�뒿�땲�떎. �떎�떆 �솗�씤�빐二쇱꽭�슂.");
				return;
			}
			
			FileInfoVO fVo = new FileInfoVO();
			fVo.setFileName(file.getName());	//�뙆�씪 �씠由� �꽕�젙
			
			//�뙆�씪�쓽 �겕湲� 援ы븯湲�
			long fSize = file.length(); 
			//�뙆�씪 �궡�슜�쓣 �씫�뼱�� ���옣�븷 byte�삎 諛곗뿴 �꽑�뼵 ==> 諛곗뿴 �겕湲곕뒗 �뙆�씪�겕湲곗� 媛숆쾶�븳�떎.
			byte[] data = new byte[(int)fSize]; 
			try {
				FileInputStream fin = new FileInputStream(file);
				fin.read(data);		//�뙆�씪 �궡�슜�쓣 �씫�뼱�� byte�삎 諛곗뿴�뿉 ���옣�븳�떎.
				
				//�씫�뼱�삩 �뜲�씠�꽣瑜� FileInfoVO 媛앹껜�뿉 �뀑�똿�븳�떎.
				fVo.setFileData(data);
				
				//RMI�슜 �뙆�씪 �쟾�넚�슜 硫붿꽌�뱶 �샇異�
				inf.setFile(fVo);
				System.out.println("�뙆�씪 �쟾�넚 �걹...");
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			
		} catch (RemoteException e) {
			// TODO: handle exception
		} catch(NotBoundException e) {
			
		}

	}

}
