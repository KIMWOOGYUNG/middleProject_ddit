package yaksa.chemist.service.join;

import java.util.Map;

import yaksa.chemist.dao.join.ChemistDaoImpl;
import yaksa.chemist.dao.join.IChemistDao;
import yaksa.chemist.vo.join.ChemistVO;

public class ChemistServiceImpl implements IChemistService {

	private static ChemistServiceImpl service;
	private ChemistServiceImpl() {
		dao = ChemistDaoImpl.getInstance();
		
	}
	public static ChemistServiceImpl getInstance() {
		if(service == null) service = new ChemistServiceImpl();
		
		return service;
	}
	
	private IChemistDao dao;	// DAO객체가 저장될 변수 선언
	
	public void displayTest() {
		System.out.println("이것은 싱글톤 객체의 메스드 입니다.");
	}
	
	@Override
	public int addPharm(ChemistVO ChemistVO) {
		return dao.addPharm(ChemistVO);
	}
	
	@Override
	public int SelectChemist(String pharm_id) {
		return dao.SelectChemist(pharm_id);
	}
	
	@Override
	public int LoginChemist(String pharm_pw) {
		return dao.LoginChemist(pharm_pw);
	}
	
	@Override
	public int updateZipNum(ChemistVO ChemistVO) {
		return dao.updateZipNum(ChemistVO);
	}
	
	@Override
	public ChemistVO getChemist(Map<String, String> searchMap) {
		return dao.getChemist(searchMap);
	}
	
	@Override
	public int SearchPharmName(String pharm_name) {
		return dao.SearchChemistName(pharm_name);
	}
	
	@Override
	public int SerchRegChemist(String pharm_regno1) {
		return dao.SerchRegChemist(pharm_regno1);
	}
	
	@Override
	public int SearchChemistName(String pharm_chname) {
		return dao.SearchChemistName(pharm_chname);
	}
	
	@Override
	public ChemistVO SearchChemistId(Map<String, String> searchMap) {
		return dao.SearchChemistId(searchMap);
	}
	
	@Override
	public int ModifyPw(ChemistVO ChemistVO) {
		return dao.ModifyPw(ChemistVO);
	}
	
	
	
}
