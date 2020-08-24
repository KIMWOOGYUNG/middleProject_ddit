package yaksa.server.dao.prescription;

import yaksa.server.vo.prescription.InboxVO;
import yaksa.server.vo.prescription.ReceiptVO;

public interface IDao {
	public int chkFileName(int fileName); 

	public int insertPhar_inbox(InboxVO inboxVo);
	
	public int insertMem_inbox(ReceiptVO receiptVo);
}
