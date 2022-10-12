package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailFrame extends JFrame {
    
    public interface OnBlogUpdateListener{
        void onBlogUpdated();
    }
    
    private OnBlogUpdateListener listener;

    private Component parent;
    private Integer blogNo;
    private BlogDaoImpl dao;
    
    private JPanel contentPane;
    private JTextField textBlogNo;
    private JTextField textField;
    private JTextField textContent;
    private JTextField textAuthor;
    private JTextField txtCreatedDate;
    private JTextField textModifiedDate;

    /**
     * Launch the application.
     */
    public static void newBlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailFrame frame = new BlogDetailFrame(parent, blogNo); // 이 메서드는 이 2줄 실행하는 것.
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param parent 
     */
    public BlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        this.listener = listener; // 블로그 글 업데이트 결과를 통지할 수 있는 메서드를 가지고 있는 객체.
        this.parent = parent; // 부모 컴포넌트 객체 저장.
        this.blogNo = blogNo; // 상세보기/수정할 블로그 글 번호.
        this.dao = BlogDaoImpl.getInstance();
        
        initialize(); // UI 컴포넌트 생성, 초기화.
        
        initializeBlogData(); // JTextField, JTextArea의 내용을 DB에서 검색한 내용으로 채움.
    }
    
    private void initializeBlogData() {
        Blog blog = dao.select(blogNo);
        if (blog != null) {
            textBlogNo.setText(blog.getBlogNo().toString()); 
          //  textTitle.setText(blog.getTitle()); 엥 이게없네
            scrollPane.setViewportView(textContent);
            textContent.setText(blog.getContent());
            textAuthor.setText(blog.getAuthor());
            textCreatedDate.setText(blog.getCreatedDate().toString());
            textModifiedDate.setText(blog.getModifiedDate().toString());
        }
    }
    
    public void initialize() {
        setTitle("블로그 상세 보기");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX(); // 부모 컴포넌트 x 좌표
        int y = parent.getY(); // 부모 컴포넌트 y 좌표
        setBounds(x, y, 400, 936);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBlogNo = new JLabel("번호");
        lblBlogNo.setFont(new Font("D2Coding ligature", Font.PLAIN, 18));
        lblBlogNo.setBounds(12, 10, 360, 44);
        contentPane.add(lblBlogNo);
        
        textBlogNo = new JTextField();
        textBlogNo.setText(blogNo.toString());
        textBlogNo.setEditable(false);
        textBlogNo.setFont(new Font("D2Coding ligature", Font.PLAIN, 19));
        textBlogNo.setBounds(12, 64, 360, 60);
        contentPane.add(textBlogNo);
        textBlogNo.setColumns(10);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding ligature", Font.PLAIN, 19));
        textField.setColumns(10);
        textField.setBounds(12, 184, 360, 60);
        contentPane.add(textField);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding ligature", Font.PLAIN, 19));
        textAuthor.setEditable(false);
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 481, 360, 75);
        contentPane.add(textAuthor);
        
        JLabel lblCreatedDate = new JLabel("작성시간");
        lblCreatedDate.setFont(new Font("D2Coding ligature", Font.PLAIN, 18));
        lblCreatedDate.setBounds(12, 564, 360, 44);
        contentPane.add(lblCreatedDate);
        
        txtCreatedDate = new JTextField();
        txtCreatedDate.setFont(new Font("D2Coding ligature", Font.PLAIN, 19));
        txtCreatedDate.setEditable(false);
        txtCreatedDate.setColumns(10);
        txtCreatedDate.setBounds(12, 618, 360, 60);
        contentPane.add(txtCreatedDate);
        
        JLabel lblModifiedDate = new JLabel("최종 업데이트 시간");
        lblModifiedDate.setFont(new Font("D2Coding ligature", Font.PLAIN, 18));
        lblModifiedDate.setBounds(12, 704, 360, 44);
        contentPane.add(lblModifiedDate);
        
        textModifiedDate = new JTextField();
        textModifiedDate.setFont(new Font("D2Coding ligature", Font.PLAIN, 19));
        textModifiedDate.setEditable(false);
        textModifiedDate.setColumns(10);
        textModifiedDate.setBounds(12, 758, 360, 60);
        contentPane.add(textModifiedDate);
        
        JButton btnUpdate = new JButton("수정완료");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBlog();
            }
        });
        btnUpdate.setBounds(12, 839, 360, 48);
        contentPane.add(btnUpdate);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 308, 360, 93);
        contentPane.add(scrollPane);
        
        textContent = new JTextField();
        textContent.setFont(new Font("D2Coding ligature", Font.PLAIN, 19));
        textContent.setColumns(10);
        scrollPane.setViewportView(textContent);
        
        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setBounds(12, 411, 356, 60);
        contentPane.add(lblAuthor);
        lblAuthor.setFont(new Font("D2Coding ligature", Font.PLAIN, 18));
        
        JLabel lblTitle = new JLabel("제목");
        lblTitle.setBounds(12, 134, 360, 44);
        contentPane.add(lblTitle);
        lblTitle.setFont(new Font("D2Coding ligature", Font.PLAIN, 18));
        
        JLabel lblContent = new JLabel("내용");
        lblContent.setBounds(12, 266, 356, 22);
        contentPane.add(lblContent);
        lblContent.setFont(new Font("D2Coding ligature", Font.PLAIN, 18));
    }

    private void updateBlog() {
        // 수정할 title, content 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        if (title.equals("") || content.equals("")) {
            JOptionPane.showConfirmDialog(this, "제목과 내용은 반드시 입력되어야 합니다.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        // dao.update() 호출.
        Blog blog = new Blog(blogNo, title, content, null, null, null);
        int result = dao.update(blog);
        
        // DetailFrame은 닫음.
        dispose();
        
        // BlogMain에게 업데이트 성공을 알려줌.
        if (result == 1) {
            JOptionPane.showMessageDialog(this, 
                    blogNo + "번 블로그 업데이트 성공.");
            listener.onBlogUpdated();
        } else {
            JOptionPane.showMessageDialog(this, 
                    blogNo + "번 블로그 업데이트 실패.");
        }
        
        
    }
}
