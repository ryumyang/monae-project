package monaeProject;
import java.util.ArrayList;
import java.util.Scanner;

public class monaeSuper {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Custom user = new Custom();	
		
		user.addpdList("사과",400);
		user.addpdList("바나나",300);
		user.addpdList("파인애플",500);
		user.addpdList("오이소박이",100);
		user.addpdList("딸기", 400);
		
		System.out.println("<< 모네슈퍼에 오신걸 환영합니다.");
		System.out.println();
		System.out.println("당신이 소지하고 계신 금액을 입력하세요.");
		System.out.print("금액 : ");
		user.cash();
		System.out.println();
		System.out.println("> 아래의 메뉴에서 원하는 메뉴의 번호를 누르세요.");
		
		while(true) {
		System.out.println("1. 상품구매   2. 마이페이지   3. 종료");
		System.out.print("메뉴 : ");
		int num = sc.nextInt();
		System.out.println();
		
		if(num==1) {
			System.out.println("아래의 상품 리스트 중 원하는 번호를 입력하세요. ");
			System.out.println("=========================");
			for(int i=0; i<user.pdList.size(); i++) {
				System.out.println((i+1)+". "+user.pdList.get(i).getName()+" , "+user.pdList.get(i).getPrice()+"원");}
			System.out.println(user.pdList.size()+1 +". 종료 ");
			System.out.println("=========================");
			System.out.println();
			user.buyPd();
			}// 상품리스트
		else if(num==2) {
			while(true) {
				System.out.println(" <  M Y P A G E  >");
				System.out.println("> 아래의 메뉴에서 원하는 메뉴의 번호를 누르세요.");
				System.out.println("1. 나의 잔액 확인   2. 구매 완료 상품 리스트    3. 종료");
				System.out.print("입력 : ");
				int mum = sc.nextInt();
				System.out.println();
				
				if(mum==1) {
					System.out.println("현재 고객님의 잔액은  "+user.getcash()+"원 입니다.");
					}//	나의 잔액 확인
				else if(mum==2) {
					user.buyList();
					}//	구매완료 상품 리스트
				else if(mum==3) {System.out.println("MYPAGE 를 종료합니다."); break;}
				else if(mum>3) {System.out.println("번호를 잘못 눌렀습니다 . 다시 인력해주세요. . "); System.out.println();}
			}//while
		}// 마이페이지
		else if(num==3) {System.out.println("상품구매를 종료합니다.");  break;}//	메뉴종료 
		else if(num>3) {System.out.print("잘못된 번호입니다 . 다시 입력해주세요.");
						System.out.println();}// 예외
		}// while
	}// main
}// super class

class Custom{
	Scanner sc = new Scanner(System.in);
	private int cash;	//소지한 금액
	ArrayList <Product> pdList;	//상품리스트
//	ArrayList <Wish> wsList;	//구매하지 않은 위시리스트
	
	public Custom(){				
		pdList = new ArrayList<Product>();
//		wsList = new ArrayList<Wish>();
	}
	
	void setcash(int enter) {this.cash = enter;}
	int getcash() {return cash;}
	
	void addpdList(String name, int price) {	//상품리스트에 상품추가
		Product pd = new Product();
		pd.setName(name);
		pd.setPrice(price);
		
		pdList.add(pd);		
	}// addPdList();
	
	void cash() {
		int num = sc.nextInt();
		setcash(num);
		System.out.println(" > 현재 고객님이 소지하고 계신 금액은 "+getcash()+"원 입니다. <");
		return;
	}// cash();
	
	void buyPd() {	//구매한 상품, 구매한 뒤의 메뉴
		while(true) {
			System.out.print("구매하고자 하는 상품의 번호를 입력해주세요.  :  ");
			int num = sc.nextInt();
			System.out.println();
			
			if(getcash() > pdList.get(num-1).getPrice()) {
				setcash(getcash() - pdList.get(num-1).getPrice());
				System.out.println("현재 잔액은  "+getcash()+"원 입니다.");
				
				totalPdc(num);
				System.out.println();
				
//				while(true) {				
					System.out.println("> 아래의 메뉴에서 원하는 메뉴의 번호를 누르세요.");
					System.out.println("1. 상품 구매  2. 구매한 상품 리스트   3. 종료");
					System.out.print("입력 : ");
					int num1 = sc.nextInt();
				
					if(num1==1) {System.out.println();}
					else if(num1==2) {buyList(); break;}
					else if(num1==3) {System.out.println("메뉴를 종료합니다."); break;}
					break;
//				}//while
			}//	구매완료한 뒤 if 
				else if (getcash() < pdList.get(num-1).getPrice()){
				System.out.println("잔액이 부족합니다.");
				System.out.println("잔액부족으로 상품구매를 종료합니다.");
				break;}
		} //while
	}// buyPd();
	
	void totalPdc(int num) {	//구매한 상품 총 갯수
		pdList.get(num-1).setCount(pdList.get(num-1).getCount()+1);
		System.out.println(pdList.get(num-1).getName()+"의 구매한 총 갯수는 "+pdList.get(num-1).getCount()+"개 입니다.");
	}//	totalPdc();
	
	void buyList() {
		System.out.println("구매 완료 상품 리스트 ");
		System.out.println("=================");
		for(int i=0; i<pdList.size(); i++) {
			System.out.println(pdList.get(i).getName()+" , "+ pdList.get(i).getCount()+" 개 입니다.");}
	}// buyList();	
	
	void addwsList() {		//위시리스트 상품
		
	}// addCt();
	
}// class Custom

class Product {	
	private String pName;
	private int pPrice;
	private int count = 0;	// 구매한 상품 갯수
	

	void setName(String str) {this.pName = str;}
	String getName() {return pName;}
	void setPrice(int num) {this.pPrice = num;}
	int getPrice() {return pPrice;}
	void setCount(int num) {this.count = num;}
	int getCount() {return count;}
}// class Product

//class Wish extends Product{
//	private int wishCt;	// ��ٱ��Ͽ� ���� ����
//	
//	void setWish(int num) {this.wishCt = num;}
//	int getWish() {return wishCt;}
//}// class Wish

            
