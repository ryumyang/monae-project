package monaeProject;
import java.util.ArrayList;
import java.util.Scanner;

public class applehop {
	public static void main (String args[]) {
		ArrayList apList = new ArrayList<>();
		
		iPhone1 Phone = new iPhone1();
		iPad Pad = new iPad();
		iMac Mac = new iMac();
		Report list = new Report();
		
		while(true) {
			System.out.println("Apple 기기별 매출 현황");
			System.out.println("====================================");
			System.out.println("1. 판매기록입력  | 2. 현재 현황 출력  | 3. 종료");
			Scanner sc = new Scanner(System.in);
			int menuNum = sc.nextInt();
			System.out.println("입력 : "+menuNum);
			if(menuNum==1) {
				System.out.println("1. 아이폰  |  2. 아이패드  |  3. 아이맥  |  4. 악세사리");
				System.out.println("해당 기기의 번호를 입력하세요.");
				int listNum = sc.nextInt();
				System.out.println("입력 : "+listNum);
				if(listNum==1) {
					Phone.calTotal();
					Phone.info();
				}
				else if(listNum==2) {
					Pad.calTotal();
					Pad.info();
				}
				else if(listNum==3) {
					Mac.calTotal();
					Mac.info();
				}
			}
			else if(menuNum==2) {
				list.totalPrice();
				list.totalCount();
				list.info();
			}
			else if(menuNum==3) {
				System.out.println("\n");
				System.out.println("종료합니다.");
				break;
				}
			}
		}
}
class iPhone1 {
	Scanner sc = new Scanner (System.in);
	int price = 1000;
	static int count = 0 ;
	static int total = 0 ;

	int calTotal() {
		System.out.println("구매하신 iPhone의 가격은 "+price+"원 입니다.");
		this.price = price;
		System.out.println("구매하신 기기의 갯수를 입력하세요.");
		int count = sc.nextInt();
		System.out.println(count);
		this.count = count;
		return total = price*count;
		}
	void info() {
		System.out.println("구매하신 아이폰의 총 가격은 "+total+"원 입니다.");
		System.out.println("총 판매 개수 : "+count+" 개");
		}
}//iPhone
class iPad {
	Scanner sc = new Scanner (System.in);
	int price = 3000;
	static int count = 0 ;
	static int total = 0 ;
	
	int calTotal() {
		System.out.println("구매하신 iPad의 가격은 "+price+"원 입니다." );
		this.price = price;
		System.out.println("구매하신 기기의 갯수를 입력하세요.");
		int count = sc.nextInt();
		System.out.println(count);
		this.count = count;
		return total = price*count;
		}
	void info() {
		System.out.println("구매하신 아이패드의 총 가격은 "+total+"원 입니다.");
		System.out.println("총 판매 개수 : "+count+" 개");
		}
}//iPad
class iMac {
	Scanner sc = new Scanner (System.in);
	int price = 6000;
	static int count = 0 ;
	static int total = 0 ;
	
	int calTotal() {
		System.out.println("구매하신 iMac의 가격은 "+price+"원 입니다." );
		this.price = price;
		System.out.println("구매하신 기기의 갯수를 입력하세요.");
		int count = sc.nextInt();
		System.out.println(count);
		this.count = count;
		return total = price*count;
		}
	void info() {
		System.out.println("구매하신 아이맥 총 가격은 "+total+"원 입니다.");
		System.out.println("총 판매 개수 : "+count+" 개");
		}
}//iMac
class Report{
	int totalPrice = 0 ;
	int totalCount = 0 ;
	
	int totalPrice() {	
		totalPrice = iPhone1.total + iPad.total + iMac.total;		
		return this.totalPrice = totalPrice;
	}
	int totalCount() {
		totalCount = iPhone1.count + iPad.count + iMac.count;
		return this.totalCount = totalCount;
	}
	void info() {
		System.out.println("현재 총 매출은 "+totalPrice+"원 입니다.");
		System.out.println("총 판매량은 "+totalCount+"개 입니다.");
	}
}//Report
