package yaksa.chemist.dao.join;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.chemist.util.BuildedSqlMapClient;
import yaksa.chemist.vo.join.ChemistVO;


public class ChemistDaoImpl implements IChemistDao {
	
	// 싱글톤 패턴
	private SqlMapClient smc;
		
	private static ChemistDaoImpl dao;
		   
	private ChemistDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static ChemistDaoImpl getInstance(){
		if(dao == null) dao = new ChemistDaoImpl();
	      
	    return dao;
	}

	@Override
	public int addPharm(ChemistVO ChemistVO) {	// 가입
		int cnt = 0;
		
		System.out.println(ChemistVO.toString());
		
		try {
			
			Object obj = smc.insert("chemist.addPharm",ChemistVO);
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
	public int SelectChemist(String pharm_id) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("chemist.SelectChemist",pharm_id);
		
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;	// 반환값
	}

	@Override
	public int LoginChemist(String pharm_pw) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("chemist.LoginChemist",pharm_pw);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateZipNum(ChemistVO ChemistVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("chemist.updateZipNum",ChemistVO);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public ChemistVO getChemist(Map<String, String> searchMap) {
		ChemistVO chemistList = null;
		
		try {
			chemistList = (ChemistVO) smc.queryForObject("chemist.getChemist", searchMap);
		} catch (SQLException e) {
			chemistList = null;
			e.printStackTrace();
		}
		
		return chemistList;
	}

	@Override
	public int SearchPharmName(String pharm_name) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("chemist.SearchPharmName",pharm_name);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int SearchChemistName(String pharm_chname) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("chemist.SearchChemistName",pharm_chname);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int SerchRegChemist(String pharm_regno1) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("chemist.SerchRegChemist",pharm_regno1);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public ChemistVO SearchChemistId(Map<String, String> searchMap) {
		ChemistVO chemistList = null;
		
		try {
			chemistList = (ChemistVO) smc.queryForObject("chemist.SearchChemistId", searchMap);
		} catch (SQLException e) {
			chemistList = null;
			e.printStackTrace();
		}
		
		return chemistList;
	}

	@Override
	public int ModifyPw(ChemistVO ChemistVO) {
		 int cnt = 0;
	      
	      try {
	         cnt = smc.update("chemist.ModifyPw",ChemistVO);         
	      } catch (SQLException e) {
	         cnt = 0;
	         e.printStackTrace();
	      }
	      
	      return cnt;
	}

	
	

}
