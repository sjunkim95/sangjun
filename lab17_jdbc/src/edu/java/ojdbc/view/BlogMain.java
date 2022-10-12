package edu.java.ojdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.view.BlogCreateFrame.OnBlogInsertListener;
import edu.java.ojdbc.view.BlogDetailFrame.OnBlogUpdateListener;

import static edu.java.ojdbc.model.Blog.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogMain implements OnBlogInsertListener, OnBlogUpdateListener {
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = {
            COL_BLOG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE
    };
    
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    
    private BlogDaoImpl dao;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() {
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = BlogDaoImpl.getInstance();
        initializeTable(); // 메인 화면에서의 JTable 데이터 초기화
    }

    private void initializeTable() {
        // 데이터는 없는, 컬럼 이름들만 설정된 테이블 모델 객체를 생성. -> 데이터 초기화.
        model = new DefaultTableModel(null, COLUMN_NAMES);
        // 테이블에 모들 객체를 설정.
        table.setModel(model);

        // DB에서 데이터를 검색. 
        List<Blog> list = dao.select();
        for (Blog b : list) {
            Object[] row = {
                    b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate()
            };
            model.addRow(row); // 테이블 모델에 행(row) 데이터로 추가.
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setTitle("블로그 메인");
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 글 작성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 새 블로그 글 작성 Frame 만들기.
                BlogCreateFrame.newBlogCreateFrame(frame, BlogMain.this);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnCreate);
        
        JButton btnRead = new JButton("상세보기");
        
        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailFrame();
            }
        });
        btnRead.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnRead);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBlog();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }
    
    private void showDetailFrame() {
        int row = table.getSelectedRow();
        if(row == -1) { // 선택되지 않았다는 뜻
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "테이블의 행을 먼저 선택하세요.", // message
                    "Error", // title
                    JOptionPane.ERROR_MESSAGE); // messageType
            
            return;
        }
        
        Integer blogNo = (Integer) model.getValueAt(row, 0);
        System.out.println("blogNo = " + blogNo);
        
        BlogDetailFrame.newBlogDetailFrame(frame, blogNo, BlogMain.this); // BlogMain.this = this
        
    }
    
    private void deleteBlog() {
        int row = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스
        
        if (row == -1) { // JTable에서 선택된 행이 없는 경우,
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "삭제하려는 행을 먼저 선택하세요.", // message
                    "Error",  // title
                    JOptionPane.ERROR_MESSAGE); // messageType
            return; // 메서드 종료
        }
        
        // 선택된 행에서 인덱스 0번 컬럼의 값(BLOG_NO)을 읽음.
        Integer blogNo = (Integer)model.getValueAt(row, 0); // 인자에 row와 컬럼번호, 컬럼은 0,1,2,3,4 순이니까..
        System.out.println("blogNo = " + blogNo); // 컬럼 넘버를 읽어줌, 콘솔에 출력해주는것.
        
        int confirm = JOptionPane.showConfirmDialog(frame, // parentComponent
                blogNo + "번 블로그 글을 정말 삭제할까요?", // message
                "삭제 확인", // title
                JOptionPane.YES_NO_OPTION); // 확인 버튼 종류
        if (confirm == JOptionPane.YES_NO_OPTION){
            // Dao 객체의 delete 메서드를 사용해서 DB에서 삭제.
            int result = dao.delete(blogNo);
            if (result == 1) {
                JOptionPane.showMessageDialog(frame, blogNo + " 블로그 글 삭제 성공");
                initializeTable(); // 테이블 갱신
            } else {
                JOptionPane.showMessageDialog(frame, 
                        "블로그 글 삭제 실패", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override // BlogCreateFrame.OnBlogInsertListener 인터페이스의 메서드 구현.
    public void onBlogInserted() {
        initializeTable();
    }
    
    @Override // BlogDetailFrame.OnBlogUpdateListener 인터페이스 메서드 구현
    public void onBlogUpdated() {
        initializeTable();
        
    }

}