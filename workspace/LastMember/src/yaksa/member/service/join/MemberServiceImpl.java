package yaksa.member.service.join;

import java.util.Map;

import yaksa.member.dao.join.IMemberDao;
import yaksa.member.dao.join.MemDaoImpl;
import yaksa.member.vo.join.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private static MemberServiceImpl service;
	private MemberServiceImpl() {
		dao = MemDaoImpl.getInstance();
		
	}
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	private IMemberDao dao;	// DAO객체가 저장될 변수 선언
	
	public void displayTest() {
		System.out.println("이것은 싱글톤 객체의 메스드 입니다.");
	}

	@Override
	public int addMember(MemberVO memberVO) {
		return dao.addMember(memberVO);
	}
	
	@Override
	public int SelectMember(String mem_id) {
		return dao.SelectMember(mem_id);
	}
	
	@Override
	public int LoginMember(String mem_pw) {
		return dao.LoginMember(mem_pw);
	}
	
	@Override
	public int updateZipNum(MemberVO memberVO) {
		return dao.updateZipNum(memberVO);
	}
	
	@Override
	public int SearchNameMember(String mem_name) {
		return dao.SearchNameMember(mem_name);
	}
	
	@Override
	public int SearchRegMember(String mem_regno1) {
		return dao.SearchRegMember(mem_regno1);
	}
	
	@Override
	public MemberVO getMember(Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return dao.getMember(searchMap);
	}
	
	@Override
	public MemberVO getMemberId(Map<String, String> searchMap) {
		return dao.getMemberId(searchMap);
	}
	
	@Override
	public int ModifyPw(MemberVO memberVO) {
		return dao.ModifyPw(memberVO);
	}
	
	
	
	
	
	
	
//	@Override
//	public List<MemberVO> SearchId(Map<String, String> searchMap) {
//		return dao.SearchId(searchMap);
//	}

}
