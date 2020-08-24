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
         // 1. iBatis?˜ ?™˜ê²½ì„¤? • ?ŒŒ?¼?„ ?½?–´???„œ ?‹¤?–‰?‹œ?‚¨?‹¤.
         // 1-1. ë¬¸ì ?¸ì½”ë”© ìºë¦­?„°?…‹ ?„¤? •
    	  
    	 logger.info("?™˜ê²½ì„¤? • ?ŒŒ?¼?˜ ?¸ì½”ë”© ìºë¦­?„°?…‹ ?„¤? • ?‹œ?‘..");
         Charset charset = Charset.forName("UTF-8");
         Resources.setCharset(charset);
         logger.info("?™˜ê²½ì„¤? • ?ŒŒ?¼?˜ ?¸ì½”ë”© ìºë¦­?„°?…‹ ?„¤? • ?™„ë£?..");
         
         // 1-2. ?™˜ê²½ì„¤? •?š© xmlë¬¸ì„œ ?½?–´?˜¤ê¸?
         logger.info("?™˜ê²½ì„¤? • ?ŒŒ?¼(sqlMapConfig.xml) ?½?–´?˜¤ê¸? ==> Readerê°ì²´ ?ƒ?„±..");
         Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
         
         // 1-3. ?œ„?—?„œ ?½?–´?˜¨ Readerê°ì²´ë¥? ?´?š©?•˜?—¬ ?‹¤? œ ?‘?—…?— ?‚¬?š©?•  ê°ì²´ë¥? ?ƒ?„±?•œ?‹¤.
         //       ==> ?™˜ê²½ì„¤? •?š© xmlë¬¸ì„œ?˜ ?‚´?š©?„ ì²˜ë¦¬?•œ ?›„ ?‘?—…?— ?‚¬?š©?•  ê°ì²´ë¥? ?ƒ?„± ?•´ ì¤??‹¤.
         logger.info("?™˜ê²½ì„¤? • ?™„ë£? ?›„ SqlMapClientê°ì²´ ?ƒ?„±...");
         smc = SqlMapClientBuilder.buildSqlMapClient(rd);
         
         logger.debug("Readerê°ì²´ ?‹«ê¸?");
         rd.close();
         
      } catch (IOException e) {
         //System.out.println("SqlMapClientê°ì²´ ?ƒ?„± ?‹¤?Œ¨ !");
         //e.printStackTrace();
    	  logger.error("SqlMapClientê°ì²´ ?ƒ?„± ?‹¤?Œ¨!!!", e);
      }
      
   }
   
   public static SqlMapClient getSqlMapClient(){
      logger.debug("SqlMapClientê°ì²´ ë°˜í™˜?•˜ê¸?...");
	   return smc;
   }
   
   
}