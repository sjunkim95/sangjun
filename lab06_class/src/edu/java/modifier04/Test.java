package edu.java.modifier04;

public class Test {
    private int a;
    private double b;
    private boolean c;
    private String d;
    
    
    // 마우스 오른쪽 클릭 -> Source + Generate Constructor using Fields
    public Test(int a, double b, boolean c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // 이런식으로 체크박스에서 deselct 하면 만들어진다.
    public Test(int a, double b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    
    // 마우스 오른쪽 클릭 -> Source -> Generate Getters/Setters
    public int getA() {
        return a;
    }

    public void setA(int a) { // void라는것은 리턴하지 않는다.
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    

    
}
