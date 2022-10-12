package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JList<String> list;
    
    // JList의 원소들을 관리하는 객체
    // JList에 새로운 원소 추가, 원소 삭제, 선택된 원소
    private DefaultListModel<String> listModel;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 378, 443);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding ligature", Font.PLAIN, 16));
        textField.setBounds(12, 10, 224, 57);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        
        btnInput.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
//                String inputText = textField.getText();
//                StringBuilder buffer = new StringBuilder();
//                buffer.append(inputText);
//                
//                listModel.addElement(inputText);
                
                addItemToList();
                
                
            }

            
        });
        
        
        btnInput.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        btnInput.setBounds(248, 10, 105, 57);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        
        btnDelete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemFromList();
                
            }

            
        });
        
        
        btnDelete.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        btnDelete.setBounds(248, 90, 105, 57);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 90, 224, 304);
        frame.getContentPane().add(scrollPane);
        
        list =  new JList<>(); // JList 객체 생성        
        listModel  = new DefaultListModel<>(); // JList의 원소들을 관리하는 ListModel 객체를 생성.
        list.setModel(listModel); // JList에 ListModel을 설정
//                new AbstractListModel()
//        {
//            String[] values = new String[] {"Aaa", "Bbb", "Ccc"};
//            public int getSize() {
//                return values.length;
//            }
//            public Object getElementAt(int index) {
//                return values[index];
//            }
//        });
        list.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        
     
        
    }
    
    private void addItemToList() {
        // JTextField에 입력된 내용을 읽음.
        String input = textField.getText();
        
        // JTextField에 입력된 내용이 없는 경우 getText() 메서드는 빈 문자열("")을 리턴!
        if(input.equals("")) {
            JOptionPane.showMessageDialog(frame,
                    "입력된 내용이 없습니다.",
                    "Warning", // 타이틀임
                    JOptionPane.WARNING_MESSAGE // 경고라는 뜻
                    );
            return; // addItemToList() 메서드를 종료
        }
        
        // DefaultListModel에 원소를 추가하면 자동으로 JList에 원소가 추가됨.
        listModel.addElement(input);
        
        // JTextField를 초기화 - 입력된 내용 지우기.
        textField.setText("");
        
    }
    
    private void deleteItemFromList() {
        
        // JList에서 선택된 원소의 인덱스를 찾음.
        int index = list.getSelectedIndex();
        if(index == -1) { // JList에서 선택된 원소가 없을 떄
            JOptionPane.showMessageDialog(frame,
                    "리스트에서 삭제할 원소를 반드시 선택해 주세요.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        
        // 사용자에게 삭제 여부를 확인
        int confirm = JOptionPane.showInternalConfirmDialog(frame,
                "정말 삭제할까요?",
                "삭제 확인",
                JOptionPane.YES_NO_OPTION
                );
        if(confirm == JOptionPane.YES_OPTION) { // 다이얼로그에서 Yes를 클릭했을 ㄸ
            // DefaultListModel에서 특정 인덱스의 원소를 삭제하면 List에서 그 원소가 자동으로
            listModel.remove(index);
        }
        
        // DefaultListModel에서 원소를 삭제하면 JList에서 그 원소가 자동으로 삭제됨.
        listModel.remove(index);
        
    }
    

    
}
