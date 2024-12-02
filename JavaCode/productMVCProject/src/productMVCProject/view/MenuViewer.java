package productMVCProject.view;

public class MenuViewer {
	// 메인메뉴
	public static void mainMenuView() {
		System.out.println("주문 재고 관리 프로그램");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("[1. 재고 정보 메뉴]  [2. 주문 정보 메뉴]  [3. 고객 정보 메뉴]  [4. 프로그램 종료]");
		System.out.print("번호 선택 : ");
	}

	// 재고 메뉴
	public static void productMenuView() {
		System.out.println();
		System.out.println("재고 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 재고 정보 목록");
		System.out.println("2. 재고 정보 입력");
		System.out.println("3. 재고 정보 수정");
		System.out.println("4. 재고 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// 주문 메뉴
	public static void orderMenuView() {
		System.out.println();
		System.out.println("주문 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 주문 정보 목록");
		System.out.println("2. 주문 정보 입력");
		System.out.println("3. 주문 전체 수정");
		System.out.println("4. 주문 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}
	
	// 고객 메뉴
	public static void customerMenuView() {
		System.out.println();
		System.out.println("고객 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 고객 정보 목록");
		System.out.println("2. 고객 정보 입력");
		System.out.println("3. 고객 전체 수정");
		System.out.println("4. 고객 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

}