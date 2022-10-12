package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용.
        // [0, 10) 범위의 정수 난수 5개를 저장. 
        // Set의 내용을 출력.
        // 주의, Set은 중복이 불가능, 반복문 5개 돌려서만은 안된다.
        HashSet<Integer> set = new HashSet<>();
        Random rand = new Random();
        
        for(int i = 0; set.size() < 5 ; i++) {
            set.add(rand.nextInt(10));
        }
        
        System.out.println("저장된 난수는: " +set);
        
        // 강사님 예시
        HashSet<Integer> numbers = new HashSet<>();
        while(true) {
            int r = rand.nextInt(10);
            System.out.println("r + "+r);
            
            numbers.add(r);
            System.out.println("set = " +numbers);
            if(numbers.size()==5) {
                break;
            }
        }
        
    }

}
