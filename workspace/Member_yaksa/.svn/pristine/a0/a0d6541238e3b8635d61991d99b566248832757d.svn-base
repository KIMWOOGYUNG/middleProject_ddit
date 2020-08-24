package yaksa.member.dao.pillSearch;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.util.prescription.BuildedSqlMapClient;
import yaksa.member.vo.pillSearch.PillVO;

public class PillDaoImpl implements IPillDao {
	
	private SqlMapClient smc;   //iBatis용 객체 변수 선언
	   
	   private static PillDaoImpl dao;
	   
	   //생성자
	   private PillDaoImpl(){
		   smc = BuildedSqlMapClient.getSqlMapClient();
		   
	   }
	   
	   public static PillDaoImpl getInstance(){
	      if(dao == null) dao = new PillDaoImpl();
	      
	      return dao;
	   }

	@Override
	public List<PillVO> getAllPill() {
		List<PillVO> pillList = null;
		try {
			pillList = smc.queryForList("pill.getAllPill");
		} catch (SQLException e) {
			pillList = null;
			e.printStackTrace();
		}
		return pillList;
	}

	@Override
	public List<PillVO> getSearchPill(String pill) {
		List<PillVO> pillList = null;
		try {
			pillList = smc.queryForList("pill.getSearchPill", pill);
		} catch (SQLException e) {
			pillList = null;
			e.printStackTrace();
		}
		return pillList;
	}
	
	   @Override
	   public List<PillVO> getSearchPillNum(String pill) {
	      List<PillVO> pillList = null;
	      try {
	         pillList = smc.queryForList("pill.getSearchPillNum", pill);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return pillList;
	   }

	   @Override
	   public List<PillVO> getSearchPillFrom(String pill) {
	      List<PillVO> pillList = null;
	      try {
	         pillList = smc.queryForList("pill.getSearchPillFrom", pill);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return pillList;
	   }
	

}
