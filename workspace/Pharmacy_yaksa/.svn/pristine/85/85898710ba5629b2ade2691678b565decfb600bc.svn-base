package yaksa.chemist.dao.inventory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.chemist.util.BuildedSqlMapClient;
import yaksa.chemist.vo.inventory.insertVO;
import yaksa.chemist.vo.inventory.invVO;
import yaksa.chemist.vo.inventory.medVO;
import yaksa.chemist.vo.inventory.saleVO;

public class PharmDaoImpl implements IPharmDao {

	// 싱글톤 패턴
	   private SqlMapClient smc;
	      
	   private static PharmDaoImpl dao;
	         
	   private PharmDaoImpl() {
	      smc = BuildedSqlMapClient.getSqlMapClient();
	   }
	   
	   public static PharmDaoImpl getInstance(){
	      if(dao == null) dao = new PharmDaoImpl();
	         
	       return dao;
	   }
	
	   
	   
	   public List<medVO> getMedicine(){
		   
		   List<medVO> medList = new ArrayList<medVO>();
		   try {
			   
			   medList = smc.queryForList("prod.getMedical");
			   
		   }catch (SQLException e) {
			e.printStackTrace();
			medList = null;
		}
		   return medList;
		   
		   
	   }

	@Override
	public int insertMedicine_inventory(List<invVO> list) {
		
		
		int cnt = 0;
		for(int i =0; i<list.size(); i++) {
			
			try {
				
				Object invList = smc.insert("prod.insertMedical",list.get(i));
				if(invList == null) {
					cnt =1;
				}else {
					cnt = 0;
				}
				
			} catch (SQLException e) {
				cnt = 0;
				
			}
		}
		
		return cnt;
	}

	@Override
	public List<invVO> getMedical_inventory() {
		
		List<invVO> invList = new ArrayList<invVO>();
		try {
			invList = smc.queryForList("prod.getMedical_inventory");
		} catch (SQLException e) {
			e.printStackTrace();
			invList = null;
		}
		return invList;
	}

	@Override
	public int insertMedicine(insertVO vo) {
		Object a = null;
		int cnt = 0;
		try {
			a = smc.insert("prod.medicine_insert",vo);
			if(a==null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
			
		} catch (Exception e) {
			
			cnt = 0;
		}
		
		return 0;
	}

	@Override
	public List<insertVO> getMedicine_insert(String phid_name) {
		
		List<insertVO> get_insert = new ArrayList<insertVO>();
		
		try {
			
			
			get_insert = smc.queryForList("prod.getMedicine_insert");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			get_insert = null;
			
		}
		
		return get_insert;
	}

	@Override
	public List<saleVO> getMedicine_sale(String phid_name) {
		
		List<saleVO> get_sale = new ArrayList<saleVO>();
		try {
			get_sale = smc.queryForList("prod.getMedicine_sale");
			
		} catch (SQLException e) {
			e.printStackTrace();
			get_sale=null;
		}
		return get_sale;
	}

}
