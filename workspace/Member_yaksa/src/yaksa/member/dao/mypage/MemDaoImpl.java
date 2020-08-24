package yaksa.member.dao.mypage;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.util.prescription.BuildedSqlMapClient;
import yaksa.member.vo.mypage.MemVo;
import yaksa.member.vo.mypage.PharmPresVO;

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
	public List<MemVo> getAllMember(String mem_id) {
		List<MemVo> memList = null;
		try {
			memList = smc.queryForList("mem.getAllMember", mem_id);
			
			
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
	
	@Override
	   public List<PharmPresVO> ykvisit(String a) {
	      List<PharmPresVO> plist = null;
	      try {
	         plist = smc.queryForList("mem.ykvisit",a);
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return plist;
	   }


}
