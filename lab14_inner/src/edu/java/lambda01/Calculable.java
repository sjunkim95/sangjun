package edu.java.lambda01;

@FunctionalInterface // 함수형 인터페이스입니다, 라고 선언하는것. 메서드가 하나만 있어야함, 이 annotation이 있을 시.
public interface Calculable {
    
    double calculate(double x, double y);
    
}
