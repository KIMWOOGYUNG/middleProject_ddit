package yaksa.server.dao.prescription;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.server.util.prescription.BuildedSqlMapClient;
import yaksa.server.vo.prescription.InboxVO;
import yaksa.server.vo.prescription.ReceiptVO;


public class DaoImpl implements IDao{
	
	private static DaoImpl dao;
	private SqlMapClient smc;

	private DaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static DaoImpl getInstance() {
		if(dao == null) dao = new DaoImpl();
		return dao;
	}

	@Override
	public int chkFileName(int fileName) {
		int cnt = 0;
		try {
			cnt = (int)smc.queryForList("prescription.chkFileName", fileName).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertPhar_inbox(InboxVO inboxVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("prescription.insertPhar_inbox", inboxVo);
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertMem_inbox(ReceiptVO receiptVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("prescription.insertMem_inbox", receiptVo);
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
