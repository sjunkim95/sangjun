package edu.java.set02;

public class Score {
    // field
    private int java;
    private int web;
    
    // 생성자
    public Score() {}

    public Score(int java, int web) {
        this.java = java;
        this.web = web;
    }

    // getters/setters
    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }
    
    @Override
    public String toString() {
        return String.format("Score(java=%d, web=%d)", java, web);
    }
    
    @Override
    public boolean equals(Object obj) { // equals override는, 개발자가 자기 클래스가 같은지 다른지를 자기가 정의하겠다!!!
        // id만 비교하든, pw만 비교하든.
        if(obj instanceof Score) { //obj 변수가 Score 타입의 인스턴스 변수이기 때문에
            Score s = (Score) obj; // obj를 Score타입으로 바꿔라 가능함
            return(this.java == s.java) && (this.web == s.web);
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return Integer.valueOf(java).hashCode() + Integer.valueOf(web);
    }

}
