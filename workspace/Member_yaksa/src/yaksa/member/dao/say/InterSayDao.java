package yaksa.member.dao.say;

import java.util.List;

import yaksa.member.vo.say.SayVO;

public interface InterSayDao {

	/**
	 * 명언의 모든 정보를 반환
	 * @return
	 */
	public List<SayVO> getAllSay();
	
}
