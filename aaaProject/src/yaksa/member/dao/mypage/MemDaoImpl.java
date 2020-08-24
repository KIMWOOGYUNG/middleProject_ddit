package yaksa.member.dao.mypage;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.util.mypage.BuildedSqlMapClient;
import yaksa.member.vo.mypage.MemVo;

public class MemDaoImpl implements IMemDao {

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
	public List<MemVo> getAllMember() {
		List<MemVo> memList = null;
		try {
			memList = smc.queryForList("mem.getAllMember");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			memList=null;
		}
		
		return memList;
	}

	@Override
	public int updateMember(MemVo memVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mem.updateMember", memVo);
		} catch (SQLException e) {
			cnt =0;
			e.printStackTrace();
		}
		return cnt;
	}


}
