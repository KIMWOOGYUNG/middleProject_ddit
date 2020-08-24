package service;

import java.util.List;

import dao.IpharmDao;
import dao.PharmDaoImpl;
import vo.PrescriptionVO;

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
	public List<PrescriptionVO> getAllPrescription() {
		return dao.getAllPrescription();
	}
	
	
	
}
