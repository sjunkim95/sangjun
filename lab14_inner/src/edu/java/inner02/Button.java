package edu.java.inner02;

public class Button {
    // static inner interface
    // 인터페이스는 추상 메서드만 가진다.
    public static interface OnClickListener{
        void onClick(); // 추상 메서드 (public abstract 생략)
        
    }
    
    // field
    private String btnName;
    private OnClickListener listener;
    
    // constructor
    public Button(String btnName) {
        this.btnName = btnName;
    }
    
    // method
    public void setOnClickListener(OnClickListener l) {
        this.listener = l;
    }
    
    public void click() {
        System.out.print(btnName + "버튼:");
        listener.onClick();
        
    }

}
