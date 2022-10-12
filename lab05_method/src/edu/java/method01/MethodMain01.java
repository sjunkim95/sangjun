package edu.java.method01;

// 메서드(method): 클래스 안에서 정의하는 함수(function, 기능).
// 프로그램에서 반복되는 기능을 코드 블록으로 작성.
// 자바는 클래스 안에서만 함수를 작성할 수 있음. 클래스 밖에서는 함수를 작성할 수 없음.
// 자바는 메서드 안에서 메서드를 정의할 수 없음!

// argument: 인수. 메서드를 호출하는 곳에서 메서드에게 전달하는 값.
// parameter: 매개변수. 인자. argument를 저장하는 메서드의 지역변수.
// return value: 반환값. 메서드가 기능을 모두 수행한 후에 메서드를 호출한 곳으로 반환하는 값.
// 메서드는 리턴값이 있을 수도 있고, 없을 수도 있음.

// 메서드 정의(선언) 방법:
// [수식어] 리턴타입 메서드 이름([파라미터 선언, ...]){...}
// void: 함수가 리턴하는 값이 없을 때 사용하는 리턴타입.


public class MethodMain01 {
    // main 메서드 - 프로그램 시작점.
    
    public static void main(String[] args) {
        
        System.out.println("1"); // println() 메서드 호출
        // 여기서 () 안에 있는 "1"이 arguement다.
        
        newLine(); //newLine() 메서드 호출(사용)
        
        System.out.println("2");

        newLines(2); //newLines() 메서드를 호출하면서 3을 argument로 전달.
        
        System.out.println("3");
        
    } //end main
    
    // 함수 정의(선언)
    /**
     * 
     * 빈 줄 n개를 출력.
     * 
     * 콘솔에 빈 줄 하나를 출력.
     * @param <- 도큐멘테이션 코멘트 . n출력할 빈 줄의 개수. 양의 정수   
     * 
     */
    
    //
    
    public static void newLine() {
        System.out.println();
    }
    
    public static void newLines(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }
    
} //end class
