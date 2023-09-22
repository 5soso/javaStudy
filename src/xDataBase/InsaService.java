package xDataBase;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	
	//오늘 날짜 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO();

		Calendar cal = Calendar.getInstance(); //이해가 안 됨........
		vo.setStrYY(cal.get(Calendar.YEAR) + "");
		vo.setStrMM((cal.get(Calendar.MONTH)+1) + "");
		vo.setStrDD(cal.get(Calendar.DATE) + "");
		
//		if(cal.get((Calendar.MONTH)+1)<9)

		return vo;
	}
	
}
