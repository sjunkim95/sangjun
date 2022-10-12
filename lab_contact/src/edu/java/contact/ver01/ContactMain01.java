package edu.java.contact.ver01;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain01 {
    // 상수
    private static final int MAX_LENGTH = 3; // 저장할 수 있는 연락처의 최대 개수(배열 길이).
    
    
    // field
    
    // 밑에, = new Scanner 사용함으로 밑에 default constructor 불필요
    // 이걸, 밑에 main 메서드에서 사용할때 사용할 때 app.scanner로 사용함.
    private Scanner scanner = new Scanner(System.in); // 입력 도구
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처들의 배열
    private int count = 0; // 배열에 저장된 연락처의 개수. 새 연락처가 추가될 때마다 증가됨.
    
    
    /* default constructor
    public ContactMain01() {
        scanner = new Scanner(System.in); // null point exception 때문에 이렇게 기본생성자 만들고 선언.
    }*/

    public static void main(String[] args) {
        
        System.out.println("**** 연락처 프로그램 Version 0.1 ****");
        
        // static이 아닌 메서드를 호출하기 위해서 객체를 생성할 필요가 있음.
        ContactMain01 app = new ContactMain01();
        
//        Scanner scanner = new Scanner(System.in); <- 이거 대신에 7번줄에 private으로 멤버변수로 선언
//      why? 여러 메서드에서 사용하기 위해서
        
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        while(run) {
            // 메인 메뉴 보여 주기
            app.showMainMenu();
            
            // 사용자에게 메뉴 입력 받기
            int n = Integer.parseInt(app.scanner.nextLine()); //참조변수.맴버변수.nextLine();
            MainMenu menu = MainMenu.getValue(n);
            
            // switch-case
            switch(menu) {
            case QUIT: //종료
                run = false;
                break;
            case SELECT_ALL: // 전체 리스트
                app.selectAllContacts();
                break;
            case SELECT_BY_INDEX: // 인덱스 검색
                app.selectContactByIndex();
                break;
            case CREATE: // 새로운 연락처 추가.
                app.insertNewContact();
                break;
            case UPDATE:
                app.updateContact();
                break;
            default:
                System.out.println("지원하지 않는 메뉴 번호입니다. 다시 선택하세요.");
            }
        }

        System.out.println("**** 프로그램 종료 ****");
    } // end main
    
    
    private void showMainMenu() {
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("---------------------------------------------------------------");
        System.out.println("메뉴 선택> ");
    }
    
    private void selectAllContacts() {
        // 배열 contacts에 저장된 Contact 객체들을 출력.
        /*
        for (Contact c : contacts) {
            c.printContact(); // null point exception 조심해야한다. 그래서 위에서 count 이용
        }*/ 
        
        System.out.println("---- 연락처 전체 리스트 ----");
        
        for (int i = 0; i < count; i++) {
            // 배열의 길이만큼 반복하는 것이 아니라, 배열에 실제로 저장된 연락처 개수만큼만 반복함.
            contacts[i].printContact();
        }
        System.out.println("-----------------------------");        
    }
    
    private void insertNewContact() {
        // TODO: ArrayIndextOutOfBoundsException 해결, 밑에 배열에 추가부분. Count가 3이 되는 순간 멈춘다.
        // 해결!!
        
        if(count>=MAX_LENGTH) {
            System.out.println("입력할 수 있는 전화번호가 초과되었습니다.");
            return;
        } else {
            
            // 이름, 전화번호, 이메일 입력
            System.out.println("이름 입력>> ");
            String name = scanner.nextLine();
            
            System.out.println("전화번호 입력>> ");
            String phone = scanner.nextLine();
            
            System.out.println("이메일 입력>> ");
            String email = scanner.nextLine();
            
            // Contact 객체 생성
            Contact c = new Contact(name, phone, email);
            
            // 배열에 추가
            contacts[count] = c;
            count++; // 배열에 저장된 연락처 개수를 1 증가
        }
        
    }
    
    private void selectContactByIndex() {
        // TODO: NullPointerException 또는 ArrayIndexOutOfBoundsException 발생할 수 있음.
        // 해결!!
        
        // 검색할 인덱스 입력
        System.out.println("검색할 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        
        
        if (index < 0 || index >= count) {
            System.out.println("인덱스 값이 존재하지 않습니다.");
            return; // void도 return 가능. 이건, 메서드를 종료하겠다는 뜻.
        } else {
         // 해당 인덱스의 연락처 정보를 출력
            contacts[index].printContact();
        }
        
    }
    
    private void updateContact() {
        
        // 수정할 인덱스 입력
        System.out.print("수정할 연락처 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
                
        if(index < 0 || index >= count) {
            System.out.println("해당 인덱스에는 수정할 연락처 정보가 없습니다.");
            return;
            } else {
            // 수정 전 연락처 정보 출력
            System.out.print("수정 전>>> ");
            contacts[index].printContact();    
            
            // 수정할 이름/전화번호/이메일 입력
            System.out.print("수정할 이름>> ");
            String name = scanner.nextLine();
            System.out.print("수정할 전화번호>> ");
            String phone = scanner.nextLine();
            System.out.print("수정할 이메일>> ");
            String email = scanner.nextLine();
                    
            // 연락처 정보 업데이트
            contacts[index].setName(name);
            contacts[index].setPhone(phone);
            contacts[index].setEmail(email);
                    
            // 수정 후 연락처 정보 출력
            System.out.print("수정 후>>> ");
            contacts[index].printContact();
            }
        
    
        
        /*
        // 수정할 인덱스 입력
        System.out.print("수정할 연락처 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        // 수정 전 연락처 정보 출력
        System.out.print("수정 전>>> ");
        contacts[index].printContact();    
        
        // 수정할 이름/전화번호/이메일 입력
        System.out.print("수정할 이름>> ");
        String name = scanner.nextLine();
        System.out.print("수정할 전화번호>> ");
        String phone = scanner.nextLine();
        System.out.print("수정할 이메일>> ");
        String email = scanner.nextLine();
        
        // 연락처 정보 업데이트
        contacts[index].setName(name);
        contacts[index].setName(phone);
        contacts[index].setName(email);
        
        // 수정 후 연락처 정보 출력
        System.out.print("수정 후>>> ");
        contacts[index].printContact();
        */
        
    }
    
} // end class
