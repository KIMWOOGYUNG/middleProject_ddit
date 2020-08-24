package yaksa.chemist.dao.prescription;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.chemist.util.BuildedSqlMapClient;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.InventoryVO;
import yaksa.chemist.vo.prescription.Mem_InboxVO;
import yaksa.chemist.vo.prescription.MemberVO;
import yaksa.chemist.vo.prescription.PharmVO;
import yaksa.chemist.vo.prescription.PrescriptionVO;
import yaksa.chemist.vo.prescription.ReceiptVO;
import yaksa.chemist.vo.prescription.SaleVO;

public class PharmDaoImpl implements IpharmDao{
	
	private static PharmDaoImpl dao;
	private SqlMapClient smc;
	
	private PharmDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static PharmDaoImpl getInstance() {
		if(dao == null) dao = new PharmDaoImpl();
		return dao;
	}
	
	@Override
	public List<InboxVO> getAllPrescription() {
		List<InboxVO> preList = null;
		try {
			preList = smc.queryForList("prescription.getAllPrescription");
		} catch (SQLException e) {
			preList = null;
			e.printStackTrace();
		}
		return preList;
	}

	@Override
	public int acceptPrescription(int phar_messnum) {
		int cnt = 0; 
		try {
			cnt = smc.update("prescription.acceptPrescription", phar_messnum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public int rejectPrescription(int phar_messnum) {
		int cnt = 0; 
		try {
			cnt = smc.update("prescription.rejectPrescription", phar_messnum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public PharmVO getPharmacy(String pharm_id) {
		PharmVO pharmVo = null;
		try {
			pharmVo = (PharmVO) smc.queryForObject("prescription.getPharmacy",pharm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pharmVo;
	}

	@Override
	public MemberVO getMember(String mem_id) {
		MemberVO memVo = null;
		try {
			memVo = (MemberVO) smc.queryForObject("prescription.getMember",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVo;
	}

	@Override
	public List<InventoryVO> getAllInventory() {
		List<InventoryVO> invList = null;
		try {
			invList = smc.queryForList("prescription.getAllInventory");
		} catch (SQLException e) {
			invList = null;
			e.printStackTrace();
		}
		return invList;
	}

	@Override
	public String getMediName(String medi_Code) {
		String medi_name = null;
		try {
			medi_name = (String) smc.queryForObject("prescription.getYakName",medi_Code);
		} catch (SQLException e) {
			medi_name = null;
			e.printStackTrace();
		}
		return medi_name;
	}

	@Override
	public List<InventoryVO> searchMedicine(String medicine_name) {
		List<InventoryVO> invenList = null;
		try {
			invenList = smc.queryForList("prescription.searchMedicine", medicine_name);
		} catch (SQLException e) {
			invenList = null;
			e.printStackTrace();
		}
		return invenList;
	}

	@Override
	public int insertMediSale(SaleVO saleVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("prescription.insertMediSale", saleVo);
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertHistory(ReceiptVO rcVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("prescription.insertHistory", rcVo);
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertPrescription(PrescriptionVO presVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("prescription.insertPrescription", presVo);
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<Mem_InboxVO> getAllReceipt() {
		List<Mem_InboxVO> rcList = null;
		try {
			rcList = smc.queryForList("prescription.getAllReceipt");
		} catch (SQLException e) {
			rcList = null;
			e.printStackTrace();
		}
		return rcList;
	}

	@Override
	public String getOutPrice(String medi_Code) {
		String outPrice = null;
		try {
			outPrice = (String) smc.queryForObject("prescription.getOutPrice",medi_Code);
		} catch (SQLException e) {
			outPrice = null;
			e.printStackTrace();
		}
		return outPrice;
	}


}
