package edu.java.contact.ver05;
// 우클릭 + openwith + WindowBuilderEditor
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ContactUpdateFrame extends JFrame {

    @FunctionalInterface
    public interface ContactUpdateListener{
        void contactUpdateNotify();
    }
    
    private ContactUpdateListener listener;
    private Component parent; // 업데이트 창을 실행시킨 부모 컴포넌트
    private int index; // 수정할 연락처의 인덱스
    private ContactDaoImpl dao; // 연락처 검색(read), 업데이트(update), ...
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textPhone;
    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) { // 프로그램에서는 main 오직 하나, 이름 바꿔주자. // appmain10 보고 argument 수정함
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, listener); // 전달 받은 parent 여기로 넘겼다.
                frame.setVisible(true);
                 
            }
        });
    }

    /**
     * Create the frame.
     */
    
    public ContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) { // 이러면 main과 똑같은 구조 아니냐. // 20줄에서 받은거 수정해주기위해서 여기에도 argument에 추가.
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.index = index; // 수정할 연락처의 인덱스를 멤버로 저장.
        this.dao = ContactDaoImpl.getInstance(); // DAO 싱글턴 객체를 가져옴.
        this.listener = listener; // 업데이트 창을 만든 메인 창의 주소를 저장.
        
        initialize(); // UI 컴포넌트들을 생성, 초기화.
        
        initializeContactInfo(); // 수정하려는 인덱스의 연락처 정보를 JTextField에 채움.
    }
    
    void initializeContactInfo() {
        
        Contact contact = dao.read(index); // 수정하려는 연락처 정보
        
        // 각 JTextField에 연락처 정보를 씀.
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
    }
    
    /**
     * Initialize UI components.
     */
    public void initialize() {
        setTitle("연락처 보기/업데이트");
        // 닫기 버튼을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 메인 창이니까 EXIT 대신에 DISPOSE
        
        int x = parent.getX(); // 부모 컴포넌트의 x좌표
        int y = parent.getY(); // 부모 컴포넌트의 y좌표
        setBounds(x, y, 466, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(25, 26, 60, 48);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setBounds(25, 84, 60, 48);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setBounds(25, 142, 60, 48);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        textName.setBounds(131, 28, 182, 46);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        textEmail.setColumns(10);
        textEmail.setBounds(131, 143, 182, 46);
        contentPane.add(textEmail);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        textPhone.setColumns(10);
        textPhone.setBounds(131, 85, 182, 46);
        contentPane.add(textPhone);
        
        JButton btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
                
            }
        });
        btnUpdate.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        btnUpdate.setBounds(12, 201, 107, 50);
        contentPane.add(btnUpdate);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        btnCancel.setBounds(131, 201, 91, 50);
        contentPane.add(btnCancel);
    }

    private void updateContact() {
        // 각 JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 타입 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        // DAO 메서드를 사용해서연락처 정보 (파일) 업데이트.
        dao.update(index, contact);
        
        // 창 닫기
        dispose();
        
        // 메인 창(window)에게 연락처 정보 업데이트됐다고 알려줌.
        listener.contactUpdateNotify();
        
    }
}
