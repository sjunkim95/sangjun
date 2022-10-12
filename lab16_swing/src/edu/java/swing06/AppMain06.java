package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain06 {

    private JFrame frame;
    private JButton btnOptionDlg; // 필드 변수로 선언되었음
    private JButton btnInputDlg;
    private JButton btnInputDlg_1;
    private JButton btnCustomFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 744, 677);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [닫기] 버튼 클릭 동작 -> 프로그램 종료
        frame.getContentPane().setLayout(null);
        
        JButton btnCustomDlg = new JButton("Custom Dialog");
        btnCustomDlg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트
                        "안녕하세요?", // 다이얼로그에 표시될 메시지
                        "메시지", // 다이얼로그의 타이틀
                        JOptionPane.INFORMATION_MESSAGE, // 메시지 타입
                        null // 아이콘 이미지
                );  
            }
        });
    
        btnCustomDlg.setBounds(12, 369, 513, 88);
        btnCustomDlg.setFont(new Font("D2Coding ligature", Font.PLAIN, 35));
        frame.getContentPane().add(btnCustomDlg);
        
        JButton btnConfirmDialog = new JButton("Confirm Dialog");
        btnConfirmDialog.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               // int result = JOptionPane.showConfirmDialog(frame, "삭제할까요?");
                int result = JOptionPane.showConfirmDialog(
                        frame, // 다이얼로그의 부모 컴포넌트
                        "선택한 파일을 삭제할까요?",  // 다이얼로그의 메시지
                        "삭제 확인",  // 다이얼로그의 타이틀(제목 표시줄)
                        JOptionPane.YES_NO_OPTION,  // 확인 옵션(YES-NO, YES-NO-CANCEL, ..)
                        JOptionPane.QUESTION_MESSAGE,  // 메시지 타입(-> 아이콘을 자동으로 설정)
                        null // 아이콘
                ); 
                // showConfirmDialog의 리터낪:
                // YES = 0, NO = 1, CANCEL = 2, X(종료) = -1
                btnConfirmDialog.setText("Confirm= " + result);
            }
        });
        
        
        btnConfirmDialog.setFont(new Font("D2Coding ligature", Font.PLAIN, 35));
        btnConfirmDialog.setBounds(12, 97, 513, 88);
        frame.getContentPane().add(btnConfirmDialog);
        
        btnOptionDlg = new JButton("Option Dialog");
        btnOptionDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"아니요", "어려워요", "재밌어요"};
                int result = JOptionPane.showOptionDialog(
                        frame, // 다이얼로그의 부모 컴포넌트
                        "Swing GUI 재미있나요?", // 다이얼로그의 메시지
                        "확인", // 다이얼로그의 타이틀
                        JOptionPane.YES_NO_CANCEL_OPTION, // 다이얼로그의 옵션 타입(Yes-No, Yes-No-Cancel, ...)
                        JOptionPane.QUESTION_MESSAGE,  // 메시지 타입(QUESTION, INFORMATION, ...)
                        null, // 아이콘
                        options, // 옵션 버튼에서 사용할 문자열 배열
                        options[2]// 다이얼로그가 실행될 때 포커스를 받는 버튼 옵션
                ); 
                btnOptionDlg.setText("result= " + result);
            }
        });
        btnOptionDlg.setFont(new Font("D2Coding ligature", Font.PLAIN, 35));
        btnOptionDlg.setBounds(12, 10, 513, 88);
        frame.getContentPane().add(btnOptionDlg);
        
        btnInputDlg = new JButton("Input Dialog");
        btnInputDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //String input = JOptionPane.showInputDialog("이름?");
                Object[] selectionValues = {"10대", "20대", "30대", "40대"};
                Object input = JOptionPane.showInputDialog(
                        frame, // 부모 컴포넌트
                        "나이?", // 메시지
                        "확인", // 타이틀
                        JOptionPane.QUESTION_MESSAGE,// 메시지 타입
                        null, // 아이콘
                        selectionValues, // 선택 값들의 배열
                        selectionValues[1] // 선택 값들 중에서 포커스를 받는 컴포넌트
                );
               // -> OK 버튼을 클릭하면 입력한 내용이 리턴, Cancel을 클릭하면 빈 문자열을 리턴.
               btnInputDlg.setText("입력 = " + input);
            }
        });
        btnInputDlg.setFont(new Font("D2Coding ligature", Font.PLAIN, 35));
        btnInputDlg.setBounds(12, 195, 513, 88);
        frame.getContentPane().add(btnInputDlg);
        
        btnInputDlg_1 = new JButton("Input Dialoasdag");
        btnInputDlg_1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
       //         MyCustomDialog.showMyCustomDialog(null);
                
            }
        });
        btnInputDlg_1.setFont(new Font("D2Coding ligature", Font.PLAIN, 35));
        btnInputDlg_1.setBounds(12, 296, 513, 88);
        frame.getContentPane().add(btnInputDlg_1);
        
        btnCustomFrame = new JButton("Custom Frame");
        // 익명클래스에서 showMyCustomFrame() 불러야한다.
        btnCustomFrame.setFont(new Font("D2Coding ligature", Font.PLAIN, 35));
        btnCustomFrame.setBounds(12, 472, 513, 88);
        frame.getContentPane().add(btnCustomFrame);
        
    }
}
