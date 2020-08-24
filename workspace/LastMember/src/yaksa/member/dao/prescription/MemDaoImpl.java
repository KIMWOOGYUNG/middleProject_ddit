package yaksa.member.dao.prescription;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.util.prescription.BuildedSqlMapClient;
import yaksa.member.vo.prescription.Mem_InboxVO;
import yaksa.member.vo.prescription.Phar_InboxVO;

public class MemDaoImpl implements IMemDao{

	private static MemDaoImpl dao;
	private SqlMapClient smc;
	
	private MemDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static MemDaoImpl getInstance() {
		if(dao == null) dao = new MemDaoImpl();
		return dao;
	}
	
	@Override
	public List<Mem_InboxVO> getAllReceipt() {
		List<Mem_InboxVO> rcList = null;
		try {
			rcList = smc.queryForList("member.getAllReceipt");

		} catch (SQLException e) {
			rcList = null;
			e.printStackTrace();
		}
		return rcList;
	}
	
	@Override
	public List<Phar_InboxVO> getAllPres() {
		List<Phar_InboxVO> presList = null;
		try {
			presList = smc.queryForList("member.getAllPres");
		} catch (SQLException e) {
			presList = null;
			e.printStackTrace();
		}
		return presList;
	}

	@Override
	public int updateRate(Map<String, String> amap) {
		int cnt = 0;
		try {
			cnt = smc.update("member.updateRating",amap);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updatePersue(String code) {
		int cnt = 0;
		try {
			cnt = smc.update("member.updatePersue",code);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	

}
