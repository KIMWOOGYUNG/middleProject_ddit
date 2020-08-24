package yaksa.chemist.service.inventory;

import java.util.List;

import yaksa.chemist.dao.inventory.IPharmDao;
import yaksa.chemist.dao.inventory.PharmDaoImpl;
import yaksa.chemist.vo.inventory.insertVO;
import yaksa.chemist.vo.inventory.invVO;
import yaksa.chemist.vo.inventory.medVO;
import yaksa.chemist.vo.inventory.saleVO;
import yaksa.member.dao.mypage.IMemDao;
import yaksa.member.dao.mypage.MemDaoImpl;
import yaksa.member.vo.mypage.MemVo;

public class PharmServiceImpl implements IPharmService {
	private IPharmDao dao;  // DAO객체가 저장될 변수 선언
	
	private static PharmServiceImpl service;
	
	//생성자
	//public MemberServiceImpl() {
	private PharmServiceImpl() {
		//dao = new MemberDaoImpl();	// DAO객체 생성
		dao = PharmDaoImpl.getInstance();
	}
	
	public static PharmServiceImpl getInstance(){
		if(service==null) service = new PharmServiceImpl();
		return service;
	}

	@Override
	public List<medVO> getMedicine() {
		return dao.getMedicine();
	}



	@Override
	public List<invVO> getMedical_inventory() {
		return dao.getMedical_inventory();
	}

	@Override
	public int insertMedicine_inventory(List<invVO> list) {
		return dao.insertMedicine_inventory(list);
	}

	@Override
	public int insertMedicine(insertVO vo) {
		
		return dao.insertMedicine(vo);
		
	}
 
	@Override
	public List<insertVO> getMedicine_insert(String phid_name) {
		return dao.getMedicine_insert(phid_name);
		
	}

	@Override
	public List<saleVO> getMedicine_sale(String phid_name) {
		return dao.getMedicine_sale(phid_name);
	}


}
