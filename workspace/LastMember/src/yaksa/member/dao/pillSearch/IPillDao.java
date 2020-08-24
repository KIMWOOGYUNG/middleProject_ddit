package yaksa.member.dao.pillSearch;

import java.util.List;

import yaksa.member.vo.pillSearch.PillVO;

public interface IPillDao {
	
	/**
	 * 전체 약정보를 DB에서 가져와 각각의 정보는 PillVO에 담고, 
	 * 이 PillVO객체를 List에 넣어서 반환하는 메서드
	 * 
	 * @return 전체 약정보(PillVO객체)가 저장된 List객체
	 */
	public List<PillVO> getAllPill();
	
	/**
	 * 검색할 컬럼명과 검색할 단어가 저장된 Map을 매개변수로 받아서 해당 데이터를 검색하여 List로 반환하는 메서드
	 * @param searchMap 검색할 컬럼명과 검색할 단어가 저장된 Map객체
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<PillVO> getSearchPill(String pill);
	
	/**
    * 
    * @param pill
    * @return
    */
   public List<PillVO> getSearchPillNum(String pill);
   
   /**
    * 
    * @param pill
    * @return
    */
   public List<PillVO> getSearchPillFrom(String pill);

}
