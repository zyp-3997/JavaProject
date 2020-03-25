package manage.studentgui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
 






import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import manage.app.Application;
import manage.bean.S_user;
import manage.dbutil.ConnectionManager;
import manage.gui.LoginFrame;
import manage.service.impl.S_userServiceImpl;
 
 
public class RegisterFrame3 extends JFrame { 
    
    /**
    * ��ǩ
    */
	private JLabel lblUserId;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblTelephone;
 
    /**
    * �ı���
    */
    private JTextField txtUserId;
    private JTextField txtUsername;
    private JTextField txtTelephone;
    private JPasswordField txtPassword;
 
    /**
    * ��ť
    */
    private JButton btnSubmit;
    private JButton btnCancel;
    private JButton btnLogin;
 
    /**
    * ���
    */
    private JPanel panel;
    private JPanel panel10;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
 
    private int userid;
    private String username;
    private String password;
    private int  telephone;
 
    /**
    * ѧ������Ӧ�ó���
    */
    private static Application app;
    
    /**
    * ���췽��
    * 
    * @param title
    */
    public RegisterFrame3(String title) {
        super(title);
        // ����ѧ������Ӧ�ó���
        app = new Application();
        Application.loginFrame=new LoginFrame();
        Application.loginFrame.setVisible(false);
        initGUI();
    }
 
    /**
    * ��ʼ���û�����
    */
    private void initGUI() {
        // ��������
    	lblUserId=new JLabel("ѧ    �ţ�");
        lblUsername = new JLabel("�û�����");
        lblPassword = new JLabel("��    �룺");
        lblTelephone = new JLabel("��   ����");
        
        txtUserId = new JTextField("", 15);
        txtUsername = new JTextField("", 15);
        txtPassword = new JPasswordField("", 15);
        txtTelephone = new JTextField("", 15);
        btnSubmit = new JButton("�ύ[S]");
        btnCancel = new JButton("ȡ��[C]");
        btnLogin = new JButton("��¼[L]");
        
        panel = (JPanel) getContentPane();
        
        panel10 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
 
        // ������
        panel.setLayout(new GridLayout(5, 1));
        panel.add(panel10);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
 
      
        panel10.add(lblUserId);
        panel10.add(txtUserId);
        
        panel1.add(lblUsername);
        panel1.add(txtUsername);
        panel2.add(lblPassword);
        panel2.add(txtPassword);
        panel3.add(lblTelephone);
        panel3.add(txtTelephone);
        panel4.add(btnSubmit);
        panel4.add(btnCancel);
        panel4.add(btnLogin);
 
        // ��������
        setSize(350, 300); // ���ô��ڴ�С
        setLocationRelativeTo(null);// �ô��ھ���
        setResizable(false); // ���ڲ��ɵ�����С
        pack(); // ʹ����ǡ���������
        setVisible(true); // �ô��ڿɼ�
        btnSubmit.setMnemonic(KeyEvent.VK_O); // �����ȼ���ĸ
        btnCancel.setMnemonic(KeyEvent.VK_C);// �����ȼ���ĸ
        btnLogin.setMnemonic(KeyEvent.VK_R);// �����ȼ���ĸ
        txtPassword.setEchoChar('*');// ���û����ַ�
 
        /*
        * ע�����������д�¼�������� ���������ڲ��෽ʽ��ʵ��
        */
        // �ύ��ť�����¼�
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
 
        // �ύ��ť�����¼�
        btnSubmit.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    register();
                }
            }
        });
 
        // ȡ����ť�����¼�
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ��ʾ��¼����
                Application.loginFrame.setVisible(true);
                setVisible(false);
                // �رյ�ǰ����
                dispose();
            }
        });
 
        // ��¼��ť�����¼�
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ��ʾ��¼����
                Application.loginFrame.setVisible(true);
                // �رյ�ǰ����
                dispose();
            }
        });
 
     // �û����ı��򰴼��¼�
        txtUserId.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtUsername.requestFocus();
                }
            }
        });
        // �û����ı��򰴼��¼�
        txtUsername.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtPassword.requestFocus();
                }
            }
        });
 
        // �����ı��򰴼��¼�
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtTelephone.requestFocus();
                }
            }
        });
 
        // �绰�ı��򰴼��¼�
        txtTelephone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                	register();
                }
            }
        });
    }
 
    /**
    * ע�᷽��
    */
    private void register() {
        // ��ȡ�û���
    	userid=0;
    	userid=Integer.parseInt(txtUserId.getText().trim());
        username = txtUsername.getText().trim();
        // ��ȡ����
        password = new String(txtPassword.getPassword());
        // ��ȡ�绰
        telephone = Integer.parseInt(txtTelephone.getText().trim());
        
        // �����û��������
        S_userServiceImpl s_userServiceImpl=new S_userServiceImpl();
        S_user user=new S_user();
        // �����û�
        
        user.setUser_id(userid);
        user.setUser_name(username);
        user.setPassword(password);
        user.setUser_tel(telephone);
        
        // ����û�
        
        int count = insert(user);
        
        // �ж��Ƿ���ӳɹ�
        if (count > 0) {
            setVisible(false);
            dispose();
            Application.loginFrame.setVisible(true);
            JOptionPane.showMessageDialog(null, "��ϲ��ע��ɹ���", "ѧ���ɼ�����ϵͳ", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
        	
            JOptionPane.showMessageDialog(null, "���Ѿ�ע�����", "ѧ���ɼ�����ϵͳ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public int insert(S_user user) {
        // ��������¼��
        int count = 0;
 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "INSERT INTO s_user "
                + " VALUES (?, ?, ?,?)";
        try {
            // ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // ����ռλ����ֵ
            
            pstmt.setInt(1,user.getUser_id());
            pstmt.setString(2, user.getUser_name());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4,user.getUser_tel());
           
            // ִ�и��²����������¼�¼
            count = pstmt.executeUpdate();
            // �ر�Ԥ��������
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           ConnectionManager.closeConnection(conn);
        }
 
        // ���ز����¼��
        return count;
    }
    
    }
