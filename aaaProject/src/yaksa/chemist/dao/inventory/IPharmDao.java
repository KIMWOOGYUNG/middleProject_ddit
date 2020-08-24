package yaksa.chemist.dao.inventory;

import java.util.List;

import yaksa.chemist.vo.inventory.insertVO;
import yaksa.chemist.vo.inventory.invVO;
import yaksa.chemist.vo.inventory.medVO;
import yaksa.chemist.vo.inventory.saleVO;
import yaksa.member.vo.mypage.MemVo;

public interface IPharmDao {

/**
 *  
 * @return 추가할 약종류 반환
 */
	public List<medVO> getMedicine();
	
	/**
	 * 
	 * @return 약 인벤토리 정보에 추가
	 */
	public int insertMedicine_inventory(List<invVO> list);
	
	/**
	 * 
	 * @return 약 인벤토리에 띄우기
	 */
	public List<invVO> getMedical_inventory();
	
	/**
	 * 
	 * @param vo 추가한 정보
	 * @return 입고하기 약 수량
	 */
	public int insertMedicine(insertVO vo);
	
	/**
	 * 
	 * @param phid_name
	 * @return 입고한 약 수량 기록 리스트
	 */
	public List<insertVO> getMedicine_insert(String phid_name);
	
	/**
	 * 
	 * @return 판매한  약 수량 기록 리스트
	 */
	public List<saleVO> getMedicine_sale(String phid_name);
}
