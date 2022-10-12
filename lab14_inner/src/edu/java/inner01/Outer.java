package edu.java.inner01;

public class Outer {
    // field
    private int x;
    private int y;
    
    // constructor
    public Outer(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    // method
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Outer(x=%d, y=%d)", x, y);
    }
    
    // non-static member inner class
    class Inner {
        // field
        private int z;
        private int y = 1;
        
        // constructor
        public Inner(int z) {
            this.z = z;
            
        }
        
        // method
        public void printInfo() {
            System.out.println("--- Inner Class ---");
            // 내부 클래스에서는 외부 클래스의 멤버(변수, 메서드)를 사용할 수 있음!
            System.out.println("x = " + x); // private, 바깥에서 사용하지, 자기 클래스 안에서는 마음껏 사용 가능.
            System.out.println("y = " + y);
            System.out.println("z = " + z);
            // 내부 클래스의 멤버(변수, 메서드)의 이름과 외부 클래스의 멤버 이름이 같은 경우,
            // 외부 클래스의 멤버를 접근 하는 방법: OuterClassName.this.memberName
            System.out.println("Outer y = " + Outer.this.y);
            // 외부, 내부 클래스에 같은 이름의 변수가 있을경우. 외부 클래스 멤버 호출 방법.
        }
    }
    

}
