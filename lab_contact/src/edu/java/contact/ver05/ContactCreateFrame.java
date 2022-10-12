package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ContactCreateFrame extends JFrame {
    
    public interface ContactInsertListener{
        void contactInsertNotify(Contact c);
        
    }

    private ContactInsertListener listener;
    
    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textPhone;
    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) { // 프로그램에서는 main 오직 하나, 이름 바꿔주자. // appmain10 보고 argument 수정함
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener); // 전달 받은 parent 여기로 넘겼다.
                frame.setVisible(true);
               
            }
        });
    }

    /**
     * Create the frame.
     */
    
    public ContactCreateFrame(Component parent, ContactInsertListener listener) { // 이러면 main과 똑같은 구조 아니냐. // 20줄에서 받은거 수정해주기위해서 여기에도 argument에 추가.
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.listener = listener; // contactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트들을 생성, 초기화.
    }
    /**
     * Initialize UI components.
     */
    public void initialize() {
        setTitle("새 연락처 추가");
        // 닫기 버튼을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 메인 창이니까 EXIT 대신에 DISPOSE
        
        // JFrame이 화면에 보이게 될 좌표와 크기(가로/세로)를 설정.
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
        
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
                
            }
        });
        btnSave.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        btnSave.setBounds(12, 201, 91, 50);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창만 닫고, 부모 컴포넌트는 계속 실행.                
            }
        });
        btnCancel.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
        btnCancel.setBounds(131, 201, 91, 50);
        contentPane.add(btnCancel);
    }

    protected void createNewContact() {
        // 3개의 JTextField의 입력된 문자열을 읽는다
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        // 현재 창 닫기
        dispose();
        
        // 새 연락처가 생성됐음을 알려줌 (ContactMain에게)
        listener.contactInsertNotify(contact); // dispose와 위치 바꿧다고 종료되는 시점이 달라짐.
    }
}
