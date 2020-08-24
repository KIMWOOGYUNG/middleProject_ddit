package yaksa.server.dao.pay;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.server.util.prescription.BuildedSqlMapClient;
import yaksa.server.vo.pay.PayVO;

public class PayDaoImpl implements IPayDao {

	// 싱글톤 패턴
	   private SqlMapClient smc;
	      
	   private static PayDaoImpl dao;
	         
	   private PayDaoImpl() {
	      smc = BuildedSqlMapClient.getSqlMapClient();
	   }
	   
	   public static PayDaoImpl getInstance(){
	      if(dao == null) dao = new PayDaoImpl();
	         
	       return dao;
	   }

	@Override
	public int insertPay(PayVO payVO) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("pay.insertPay",payVO);
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
	   


}
