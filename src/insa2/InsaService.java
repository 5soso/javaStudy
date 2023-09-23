package insa2;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	
	//오늘 날짜 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO(); 
		
		Calendar cal = Calendar.getInstance();
		vo.setStrYY(cal.get(Calendar.YEAR) + ""); 
		vo.setStrMM((cal.get(Calendar.MONTH))+1 +""); // +1을 해준 이유?
		vo.setStrDD(cal.get(Calendar.DATE) + "");

		return vo; //vo에 담아서 던짐
	}
	
}
