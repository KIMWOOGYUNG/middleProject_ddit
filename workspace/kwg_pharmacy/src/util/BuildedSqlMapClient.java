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
         // 1. iBatis? ?κ²½μ€?  ??Ό? ?½?΄??? ?€???¨?€.
         // 1-1. λ¬Έμ ?Έμ½λ© μΊλ¦­?°? ?€? 
    	  
    	 logger.info("?κ²½μ€?  ??Ό? ?Έμ½λ© μΊλ¦­?°? ?€?  ??..");
         Charset charset = Charset.forName("UTF-8");
         Resources.setCharset(charset);
         logger.info("?κ²½μ€?  ??Ό? ?Έμ½λ© μΊλ¦­?°? ?€?  ?λ£?..");
         
         // 1-2. ?κ²½μ€? ?© xmlλ¬Έμ ?½?΄?€κΈ?
         logger.info("?κ²½μ€?  ??Ό(sqlMapConfig.xml) ?½?΄?€κΈ? ==> Readerκ°μ²΄ ??±..");
         Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
         
         // 1-3. ??? ?½?΄?¨ Readerκ°μ²΄λ₯? ?΄?©??¬ ?€?  ??? ?¬?©?  κ°μ²΄λ₯? ??±??€.
         //       ==> ?κ²½μ€? ?© xmlλ¬Έμ? ?΄?©? μ²λ¦¬? ? ??? ?¬?©?  κ°μ²΄λ₯? ??± ?΄ μ€??€.
         logger.info("?κ²½μ€?  ?λ£? ? SqlMapClientκ°μ²΄ ??±...");
         smc = SqlMapClientBuilder.buildSqlMapClient(rd);
         
         logger.debug("Readerκ°μ²΄ ?«κΈ?");
         rd.close();
         
      } catch (IOException e) {
         //System.out.println("SqlMapClientκ°μ²΄ ??± ?€?¨ !");
         //e.printStackTrace();
    	  logger.error("SqlMapClientκ°μ²΄ ??± ?€?¨!!!", e);
      }
      
   }
   
   public static SqlMapClient getSqlMapClient(){
      logger.debug("SqlMapClientκ°μ²΄ λ°ν?κΈ?...");
	   return smc;
   }
   
   
}