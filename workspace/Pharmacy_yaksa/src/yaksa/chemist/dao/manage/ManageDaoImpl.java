package yaksa.chemist.dao.manage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import yaksa.chemist.util.BuildedSqlMapClient;
import yaksa.chemist.vo.manage.PharmVO;

public class ManageDaoImpl implements InterManageDao{
   // ibatis 환경 설정
   private SqlMapClient smc; 
   // 싱글톤 패턴 생성
   private static ManageDaoImpl dao; 
   
   private ManageDaoImpl() { 
      smc =  BuildedSqlMapClient.getSqlMapClient();
   }
   
   public static ManageDaoImpl getInstance() {
      if(dao==null) dao = new ManageDaoImpl();
      return dao;
   }

   @Override
   public List<PharmVO> getAllYK(String PVO) {
      List<PharmVO> pList = null;
      try {
         pList = smc.queryForList("yaksamanage.lookYaksa",PVO);
      } catch (SQLException e) {
         pList=null; e.printStackTrace();
      }
      return pList;
   }

   @Override
   public int updateYK(PharmVO PVO) {
      int cnt = 0;
      try {
         cnt = smc.update("yaksamanage.updateYK",PVO);
      } catch (SQLException e) {e.printStackTrace();}
      return cnt;
   }
   
   
   @Override
   public int updateZipYK(PharmVO PVO) {
      int cnt = 0;
      try {
         cnt = smc.update("yaksamanage.updateZipYK",PVO);
      } catch (SQLException e) {e.printStackTrace();}
      return cnt;
   }

   @Override
   public int UpdateTimeYK(Map<String, String> updatemap) {
      int cnt = 0; 
      try {
         cnt = smc.update("yaksamanage.updateYKTime",updatemap);
      } catch (SQLException e) { e.printStackTrace(); }
      return cnt;
   }

   @Override
   public int deleteYK(String pharmid) {
      int cnt = 0;
      try {
         cnt = smc.delete("yaksamanage.deleteYK",pharmid);
      } catch (SQLException e) { }
      return cnt;
   }

   

}