package yaksa.member.service.prescription;

import java.util.List;
import java.util.Map;

import yaksa.member.dao.prescription.IMemDao;
import yaksa.member.dao.prescription.MemDaoImpl;
import yaksa.member.vo.prescription.Mem_InboxVO;
import yaksa.member.vo.prescription.Phar_InboxVO;

public class MemServiceImpl implements IMemService{
private static MemServiceImpl service;
	
	private IMemDao dao;
	
	private MemServiceImpl() {
		dao = MemDaoImpl.getInstance();
	}
	
	public static MemServiceImpl getInstance() {
		if(service == null) service = new MemServiceImpl();
		return service;
	}
	
	@Override
	public List<Mem_InboxVO> getAllReceipt() {
		return dao.getAllReceipt();
	}
	
	@Override
	public List<Phar_InboxVO> getAllPres() {
		return dao.getAllPres();
	}

	@Override
	public int updateRate(Map<String, String> amap) {
		return dao.updateRate(amap);
	}

	@Override
	public int updatePersue(String code) {
		return dao.updatePersue(code);
	}

}
