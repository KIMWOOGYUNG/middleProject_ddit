package yaksa.chemist.service.manage;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.chemist.dao.manage.ManageDaoImpl;
import yaksa.chemist.util.BuildedSqlMapClient;
import yaksa.chemist.vo.manage.PharmVO;



public class ManageServiceImpl implements InterManageService{
   
   private SqlMapClient smc;
   private static ManageDaoImpl dao;
   private static ManageServiceImpl service;
   
   private ManageServiceImpl() {
      smc = BuildedSqlMapClient.getSqlMapClient();
   }
   public static ManageServiceImpl getInstance() {
      if(service==null) service = new ManageServiceImpl();
      dao = ManageDaoImpl.getInstance();
      return service;
   }
   
   @Override
   public List<PharmVO> getAllYK(String PVO) {
      return dao.getAllYK(PVO);
   }
   @Override
   public int updateYK(PharmVO PVO) {
      return dao.updateYK(PVO);
   }
   @Override
   public int UpdateTimeYK(Map<String, String> updatemap) {
      return dao.UpdateTimeYK(updatemap);
   }
   @Override
   public int deleteYK(String pharmid) {
      return dao.deleteYK(pharmid);
   }
   @Override
   public int updateZipYK(PharmVO PVO) {
      return dao.updateZipYK(PVO);
   }

}