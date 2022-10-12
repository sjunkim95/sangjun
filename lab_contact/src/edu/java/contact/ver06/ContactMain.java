package edu.java.contact.ver06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import static edu.java.contact.ver06.Contact.Entity.*;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver05.ContactCreateFrame;
import edu.java.contact.ver05.ContactMain05;
import edu.java.contact.ver05.ContactUpdateFrame;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ContactMain {
    
    private static final String[] COLUMN_NAMES = {
            COL_CID, COL_NAME, COL_PHONE, COL_EMAIL
    };


    private JFrame frame;
    private ContactDaoImpl dao;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain window = new ContactMain();
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
    public ContactMain() {
        initialize();
        dao = ContactDaoImpl.getInstance();
        initializeTable();
        
    }

    private void initializeTable() {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
        List<Contact> list = dao.read();
        for (Contact b : list) {
            Object[] row = {
                    b.getCid(), b.getName(), b.getPhone(), b.getEmail()
            };
            model.addRow(row); // 테이블 모델에 행(row) 데이터로 추가.
        }
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Contact Ver 0.6");
        frame.setBounds(100, 100, 615, 815);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
                //ContactCreateFrame.newContactCreateFrame(frame, ContactMain.this);
            }
        });
        btnCreate.setFont(new Font("D2Coding ligature", Font.PLAIN, 21));
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 수정");
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUpdateFrame();
            }
        });
        btnUpdate.setFont(new Font("D2Coding ligature", Font.PLAIN, 21));
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBlog();
            }
        });
        btnDelete.setFont(new Font("D2Coding ligature", Font.PLAIN, 21));
        buttonPanel.add(btnDelete);
        
        JButton btnSearch = new JButton("연락처 검색");
        btnSearch.setFont(new Font("D2Coding ligature", Font.PLAIN, 21));
        buttonPanel.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                    "ID", "Name", "Phone", "e-mail"
            }
        ));
        table.setFont(new Font("D2Coding ligature", Font.PLAIN, 21));
        scrollPane.setViewportView(table);
    }

    private void deleteBlog() {
        int row = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스
        if (row == -1) {
            JOptionPane.showMessageDialog(frame, // parentComponenet
                    "삭제하려는 행을 먼저 선택하세요.", // message
                    "Error", // title
                    JOptionPane.ERROR_MESSAGE);      
            return;
        }
        
        Integer cid = (Integer) model.getValueAt(row, 0);
        System.out.println("CID = " + cid);
        
        int confirm = JOptionPane.showConfirmDialog(frame, // parentComponent
                cid + "번 블로그 글을 정말 삭제할까요?", // message
                "삭제 확인", // title
                JOptionPane.YES_NO_OPTION); // 확인 버튼 종류
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Dao 객체의 delete 메서드를 사용해서 DB에서 삭제.
            int result = dao.delete(cid);
            if (result == 1) {
                JOptionPane.showMessageDialog(frame, cid + "번 블로그 글 삭제 성공");
                initializeTable(); // 테이블 갱신
            } else {
                JOptionPane.showMessageDialog(frame, 
                        "블로그 글 삭제 실패", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
     
        
    }

    private void showUpdateFrame() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(frame,
                    "수정할 행을 먼저 선택하세요", // 메시지
                    "Warning", // 타이틀
                    JOptionPane.WARNING_MESSAGE); // 메시지 타입
            return;
        }
    //    ContactUpdateFrame.newContactUpdateFrame(frame, row, ContactMain.this);
    }

}
