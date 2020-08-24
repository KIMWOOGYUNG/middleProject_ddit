package dao;

import java.util.List;

import vo.PrescriptionVO;

public interface IpharmDao {
	/**
	 * 요청받은 처방전 정보를 DB에서 가져와 각각의 정보는 PrescriptionVO에 담고,
	 * 이 PrescriptionVO를 List에 넣어서 반환하는 메서드
	 * @return 처방전 정보가 저장된 List객체
	 */
	public List<PrescriptionVO> getAllPrescription();
}
