package insa2;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	
	//오늘 날짜 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO(); 
		
		Calendar cal = Calendar.getInstance(); //캘린더메소드 이해하기
		vo.setStrYY(cal.get(Calendar.YEAR) + ""); 
		vo.setStrMM((cal.get(Calendar.MONTH))+1 +""); // +1을 해준 이유? 월 (0부터 시작함, 0~11)
		vo.setStrDD(cal.get(Calendar.DATE) + "");

		return vo; //vo에 담아서 던짐
	}
	
}
