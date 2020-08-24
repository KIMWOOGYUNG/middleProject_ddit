package yaksa.member.dao.join;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.util.prescription.BuildedSqlMapClient;
import yaksa.member.vo.join.MemberVO;

public class MemDaoImpl implements IMemberDao {

	// 싱글톤 패턴
	private SqlMapClient smc;
		
	private static MemDaoImpl dao;
		   
	private MemDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static MemDaoImpl getInstance(){
		if(dao == null) dao = new MemDaoImpl();
	      
	    return dao;
	}
	
	@Override
	public int addMember(MemberVO memberVO) {	// 가입
		int cnt = 0;
		
		try {
			Object obj = smc.insert("member.addMember",memberVO);
			if(obj == null) {
				cnt = 1;	// 성공하면 1을 반환
			}else {
				cnt = 0;	// 실패하면 0을 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;	// 반환값
	}

	@Override
	public int SelectMember(String mem_id) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("member.SelectMember",mem_id);
		
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;	// 반환값
	}

	@Override
	public int LoginMember(String mem_pw) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("member.LoginMember", mem_pw);
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateZipNum(MemberVO memberVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("member.updateZipNum", memberVO);
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int SearchNameMember(String mem_name) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("member.SearchNameMember",mem_name);
		
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;	// 반환값
	}

	@Override
	public int SearchRegMember(String mem_regno1) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("member.SearchRegMember",mem_regno1);
		
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;	// 반환값
	}

	@Override
	public MemberVO getMember(Map<String, String> searchMap) {
		MemberVO memList = null;
		
		try {
			memList = (MemberVO) smc.queryForObject("member.getMember", searchMap);
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public MemberVO getMemberId(Map<String, String> searchMap) {
		MemberVO memList = null;
		
		try {
			memList = (MemberVO) smc.queryForObject("member.getMemberId", searchMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public int ModifyPw(MemberVO memberVO) {
		 int cnt = 0;
	      
	      try {
	         cnt = smc.update("member.ModifyPw",memberVO);         
	      } catch (SQLException e) {
	         cnt = 0;
	         e.printStackTrace();
	      }
	      
	      return cnt;
	}

	

	

	
	
//	@Override
//	public List<MemberVO> SearchId(Map<String, String> searchMap) {
//		List<MemberVO> memList = null;
//	      
//	      try {
//	         
//	         memList = smc.queryForList("mymember.SearchId",searchMap);
//	         
//	      } catch (SQLException e) {
//	         memList = null;
//	         e.printStackTrace();
//	      } 
//	      return memList;
//	}
	
}
