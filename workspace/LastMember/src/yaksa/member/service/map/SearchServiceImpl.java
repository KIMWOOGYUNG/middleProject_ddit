package yaksa.member.service.map;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.member.dao.map.SearchDaoImpl;
import yaksa.member.util.prescription.BuildedSqlMapClient;
import yaksa.member.vo.map.PharmVO;

public class SearchServiceImpl implements InterSearchService{

	private SqlMapClient smc;
	private static SearchDaoImpl dao; 
	private static SearchServiceImpl service; 
	
	private SearchServiceImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	public static SearchServiceImpl getInstance() {
		if(service==null) service = new SearchServiceImpl();
		dao = SearchDaoImpl.getInstance();
		return service;
	}
	
	@Override
	public List<PharmVO> searchYK(Map<String, String> mapjuso) {
		return dao.searchYK(mapjuso);
	}
	@Override
	public List<PharmVO> pharmName(String phname) {
		return dao.pharmName(phname);
	}
	
}
