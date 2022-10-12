package edu.java.array03;

import java.util.Random;
import java.util.Scanner;

public class ArrayMain03 {

    public static void main(String[] args) {
        // Random 객체를 선언, 생성.
        Random random = new Random();
        
        // 정수 10개를 저장할 수 있는 배열(scores)을 선언.
        int[] scores = new int[10];
        int total = 0;
        
        // 배열 scores에 0 이상 10 이하의 정수들 10개를 저장. 인덱스 0 ~ 9까지. 
        for(int i = 0; i < scores.length; i++) {
            int x = random.nextInt(11);
            scores[i] = x;
            System.out.print(scores[i] + " ,");
            total += x;
        }
        
        // 배열 scores에 저장된 모든 점수들의 합계를 계산하고 출력.
        System.out.println();
        System.out.println("총점은: "+total);
        
        // 배열 scores에 저장된 모든 점수들의 평균을 소수점까지 계산해서 출력.
        double average = 0;
        average = (double)total/scores.length;
        System.out.println("평균은: "+average);
        
    }
}
