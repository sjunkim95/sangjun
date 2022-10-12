package edu.java.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class AppMain09 {

    private JFrame frame;
    private JTable table;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain09 window = new AppMain09();
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
    public AppMain09() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 745, 468);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        // 테이블 데이터 - 2차원 배열
        Object[][] data = {
                {1, "맥북 프로", 400, "IT", 1},
                {2, "갤 폴드", 200, "가전", 10},
                {3, "박카스", 10, "식품", 100}
                
        };
        
        // 테이블 칼럼 이름 - 1차원 배열
        Object[] colNmaes = {"상품 번호", "상품 이름", "가격", "카테고리", "재고 수량"};

        
        
        // 테이블 데이터를 관리하는 DefaultTableModel 객체를 생성.
        DefaultTableModel model = new DefaultTableModel(data, colNmaes);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(320, 254, 97, 23);
        frame.getContentPane().add(btnNewButton_1);
        
        table = new JTable(); // JTable 생성
        table.setBounds(0, 21, 715, 48);
        frame.getContentPane().add(table);
        
        // 테이블의 데이터를 관리(추가, 삭제, ...) 하는 TableModel을 JTable에 세팅(설정).
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"1", "\uB9E5\uBD81\uD504\uB85C", "400", "IT", "1"},
                {"2", "\uAC24\uB7ED\uC2DC \uD3F4\uB4DC", "200", "\uAC00\uC804 ", "10"},
                {"3", "\uBC14\uCE74\uC2A4", "30", "\uC74C\uB8CC ", null},
            },
            new String[] {
                "\uC0C1\uD488 \uBC88\uD638", "\uC0C1\uD488 \uC774\uB984", "\uC0C1\uD488 \uAC00\uACA9", "\uCE74\uD14C\uACE0\uB9AC", "\uC7AC\uACE0 \uC218\uB7C9"
            }
        ));
        
        btnNewButton = new JButton("New button");
        btnNewButton.setBounds(52, 122, 106, 23);
        frame.getContentPane().add(btnNewButton);
    }
}
