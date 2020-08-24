package yaksa.member.service.join;

import java.util.Map;

import yaksa.member.vo.join.MemberVO;

public interface IMemberService {
	
	/**
	 * 새로운 회원정보를 DB에 가져와 정보는 memberVO에 담고,
	 * 성공하면 1, 실패하면 0을 반환
	 * 
	 * @param joinVO
	 * @return 성공 1, 실패0
	 */
	public int addMember(MemberVO memberVO);
	
	/**
	 * 회원ID를 매개변수로 받아서 중복되는 아이디가 없는지 확인하는 메서드
	 * 
	 * @param mem_id
	 * @return 중복 : 1, 중복X : 0
	 */
	public int SelectMember(String mem_id);
	
	/**
	 * 회원 PW를 받아서 비밀번호가 존재하는지를 확인하는 메서드
	 * 
	 * @param mem_pw
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int LoginMember(String mem_pw);
	
	/**
	 * 하나의 memberVO를 이용하여 우편번호와 주소를 update하는 메서드
	 * 
	 * @param memberVO
	 * @return 작업성공 : 1, 실패 :0
	 */
	public int updateZipNum(MemberVO memberVO);
	
	/**
	 * 회원이름을 받아서 이름이 존재하는지를 확인하는 메서드
	 * 
	 * @param mem_name
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int SearchNameMember(String mem_name);
	
	/**
	 * 회원 생년월일을 받아서 생년월일이 존재하는지를 확인하는 메서드
	 * 
	 * @param mem_regno1
	 * @return 로그인 성공 : 1, 로그인 실패 : 0
	 */
	public int SearchRegMember(String mem_regno1);
	
	/**
	 * 
	 * @return null
	 */
	public MemberVO getMember(Map<String, String> searchMapr);
	
	/**
	 * 
	 * @param searchMap
	 * @return
	 */
	public MemberVO getMemberId(Map<String, String> searchMap);
	
	/**
	 * 검색할 컬럼명과 검색할 단어가 저장된 Map을 매개변수로 받아서 해당 데이터를 검색하여 List로 반환하는 메서드
	 * 
	 * @param searchMap 검색할 컬럼명과 검색할 단어가 저장된 Map 객체
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	//public List<MemberVO> SearchId(Map<String, String> searchMap);
	
	/**
    * 
    * 
    * @param MemberVO
    * @return 작업성공 : 1, 실패 :0
    */
   public int ModifyPw(MemberVO memberVO);

}
