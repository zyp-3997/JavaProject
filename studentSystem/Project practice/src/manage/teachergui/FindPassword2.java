package manage.teachergui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import manage.bean.T_user;
import manage.dbutil.ConnectionManager;
import manage.gui.LoginFrame;
import manage.service.impl.M_userServiceImpl;
import manage.service.impl.S_userServiceImpl;
 
 
public class FindPassword2 extends JFrame { 
    
    /**
    * ��ǩ
    */
	private JLabel lblUserId;
	 private JLabel lblNewPassword1;
	   private JLabel lblNewPassword2;
    private JLabel lblTelephone;
 
    /**
    * �ı���
    */
    private JTextField txtUserId;
   
    private JTextField txtTelephone;
    
    private JPasswordField txtNewPassword1;
	  private JPasswordField txtNewPassword2;
 
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
 
    private String userid;
    private String password1;
    private String password2;
    private String  telephone;
 
    /**
    * ѧ������Ӧ�ó���
    */
    private static Application app;
    
    /**
    * ���췽��
    * 
    * @param title
    */
    public FindPassword2(String title) {
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
    	lblUserId=new JLabel("����ţ�");
        lblNewPassword1 = new JLabel("�����룺");
        lblNewPassword2 = new JLabel("ȷ    �ϣ�");
        lblTelephone = new JLabel("��    ����");
        
        txtUserId = new JTextField("", 15);
        txtNewPassword1= new JPasswordField("", 15);
        txtNewPassword2 = new JPasswordField("", 15);
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
        panel.add(panel3);
        panel.add(panel1);
        panel.add(panel2);
       
        panel.add(panel4);
 
      
        panel10.add(lblUserId);
        panel10.add(txtUserId);
        
        panel1.add(lblNewPassword1);
        panel1.add(txtNewPassword1);
        
        panel2.add(lblNewPassword2);
        panel2.add(txtNewPassword2);
        panel3.add(lblTelephone);
        panel3.add(txtTelephone);
        panel4.add(btnSubmit);
        panel4.add(btnCancel);
        panel4.add(btnLogin);
 
        // ��������
        setSize(260,200); // ���ô��ڴ�С
        setLocationRelativeTo(null);// �ô��ھ���
        setResizable(false); // ���ڲ��ɵ�����С
        //pack(); // ʹ����ǡ���������
        setVisible(true); // �ô��ڿɼ�
        btnSubmit.setMnemonic(KeyEvent.VK_O); // �����ȼ���ĸ
        btnCancel.setMnemonic(KeyEvent.VK_C);// �����ȼ���ĸ
        btnLogin.setMnemonic(KeyEvent.VK_R);// �����ȼ���ĸ
 
        /*
        * ע�����������д�¼�������� ���������ڲ��෽ʽ��ʵ��
        */
        // �ύ��ť�����¼�
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	findpassword();
            }
        });
 
        // �ύ��ť�����¼�
        btnSubmit.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                	findpassword();
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
                setVisible(false);
                // �رյ�ǰ����
                dispose();
            }
        });
 
     // �û����ı��򰴼��¼�
        txtUserId.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                   txtTelephone.requestFocus();
                }
            }
        });
        // �û����ı��򰴼��¼�
        txtTelephone.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtNewPassword1.requestFocus();
                }
            }
        });
 
        // �����ı��򰴼��¼�
        txtNewPassword1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtNewPassword2.requestFocus();
                }
            }
        });
 
        // �绰�ı��򰴼��¼�
        txtNewPassword2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                	findpassword();
                }
            }
        });
    }
 
    /**
    * ע�᷽��
    */
    private void findpassword() {
        // ��ȡ�û���
    	userid=txtUserId.getText().trim();
    	 telephone = txtTelephone.getText().trim();
    	 
    	 password1 = new String(txtNewPassword1.getPassword());
	     password2 = new String(txtNewPassword2.getPassword());
       
        
        // �����û��������
        
        // ����û�
        if (id(userid) == null) { 
	           JOptionPane.showMessageDialog(null, "����Ա�Ų���ȷ�����������룡", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtUserId.requestFocus();
	           txtUserId.selectAll();
	       } else if(idtel(userid, telephone)==null){
	    	   JOptionPane.showMessageDialog(null, "�绰�Ų���ȷ�����������룡", "������ʾ", JOptionPane.ERROR_MESSAGE);
	    	 txtTelephone.requestFocus();
	    	 txtTelephone.selectAll();
	       }
	       
        
        else if (password1.equals("")) {
	           JOptionPane.showMessageDialog(null, "�����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.requestFocus();
	       } else if (password2.equals("")) {
	           JOptionPane.showMessageDialog(null, "ȷ�����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword2.requestFocus();
	       } else if (!password1.equals(password2)) {
	           JOptionPane.showMessageDialog(null, "�������벻һ�£����������룡", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.setText("");
	           txtNewPassword2.setText("");
	           txtNewPassword1.requestFocus();
	       } else {
	           // ����ʶ����ȡ�û�
	    	  T_user user=id(userid);
	           System.out.println(user);
	           // �޸�����
	           user.setPassword(password1);
	           // �����û���Ϣ
	           int count = update(user);
	           if (count > 0) {
	        	   setVisible(false);
	               dispose();
	               Application.loginFrame.setVisible(true);
	           
	               JOptionPane.showMessageDialog(null, "�����޸ĳɹ���", "��������", JOptionPane.INFORMATION_MESSAGE);
	               dispose();
	           } else 
	               JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ�", "��������", JOptionPane.WARNING_MESSAGE);
	           }
        
        
        
	       }
      
        public int update(T_user user) {
	        // ������¼�¼��
	        int count = 0;
	 
	        // ������ݿ�����
	        Connection conn = ConnectionManager.getConnection();
	        // ����SQL�ַ���
	        String strSQL = "UPDATE m_user SET user_name = ?, user_password = ?, user_tel = ? WHERE user_id = ?";
	                
	        try {
	            // ����Ԥ��������
	            PreparedStatement pstmt = conn.prepareStatement(strSQL);
	            // ����ռλ����ֵ
	            pstmt.setString(1, user.getUser_name());
	            pstmt.setString(2, user.getPassword());
	            pstmt.setInt(3, user.getUser_tel());
	            pstmt.setInt(4, user.getUser_id());
	            // ִ�и��²��������¼�¼
	            count = pstmt.executeUpdate();
	            // �ر�Ԥ��������
	            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionManager.closeConnection(conn);
	        }
	 
	        // ���ظ��¼�¼��
	        return count;
	    }
    
        public  T_user idtel(String userid, String usertel){
    	    // �����û�
    	    T_user user = null;
    	    // ��ȡ���ݿ�����
    	    Connection conn = ConnectionManager.getConnection();
    	    // ����SQL�ַ���
    	    String strSQL = "SELECT * FROM m_user WHERE user_id = ? AND user_tel = ?";
    	    try {
    	        // ����Ԥ��������
    	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
    	        // ����ռλ����ֵ
    	        pstmt.setString(1, userid);
    	        pstmt.setString(2, usertel);
    	        // ִ�в�ѯ�����ؽ����
    	        ResultSet rs = pstmt.executeQuery();
    	        // �ж��Ƿ��м�¼
    	        if (rs.next()) {
    	            // ʵ�����û�
    	            user = new T_user();
    	            // �����û�����
    	       user.setUser_id(rs.getInt("user_id"));
    	       user.setUser_name(rs.getString("user_name"));
    	       user.setPassword(rs.getString("user_password"));
    	       user.setUser_tel(rs.getInt("user_tel"));
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        ConnectionManager.closeConnection(conn);
    	    }

    	    // �����û�
    	    return user;
    }
    
        public  T_user id(String userid){
    	    // �����û�
    	   T_user user = null;
    	    // ��ȡ���ݿ�����
    	    Connection conn = ConnectionManager.getConnection();
    	    // ����SQL�ַ���
    	    String strSQL = "SELECT * FROM m_user WHERE user_id = ?";
    	    try {
    	        // ����Ԥ��������
    	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
    	        // ����ռλ����ֵ
    	        pstmt.setString(1, userid);
    	        // ִ�в�ѯ�����ؽ����
    	        ResultSet rs = pstmt.executeQuery();
    	        // �ж��Ƿ��м�¼
    	        if (rs.next()) {
    	            // ʵ�����û�
    	            user = new T_user();
    	            // �����û�����
    	       user.setUser_id(rs.getInt("user_id"));
    	       user.setUser_name(rs.getString("user_name"));
    	       user.setPassword(rs.getString("user_password"));
    	       user.setUser_tel(rs.getInt("user_tel"));
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        ConnectionManager.closeConnection(conn);
    	    }

    	    // �����û�
    	    return user;
    }
 
        public static void main(String args[]){
        FindPassword2 findPassword2=new FindPassword2("������");
        }
    }
