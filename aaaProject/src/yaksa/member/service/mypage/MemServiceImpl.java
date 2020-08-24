package yaksa.member.service.mypage;

import java.util.List;

import yaksa.member.dao.mypage.IMemDao;
import yaksa.member.dao.mypage.MemDaoImpl;
import yaksa.member.vo.mypage.MemVo;

public class MemServiceImpl implements IMemService {
	private IMemDao dao;  // DAO객체가 저장될 변수 선언
	
	private static MemServiceImpl service;
	
	//생성자
	//public MemberServiceImpl() {
	private MemServiceImpl() {
		//dao = new MemberDaoImpl();	// DAO객체 생성
		dao = MemDaoImpl.getInstance();
	}
	
	public static MemServiceImpl getInstance(){
		if(service==null) service = new MemServiceImpl();
		return service;
	}

	@Override
	public List<MemVo> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int updateMember(MemVo memVo) {
		// TODO Auto-generated method stub
		return dao.updateMember(memVo);
	}
	
}
