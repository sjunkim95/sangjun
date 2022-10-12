package edu.java.swing10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AppMain10 {

    private JFrame frame;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 368, 502);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        /*
         * btnDelete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemFromList();
                
            }

            
        });
        
         */
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
                
            }
        });
        btnDelete.setBounds(192, 217, 97, 57);
        frame.getContentPane().add(btnDelete);
        
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScore();   
            }
        });
        btnInput.setBounds(12, 217, 97, 57);
        frame.getContentPane().add(btnInput);
        
        
        textKorean = new JTextField();
        textKorean.setBounds(161, 10, 149, 51);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        JLabel lblKorean = new JLabel("국어");
        lblKorean.setBounds(27, 10, 107, 51);
        frame.getContentPane().add(lblKorean);
        
        JLabel lblEnglish = new JLabel("국어");
        lblEnglish.setBounds(27, 74, 107, 51);
        frame.getContentPane().add(lblEnglish);
        
        JLabel lblMath = new JLabel("국어");
        lblMath.setBounds(27, 143, 107, 51);
        frame.getContentPane().add(lblMath);
        
        textEnglish = new JTextField();
        textEnglish.setColumns(10);
        textEnglish.setBounds(161, 74, 149, 51);
        frame.getContentPane().add(textEnglish);
        
        textMath = new JTextField();
        textMath.setColumns(10);
        textMath.setBounds(161, 143, 149, 51);
        frame.getContentPane().add(textMath);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
            },
            new String[] {
                "\uAD6D\uC5B4", "\uC601\uC5B4", "\uC218\uD559"
            }
        ));
        table.setBounds(27, 302, 288, 16);
        frame.getContentPane().add(table);
    }
    
    private void inputScore() {
        // 3개의 JTextField에서 읽은 문자열을 정수(int)로 변환
        int korean = 0;
        int english = 0;
        int math = 0;
        
        try {
            
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
            
        } catch(NumberFormatException e) {
            
            JOptionPane.showMessageDialog(frame,
                    "입력값은 반드시 정수여야 합니다.",  // 에러 메시지
                    "입력 오류", // 타이틀 
                    JOptionPane.ERROR_MESSAGE); // 메시지 타입
            
            return; // 에러나면 메시지만 보내주고 아무 일도 일어나지 않음.
                    
        } finally {
            clearAllTextFields();
        }
        
        // 입력값들을 사용해서 Score 객체 생성
        Score score = new Score(korean, english, math);
        
        // 테이블의 행(row)에 추가할 데이터를 1차원 배열로 만듦.
        Object[] rowData = {
               score.getKorean(),
               score.getEnligsh(),
               score.getMath(),
               score.sum(),
               score.average(),
                
        };
        
        // row data를 테이블 모델에 추가.
    //    model.addrow(rowData);
        
    }
    
    private void clearAllTextFields() {
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
    
    private void deleteRow() {
        // 테이블에서 삭제하기 위해서 선택된 행(row) 인덱스를 찾음.
        int index = table.getSelectedRow();
        
        if(index == -1) { // 테이블에서 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(frame,
                    "삭제할 행을 먼저 선택하세요.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
            
        } 
        // 행 인덱스를 사용해서 테이블 모델에서 행을 삭제.
        int confirm = JOptionPane.showConfirmDialog(frame,
                index + "번째 행을 정말 삭제할까요?",
                "삭제 확인",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) { // 다이얼로
         //   model.removeRow(index);
        }
        
    }
    
}
