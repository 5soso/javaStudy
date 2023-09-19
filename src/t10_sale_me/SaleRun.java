package t10_sale_me;

import java.util.Scanner;

public class SaleRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductDAO dao = new ProductDAO();
		
		boolean run = true; // switch, while 같이 나오면 true에 변수 주기.
		
		while(run) {
			System.out.println("\n\t*** 작업선택 ***");
			System.out.println("========================================");
			System.out.print("1:상품관리   2:판매관리   3:종료 ==>");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					ProductService pService = new ProductService(dao);
					pService.getProductMenu();
					break;
				case 2:
					
					break;
				default:
					run = false;
			}
			dao.connClose(); //DAO가 중복이 되니까 끊어버림.
		}
		System.out.println("========================================");
		System.out.println("\t작업끝...");
		
		scanner.close();
	}
}
