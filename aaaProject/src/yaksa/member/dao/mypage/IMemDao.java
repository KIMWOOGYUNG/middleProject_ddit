package yaksa.member.dao.mypage;

import java.util.List;

import yaksa.member.vo.mypage.MemVo;

public interface IMemDao {

/**
 *  
 * @return 환자 정보 반환
 */
public List<MemVo> getAllMember();

public int updateMember(MemVo memVo);
}
