package yaksa.server.service.pay;

import yaksa.server.dao.pay.IPayDao;
import yaksa.server.dao.pay.PayDaoImpl;
import yaksa.server.vo.pay.PayVO;

public class PayServiceImpl implements IPayService {
	private IPayDao dao;  // DAO객체가 저장될 변수 선언
	
	private static PayServiceImpl service;
	
	//생성자
	//public MemberServiceImpl() {
	private PayServiceImpl() {
		//dao = new MemberDaoImpl();	// DAO객체 생성
		dao = PayDaoImpl.getInstance();
	}
	
	public static PayServiceImpl getInstance(){
		if(service==null) service = new PayServiceImpl();
		return service;
	}

	@Override
	public int insertPay(PayVO payVO) {
		return dao.insertPay(payVO);
		
	}

	
}
