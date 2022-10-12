package edu.java.swing10;

// MVC에서 Model 클래스 - 데이터를 정의하는 클래스. VO (Value Object, 값들을 정의하는 객체)

public class Score {
    
    // field
    private int korean;
    private int english;
    private int math;
    
    // constructor
    public Score() {}

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    // getters
    public int getKorean() {
        return korean;
    }

    public int getEnligsh() {
        return english;
    }

    public int getMath() {
        return math;
    }
    
    // 총점 리턴
    public int sum() {
        return korean + english + math;
    }
    
    
    // 평균(double) 리턴
    public double average() {
        return (double)sum() / 3;
    }
    
    @Override
    public String toString() {
        return String.format("Score(korean=%d, english=%d, math=%d, sum=%d, avg=%.2f)",
                korean, english, math, sum(), average());
    }
    

}
