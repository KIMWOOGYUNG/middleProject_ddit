package yaksa.member.service.prescription;

import java.util.List;
import java.util.Map;

import yaksa.member.vo.prescription.Mem_InboxVO;
import yaksa.member.vo.prescription.Phar_InboxVO;

public interface IMemService {
	
	public List<Mem_InboxVO> getAllReceipt();
	
	public List<Phar_InboxVO> getAllPres();
	
	public int updateRate(Map<String, String> amap);
	
	public int updatePersue(String code);
}
