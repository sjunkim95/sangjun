package edu.java.lambda01;

// 인터페이스를 구현하는 (외부) 클래스, 즉 별도의 파일로 클래스를 하나 만들었다. (내부 클래스가 없음)?
public class Adder implements Calculable {

    @Override
    public double calculate(double x, double y) {
        return x + y;
    }

}
