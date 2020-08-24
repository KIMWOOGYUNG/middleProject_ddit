package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BuildedSqlMapClient {
   private static Logger logger = Logger.getLogger(BuildedSqlMapClient.class);

   private static SqlMapClient smc;
   
   static{
      try {
         // 1. iBatis?�� ?��경설?�� ?��?��?�� ?��?��???�� ?��?��?��?��?��.
         // 1-1. 문자 ?��코딩 캐릭?��?�� ?��?��
    	  
    	 logger.info("?��경설?�� ?��?��?�� ?��코딩 캐릭?��?�� ?��?�� ?��?��..");
         Charset charset = Charset.forName("UTF-8");
         Resources.setCharset(charset);
         logger.info("?��경설?�� ?��?��?�� ?��코딩 캐릭?��?�� ?��?�� ?���?..");
         
         // 1-2. ?��경설?��?�� xml문서 ?��?��?���?
         logger.info("?��경설?�� ?��?��(sqlMapConfig.xml) ?��?��?���? ==> Reader객체 ?��?��..");
         Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
         
         // 1-3. ?��?��?�� ?��?��?�� Reader객체�? ?��?��?��?�� ?��?�� ?��?��?�� ?��?��?�� 객체�? ?��?��?��?��.
         //       ==> ?��경설?��?�� xml문서?�� ?��?��?�� 처리?�� ?�� ?��?��?�� ?��?��?�� 객체�? ?��?�� ?�� �??��.
         logger.info("?��경설?�� ?���? ?�� SqlMapClient객체 ?��?��...");
         smc = SqlMapClientBuilder.buildSqlMapClient(rd);
         
         logger.debug("Reader객체 ?���?");
         rd.close();
         
      } catch (IOException e) {
         //System.out.println("SqlMapClient객체 ?��?�� ?��?�� !");
         //e.printStackTrace();
    	  logger.error("SqlMapClient객체 ?��?�� ?��?��!!!", e);
      }
      
   }
   
   public static SqlMapClient getSqlMapClient(){
      logger.debug("SqlMapClient객체 반환?���?...");
	   return smc;
   }
   
   
}