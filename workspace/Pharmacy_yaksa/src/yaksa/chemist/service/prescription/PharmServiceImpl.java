package yaksa.chemist.service.prescription;

import java.util.List;

import yaksa.chemist.dao.prescription.IpharmDao;
import yaksa.chemist.dao.prescription.PharmDaoImpl;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.InventoryVO;
import yaksa.chemist.vo.prescription.Mem_InboxVO;
import yaksa.chemist.vo.prescription.MemberVO;
import yaksa.chemist.vo.prescription.PharmVO;
import yaksa.chemist.vo.prescription.PrescriptionVO;
import yaksa.chemist.vo.prescription.ReceiptVO;
import yaksa.chemist.vo.prescription.SaleVO;

public class PharmServiceImpl implements IpharmService{
	private static PharmServiceImpl service;
	
	private IpharmDao dao;
	
	private PharmServiceImpl() {
		dao = PharmDaoImpl.getInstance();
	}
	
	public static PharmServiceImpl getInstance() {
		if(service == null) service = new PharmServiceImpl();
		return service;
	}
	@Override
	public List<InboxVO> getAllPrescription() {
		return dao.getAllPrescription();
	}

	@Override
	public int acceptPrescription(int phar_messnum) {
		return dao.acceptPrescription(phar_messnum);
	}
	
	@Override
	public int rejectPrescription(int phar_messnum) {
		return dao.rejectPrescription(phar_messnum);
	}

	@Override
	public PharmVO getPharmacy(String pharm_id) {
		return dao.getPharmacy(pharm_id);
	}

	@Override
	public MemberVO getMember(String mem_id) {
		return dao.getMember(mem_id);
	}

	@Override
	public List<InventoryVO> getAllInventory() {
		return dao.getAllInventory();
	}

	@Override
	public String getMediName(String medi_Code) {
		return dao.getMediName(medi_Code);
	}

	@Override
	public List<InventoryVO> searchMedicine(String medicine_name) {
		return dao.searchMedicine(medicine_name);
	}

	@Override
	public int insertMediSale(SaleVO saleVo) {
		return dao.insertMediSale(saleVo);
	}

	@Override
	public int insertHistory(ReceiptVO rcVo) {
		return dao.insertHistory(rcVo);
	}

	@Override
	public int insertPrescription(PrescriptionVO presVo) {
		return dao.insertPrescription(presVo);
	}

	@Override
	public List<Mem_InboxVO> getAllReceipt() {
		return dao.getAllReceipt();
	}

	@Override
	public String getOutPrice(String medi_Code) {
		return dao.getOutPrice(medi_Code);
	}

	
	
}
