package yaksa.member.service.say;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.dao.say.SayDaoImpl;
import yaksa.member.util.prescription.BuildedSqlMapClient;
import yaksa.member.vo.say.SayVO;

public class SayServiceImpl implements InterSayService{
	private SqlMapClient smc;
	private static SayDaoImpl dao; 
	private static SayServiceImpl service; 
	
	private SayServiceImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	public static SayServiceImpl getInstance() {
		if(service==null) service = new SayServiceImpl();
		dao = SayDaoImpl.getInstance();
		return service;
	}
	
	@Override
	public List<SayVO> getAllSay() {
		// TODO Auto-generated method stub
		return dao.getAllSay();
	}
	
	
}
