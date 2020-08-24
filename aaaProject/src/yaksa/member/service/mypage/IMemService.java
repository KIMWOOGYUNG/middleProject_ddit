package yaksa.member.service.mypage;

import java.util.List;

import yaksa.member.vo.mypage.MemVo;

public interface IMemService {
	/**
	 * 
	 * @param mem_id
	 * @return 성공1 실패0
	 */
	public List<MemVo> getAllMember();
	
	public int updateMember(MemVo memVo);
}
