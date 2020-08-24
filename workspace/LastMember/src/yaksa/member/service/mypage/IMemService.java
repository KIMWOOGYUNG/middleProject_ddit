package yaksa.member.service.mypage;

import java.util.List;

import yaksa.member.vo.mypage.MemVo;
import yaksa.member.vo.mypage.PharmPresVO;

public interface IMemService {
	/**
	 * 
	 * @param mem_id
	 * @return 성공1 실패0
	 */
	public List<MemVo> getAllMember(String mem_id);
	
	public int updateMember(MemVo memVo);
	
	public List<PharmPresVO> ykvisit(String a);
}
