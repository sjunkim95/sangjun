package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AppMain04 {

    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        frame.setBounds(100, 100, 495, 345);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNum1 = new JLabel("num1");
        lblNum1.setOpaque(true);
        lblNum1.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        lblNum1.setBounds(12, 10, 105, 44);
        frame.getContentPane().add(lblNum1);
        
        JLabel lblNum2 = new JLabel("num2");
        lblNum2.setOpaque(true);
        lblNum2.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        lblNum2.setBounds(12, 64, 105, 44);
        frame.getContentPane().add(lblNum2);
        
        textField1 = new JTextField();
        textField1.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        textField1.setBounds(129, 10, 177, 44);
        frame.getContentPane().add(textField1);
        textField1.setColumns(10);
        
        textField2 = new JTextField();
        textField2.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        textField2.setColumns(10);
        textField2.setBounds(129, 64, 177, 44);
        frame.getContentPane().add(textField2);
        
        
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        textArea.setBounds(12, 179, 455, 117);
        frame.getContentPane().add(textArea);
        
        JButton btnAdd = new JButton("+");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 파라미터 ActionEvent e: 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한 정보를 가지고 있는 객체.
                // 
            //    performCalculation(e);
                String num1 = textField1.getText();
                String num2 = textField2.getText();
                double number1 = Integer.parseInt(num1);
                double number2 = Integer.parseInt(num2);
                double result = (number1 + number2);
                StringBuilder buffer = new StringBuilder();
                buffer.append(number1)
                .append(" + ")
                .append(number2)
                .append(" = ")
                .append(result);
                
                textArea.setText(buffer.toString()); // object를 출력하기 위해서는 toString()
            }
        });
        btnAdd.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        btnAdd.setBounds(12, 125, 58, 44);
        frame.getContentPane().add(btnAdd);
        
        JButton btnSubtract = new JButton("-");
        //
        btnSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField1.getText();
                String num2 = textField2.getText();
                double number1 = Integer.parseInt(num1);
                double number2 = Integer.parseInt(num2);
                double result = (number1 - number2);
                StringBuilder buffer = new StringBuilder();
                buffer.append(number1)
                .append(" - ")
                .append(number2)
                .append(" = ")
                .append(result);
                
                textArea.setText(buffer.toString()); // object를 출력하기 위해서는 toString()
            }
        });
        btnSubtract.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        btnSubtract.setBounds(95, 125, 58, 44);
        frame.getContentPane().add(btnSubtract);
        
        JButton btnMultiply = new JButton("X");
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField1.getText();
                String num2 = textField2.getText();
                double number1 = Integer.parseInt(num1);
                double number2 = Integer.parseInt(num2);
                double result = (number1 * number2);
                StringBuilder buffer = new StringBuilder();
                buffer.append(number1)
                .append(" X ")
                .append(number2)
                .append(" = ")
                .append(result);
                
                textArea.setText(buffer.toString()); // object를 출력하기 위해서는 toString()
            }
        });
        btnMultiply.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
        btnMultiply.setBounds(178, 125, 58, 44);
        frame.getContentPane().add(btnMultiply);
        
        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = textField1.getText();
                String num2 = textField2.getText();
                double number1 = Integer.parseInt(num1);
                double number2 = Integer.parseInt(num2);
                double result = (number1 / number2);
                StringBuilder buffer = new StringBuilder();
                buffer.append(number1)
                .append(" / ")
                .append(number2)
                .append(" = ")
                .append(result);
                
                textArea.setText(buffer.toString()); // object를 출력하기 위해서는 toString()
            }
        });
        btnDivide.setFont(new Font("D2Coding ligature", Font.PLAIN, 30)); 
        btnDivide.setBounds(248, 125, 58, 44);
        frame.getContentPane().add(btnDivide);
        
   //     private void performCalculation(ActionEvent e) {
     //       // JTexTfield에 입력된 문자열을 읽고, double 타입으로 변환
     //       String s1 = text 
     //   }
    }
    

}
