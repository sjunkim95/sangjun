package edu.java.list02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

    public static void main(String[] args) {
        
        // 1. 정수를 저장하는 LinkedList 변수(numbers) 객체 선언/생성
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // 2. 리스트에 [0, 100) 0 이상 100 미만, 범위의 정수 난수 20개를 저장.
        Random rand = new Random();
        
        
        for(int i = 0; i < 20; i++) {
            numbers.add(rand.nextInt(100));
        }
        
        // 3. 난수가 저장된 리스트를 출력.
        System.out.println("리스트는: " +numbers);
        System.out.println();
        
        //4. 홀수들만 저장하는 LinkedList 변수(odds) 선언, 객체생성.
        LinkedList<Integer> odds = new LinkedList<>();
        
        // 5. 난수들이 저장된 리스트 numbers에서 홀수들만 리스트 odds에 저장.
        for(int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i)%2 == 1 ){
                odds.add(numbers.get(i));
            }
        }
        
        // #5. 강사님 예시
        for (Integer n : numbers) { // numbers의 원소들을 하나씩 반복하면서
            if (n % 2 == 1) { // 그 원소가 홀수이면
                odds.add(n); // 리스트 odds에 추가
            }
        }
        
        
        // 6. 리스트 odds를 출력.
        System.out.println("홀수 리스트: " +odds);
        System.out.println();
        
        //7. 짝수 제곱들을 저장하는 LinkedList 변수(evenSquares)선언, 객체 생성.
        LinkedList<Integer> evenSquares = new LinkedList<>();
        
        // 8. 난수들이 저장된 리스트 numbers에서 짝수들을 찾아서 그 제곱을 evenSquares에 저장.
        for(int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i)%2 == 0 ){
                evenSquares.add(numbers.get(i));
            }
        }
        
        // #8. 강사님 예시, 짝수의 그 제곱!!
        for(int i = 0; i < numbers.size(); i++) {
            Integer x = numbers.get(i);
            if (x % 2 == 0) {
                evenSquares.add(x * x);
            }
        }
        
        // 9. 리스트 evenSquares를 출력
        System.out.println("짝수 리스트 : " + evenSquares);
        System.out.println();

        // Iterator<E>
        Iterator<Integer> itr = evenSquares.iterator();
        while (itr.hasNext()) { // 그 자리에 언소가 있냐없냐, 있으면 true, 없으면 false
            System.out.println(itr.next() + ", ");
        }
        System.out.println();
        
    }

}
