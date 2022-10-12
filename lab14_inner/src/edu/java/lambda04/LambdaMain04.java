package edu.java.lambda04;

import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

    public static void main(String[] args) {
        // Employee를 원소로 갖는 리스트를 선언, 생성
        List<Object> employees = Arrays.asList(
            new Employee(100, "이존규", "개발자", "개발1팀", 300),
            new Employee(101, "김지훈", "개발자", "개발2팀", 301),
            new Employee(201, "김용훈", "개발자", "개발2팀", 302),
            new Employee(202, "김가영", "디자이너", "개발1팀", 303),
            new Employee(301, "최은정", "디자이너", "개발2팀", 400),
            new Employee(500, "추지훈", "부사장", "인사팀", 1000)
            
        );
        
        // Ex 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        
        // for-each 문장
//        for (Employee e : employees) {
//            System.out.println(e);

//        System.out.println();
//        employees.stream().forEach(x -> {System.out::println(x); );
        
        // Ex 2. 직무가 "개발자"인 직원들의 급여 합계를 출력.
        int sum = 0;
  //      for(Employee e : employees) {
    //        if(e.getJob().equals("개발자")) {
      //          sum += e.getSalary();
      //      }
     //   }
      //  System.out.println("sum = " + sum);
        
        
        // Ex 3. 부서가 "개발2팀"인 직원들의 급여 평균을 출력.
        // Ex 4. 급여가 400 이상인 직원들의 정보를 한 줄씩 출력.
        
 //       System.out.println(employees.get(job));
        
        
    }

}
