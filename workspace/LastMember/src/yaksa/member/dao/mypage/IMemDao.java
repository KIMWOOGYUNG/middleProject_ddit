package yaksa.member.dao.mypage;

import java.util.List;

import yaksa.member.vo.mypage.MemVo;
import yaksa.member.vo.mypage.PharmPresVO;

public interface IMemDao {

	public List<MemVo> getAllMember(String mem_id);
	
	public int updateMember(MemVo memVo);
	
	public List<PharmPresVO> ykvisit(String a);

}
