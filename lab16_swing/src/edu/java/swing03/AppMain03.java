package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AppMain03 {

    private JFrame frame;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 796, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblname = new JLabel("이름");
        lblname.setFont(new Font("D2Coding ligature", Font.PLAIN, 40));
        lblname.setHorizontalAlignment(SwingConstants.CENTER);
        lblname.setBounds(27, 30, 154, 56);
        frame.getContentPane().add(lblname);
        
        JLabel lblphone = new JLabel("전화번호");
        lblphone.setFont(new Font("D2Coding ligature", Font.PLAIN, 40));
        lblphone.setHorizontalAlignment(SwingConstants.CENTER);
        lblphone.setBounds(27, 96, 163, 56);
        frame.getContentPane().add(lblphone);
        
        JLabel lblemail = new JLabel("이메일");
        lblemail.setFont(new Font("D2Coding ligature", Font.PLAIN, 40));
        lblemail.setHorizontalAlignment(SwingConstants.CENTER);
        lblemail.setBounds(27, 162, 154, 56);
        frame.getContentPane().add(lblemail);
        
        textName = new JTextField();
        textName.setBounds(209, 30, 378, 56);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(209, 96, 378, 56);
        frame.getContentPane().add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(209, 161, 378, 57);
        frame.getContentPane().add(textEmail);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(27, 247, 741, 128);
        frame.getContentPane().add(textArea);
        
        JButton btnInput = new JButton("입력");
        btnInput.setFont(new Font("D2Coding ligature", Font.PLAIN, 40));
        btnInput.setBounds(605, 162, 163, 56);
        frame.getContentPane().add(btnInput);
        
        // 버튼의 이벤트 핸들러를 등록
        // 이벤트 핸들러: 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
        btnInput.addActionListener((e) -> {
            // JTextField의 입력된 내용을 읽음.
            String name = textName.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            
            // JTextArea에 출력할 문자열 만들기
            StringBuilder buffer = new StringBuilder();
            buffer.append("이름: ").append(name).append("\n")
            .append("전화번호: ").append(phone).append("\n")
            .append("이메일: ").append(email).append("\n");
            
            // 만들어진 문자열을 JTextAread에 출력
            textArea.setText(buffer.toString());
            
        }); // 밑에 처럼 싫다하면

//        btnInput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
        btnInput.setBounds(605, 162, 163, 56);
        
    }
    // "입력" 버튼을 클릭했을 때 실행할 내용. 
    private void printInfo() {
        // 이 부분은 github 참고.
    }
    
}
