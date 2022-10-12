package edu.java.inheritance04;

public class InheritanceMain04 {

    public static void main(String[] args) {
        // 다형성과 타입 강제 변환(casting) & instanceof 연산자 
        Parent ch1 = new Child();
        
        ch1.testParent(); //parent 메서드만 보이고 child 메서드는 안보인다, 이게 다형성의 단점.
        // ch1 변수는 Parent로 선언되어 있기 때문에, Parent의 메서드만 보임.
        // ch1은 실제로 Child 타입의 변수이기 때문에 Child의 메서드도 사용할 수 있어야 
        
        System.out.println("-----");
        
        ((Child)ch1).testChild();
        // 이런식으로 하면 Child의 메서드도 보임
        
        System.out.println("-----");
        
        Parent ch2 = new AnotherChild();
        // ((Child)ch2).testChild(); -> 에러가 난다.
        
        // AnotherChild와 Child 클래스 서로 casting될 수 없는 클래스이기 때문에
        // 문법적으로는 가능하나 실행할 때 에러가 발생함.
        
        // 변수 instanceof 클래스 이름:
        // 변수가 클래스 타입의 인스턴스이면 true, 그렇지 않으면 false.
        
        if(ch2 instanceof Child) {
            ((Child)ch2).testChild();
        } else if(ch2 instanceof AnotherChild) {
            ((AnotherChild)ch2).testAnotherChild();
        } else {
            ch2.testParent(); // 이것도 맞는 코드, 하지만 위에서 실행되기에 실행되지 않음.
        }
            
        // final 메서드: override할 수 없는 메서드.
        // final 클래스: 상속받을 수 없는 클래스.
        // class TestString extends String{}
    }

}


class Parent{
    public void testParent() {
        System.out.println("I'm your father!");
    }
}

class Child extends Parent{
    public void testChild() {
        System.out.println("child...");
    }
}

class AnotherChild extends Parent{
    public void testAnotherChild() {
        System.out.println("another child...");
    }
}
