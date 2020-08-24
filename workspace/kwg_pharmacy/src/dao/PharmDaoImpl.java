package dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.BuildedSqlMapClient;
import vo.PrescriptionVO;

public class PharmDaoImpl implements IpharmDao{
	
	private static PharmDaoImpl dao;
	private SqlMapClient smc;
	
	private PharmDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static PharmDaoImpl getInstance() {
		if(dao == null) dao = new PharmDaoImpl();
		return dao;
	}
	
	@Override
	public List<PrescriptionVO> getAllPrescription() {
		List<PrescriptionVO> preList = null;
		try {
			preList = smc.queryForList("prescription.getAllPrescription");
		} catch (SQLException e) {
			preList = null;
			e.printStackTrace();
		}
		return preList;
	}

}
