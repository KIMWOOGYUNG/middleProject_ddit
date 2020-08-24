package yaksa.member.service.join;

import java.util.List;
import java.util.Map;

import yaksa.member.dao.join.CalendarDao;
import yaksa.member.vo.join.CalendarVO;

public class CalendarService implements ICalendarService{
	private static CalendarService calService;
	private CalendarDao calDao;
	
	public static CalendarService getInstance() {
		if(calService == null)
			calService = new CalendarService();
		return calService;
	}
	public CalendarService() {
		calDao = CalendarDao.getInstance();
	}
	
	@Override
	public void insertCal(CalendarVO calVo) {
		calDao.insertCal(calVo);
	}
	
	@Override
	public List<CalendarVO> getAllCal(Map<String, Integer> calMap) {
		return calDao.getAllCal(calMap);
	}
	
//	@Override
//	public List<calDateVO> getDetail(Map<String, Integer> calMap) {
//		return calDao.getDetail(calMap);
//	}
	
//	@Override
//	public void deleteCal(int cal_num) {
//		calDao.deleteCal(cal_num);
//	}
	
//	@Override
//	public void updateDetail(CalendarVO calVo) {
//		calDao.updateDetail(calVo);
//	}
	
}
