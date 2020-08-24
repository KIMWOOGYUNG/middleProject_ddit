package yaksa.chemist.service.inventory;

import java.util.List;

import yaksa.chemist.vo.inventory.insertVO;
import yaksa.chemist.vo.inventory.invVO;
import yaksa.chemist.vo.inventory.medVO;
import yaksa.chemist.vo.inventory.saleVO;
import yaksa.member.vo.mypage.MemVo;

public interface IPharmService {
	/**
	 * 
	 * @param mem_id
	 * @return 성공1 실패0
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
	
	public int insertMedicine(insertVO vo);
	
	public List<insertVO> getMedicine_insert(String phid_name);
	
	public List<saleVO> getMedicine_sale(String phid_name);
}
