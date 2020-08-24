package yaksa.chemist.service.prescription;

import java.util.List;

import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.InventoryVO;
import yaksa.chemist.vo.prescription.Mem_InboxVO;
import yaksa.chemist.vo.prescription.MemberVO;
import yaksa.chemist.vo.prescription.PharmVO;
import yaksa.chemist.vo.prescription.PrescriptionVO;
import yaksa.chemist.vo.prescription.ReceiptVO;
import yaksa.chemist.vo.prescription.SaleVO;

public interface IpharmService {
	
	public List<Mem_InboxVO> getAllReceipt();

	public List<InboxVO> getAllPrescription();
	
	public int acceptPrescription(int phar_messnum);
	
	public int rejectPrescription(int phar_messnum);
	
	public PharmVO getPharmacy(String pharm_id);
	
	public MemberVO getMember(String mem_id);
	
	public List<InventoryVO> getAllInventory();
	
	public String getMediName(String medi_Code);

	public List<InventoryVO> searchMedicine(String medicine_name);
	
	public int insertMediSale(SaleVO saleVo);
	
	public int insertHistory(ReceiptVO rcVo);
	
	public int insertPrescription(PrescriptionVO presVo);
	
	public String getOutPrice(String medi_Code);
}
