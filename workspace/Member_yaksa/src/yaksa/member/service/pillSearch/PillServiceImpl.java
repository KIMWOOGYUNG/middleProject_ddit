package yaksa.member.service.pillSearch;

import java.util.List;

import yaksa.member.dao.pillSearch.IPillDao;
import yaksa.member.dao.pillSearch.PillDaoImpl;
import yaksa.member.vo.pillSearch.PillVO;


public class PillServiceImpl implements IPillService {
	
	private static PillServiceImpl service;
	public static PillServiceImpl getInstance(){
	     if(service == null) service = new PillServiceImpl();
	      
	     return service;
	}
	   
	public void displayTest(){
		System.out.println("이것은 싱글톤 객체의 메서드 입니다.");
	}
	
	private IPillDao dao;  // DAO객체가 저장될 변수 선언
	
	//생성자
//	public MemberServiceImpl() {
	private PillServiceImpl(){
//		dao = new MemberDaoImpl();	// DAO객체 생성
		dao = PillDaoImpl.getInstance();
	}

	@Override
	public List<PillVO> getAllPill() {
		return dao.getAllPill();
	}

	@Override
	public List<PillVO> getSearchPill(String pill) {
		return dao.getSearchPill(pill);
	}

	@Override
	public List<PillVO> getSearchPillNum(String pill) {
		return dao.getSearchPillNum(pill);
	}

	@Override
	public List<PillVO> getSearchPillFrom(String pill) {
		return dao.getSearchPillFrom(pill);
	}
	

}
