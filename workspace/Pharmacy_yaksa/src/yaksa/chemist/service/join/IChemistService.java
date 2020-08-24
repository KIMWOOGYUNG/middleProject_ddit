package yaksa.chemist.service.join;

import java.util.Map;

import yaksa.chemist.vo.join.ChemistVO;

public interface IChemistService {

	/**
	 * 새로운 회원정보를 DB에 가져와 정보는 ChemistVO에 담고,
	 * 성공하면 1, 실패하면 0을 반환
	 * 
	 * @param chemistVO
	 * @return 성공1, 실패 0
	 */
	public int addPharm(ChemistVO ChemistVO);
	
	/**
	 * 약사ID를 매개변수로 받아서 중복되는 아디이가 없는지 확인하는 메서드
	 * 
	 * @param pharm_id
	 * @return 중복 : 1, 중복X : 0
	 */
	public int SelectChemist(String pharm_id);
	
	/**
	 * 약사 PW를 받아서 비밀번호가 존재하는지를 확인하는 메서드
	 * 
	 * @param pharm_pw
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int LoginChemist(String pharm_pw);
	
	/**
	 * 약국이름을 받아서 약국이름이 ChemistVO에 존재하는지를 확인하는 메서드
	 * 
	 * @param pharm_name
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int SearchPharmName(String pharm_name);
	
	/**
	 * 약사이름을 받아서 약사이름이 ChemistVO에 존재하는지를 확인하는 메서드
	 * 
	 * @param pharm_chname
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int SearchChemistName(String pharm_chname);
	
	/**
	 * 약사생년월일을 받아서 약사생년월일이 ChemistVO에 존재하는지를 확인하는 메서드
	 * 
	 * @param pharm_regno1
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int SerchRegChemist(String pharm_regno1);
	
	/**
	 * 하나의 ChemistVO를 이용하여 우편번호와 주소를 update하는 메서드
	 * 
	 * @param ChemistVO
	 * @return 작업성공 : 1, 실패 :0
	 */
	public int updateZipNum(ChemistVO ChemistVO);
	
	/**
	 * 
	 * 
	 * @param searchMap
	 * @return
	 */
	public ChemistVO getChemist(Map<String, String> searchMap);
	
	/**
	 * 
	 * @param searchMap
	 * @return
	 */
	public ChemistVO SearchChemistId(Map<String, String> searchMap);
	
	/**
    * 
    * 
    * @param pharm_pw
    * @return 작업성공 : 1, 실패 :0
    */
   public int ModifyPw(ChemistVO ChemistVO);
}
