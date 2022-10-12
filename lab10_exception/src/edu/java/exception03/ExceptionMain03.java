package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
    
    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ExceptionMain03 app = new ExceptionMain03();
        
        int x = app.inputInteger();
        System.out.println("x = " + x);
        
    }
    
    private int inputInteger() {
        // TODO: Scanner를 사용해서 입력받은 정수를 리턴.
        // Integer.parseInt(), scanner.nextLine() 사용.
        // NumberFormatException을 처리.

        boolean run = true;
        
        int x = 0;
         
        while(run) { // 여기서 run 변수 사용 안하고 true로 놓는다면, int x선언도 while문 안에서 가능.

            try {
                System.out.print("정수 입력>> ");
                x = Integer.parseInt(scanner.nextLine());
                break; // 반복문
            } catch(NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        
        } // end while
        
        return x;
    }

}
