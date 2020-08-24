package dao;

import java.util.List;

import vo.PrescriptionVO;

public interface IpharmDao {
	/**
	 * ��û���� ó���� ������ DB���� ������ ������ ������ PrescriptionVO�� ���,
	 * �� PrescriptionVO�� List�� �־ ��ȯ�ϴ� �޼���
	 * @return ó���� ������ ����� List��ü
	 */
	public List<PrescriptionVO> getAllPrescription();
}
