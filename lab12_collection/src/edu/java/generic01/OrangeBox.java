package edu.java.generic01;

public class OrangeBox {
    private Orange orange; 
    
    public void put(Orange orange) {
        this.orange = orange;
    }
    
    public Orange get() {
        return orange;
    }
}

class Orange { // 오랜지라는 객체가 있어야, 오렌지라는 객체가 있는 상자를 위에서 만들 수 있다.
    private int sugar;
    
    public Orange(int sugar) {
        this.sugar = sugar;
    }
    
    public int getSugar() {
        return sugar;
    }
    
}
