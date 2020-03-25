package manage.teachergui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

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
import manage.service.impl.T_userServiceImpl;


public class ChangePassword2 extends JFrame{
	  /**
	   * ���
	   */
	   private JPanel panel;
	   private JPanel pnlRow1;
	   private JPanel pnlRow2;
	   private JPanel pnlRow3;
	   private JPanel pnlRow4;
	   private JPanel pnlRow5;

	   /**
	   * ��ǩ
	   */
	   private JLabel lblUsername;
	   private JLabel lblPassword;
	   private JLabel lblNewPassword1;
	   private JLabel lblNewPassword2;

	   /**
	   * �ı���
	   */
	   private JTextField txtUsername;
	   private JPasswordField txtPassword;
	   private JPasswordField txtNewPassword1;
	   private JPasswordField txtNewPassword2;

	   /**
	   * ��ť
	   */
	   private JButton btnOK;
	   private JButton btnCancel;

	   /**
	   * ѧ������Ӧ�ó���
	   */
	   private static Application app;
	   /**
	   * �����û��������
	   */

	   public ChangePassword2(String title) {
	       super(title);
	       // ��ʼ���û�����
	       initGUI();
	   }

	   /**
	   * ��ʼ���û�����
	   */
	   private void initGUI() {
	       // ��������
	       panel = (JPanel) getContentPane();
	       pnlRow1 = new JPanel();
	       pnlRow2 = new JPanel();
	       pnlRow3 = new JPanel();
	       pnlRow4 = new JPanel();
	       pnlRow5 = new JPanel();

	       lblUsername = new JLabel("�û�����");
	       lblPassword = new JLabel("�����룺");
	       lblNewPassword1 = new JLabel("�����룺");
	       lblNewPassword2 = new JLabel("ȷ    �ϣ�");

	       txtUsername = new JTextField(20);
	       txtUsername.setEditable(false);
	       txtPassword = new JPasswordField(20);
	       txtNewPassword1 = new JPasswordField(20);
	       txtNewPassword2 = new JPasswordField(20);

	       btnOK = new JButton("ȷ��[O]");
	       btnOK.setMnemonic(KeyEvent.VK_O);
	       btnCancel = new JButton("ȡ��[C]");
	       btnCancel.setMnemonic(KeyEvent.VK_C);

	       // ������
	       panel.setLayout(new GridLayout(5, 1));
	       panel.add(pnlRow1);
	       panel.add(pnlRow2);
	       panel.add(pnlRow3);
	       panel.add(pnlRow4);
	       panel.add(pnlRow5);

	       pnlRow1.add(lblUsername);
	       pnlRow1.add(txtUsername);
	       pnlRow2.add(lblPassword);
	       pnlRow2.add(txtPassword);
	       pnlRow3.add(lblNewPassword1);
	       pnlRow3.add(txtNewPassword1);
	       pnlRow4.add(lblNewPassword2);
	       pnlRow4.add(txtNewPassword2);
	       pnlRow5.add(btnOK);
	       pnlRow5.add(btnCancel);

	       // ���ô�������
	       pack();
	       setVisible(true);
	       setResizable(false);
	       pack();
	       setLocationRelativeTo(null);

	       // ���ÿؼ�����
	       txtUsername.setEditable(false);
	       txtUsername.setText(Application.username);

	       // ע���������ʵ�ּ������ӿڣ���д�¼��������
	       // ȡ����ť�����¼�
	       btnCancel.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	               dispose();
	           }
	       });

	       // ȷ����ť�����¼�
	       btnOK.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	               changePassword();
	           }
	       });

	       addWindowListener(new WindowAdapter() {
	           @Override
	           public void windowClosing(WindowEvent e) {
	               dispose();
	           }
	       });

	       txtUsername.addKeyListener(new KeyAdapter() {
	           @Override
	           public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == 10) {//����س�
	                   txtPassword.requestFocus();
	               }
	           }
	       });

	       txtPassword.addKeyListener(new KeyAdapter() {
	           @Override
	           public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == 10) {
	                   txtNewPassword1.requestFocus();
	               }
	           }
	       });

	       txtNewPassword1.addKeyListener(new KeyAdapter() {
	           @Override
	           public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == 10) {
	                   txtNewPassword2.requestFocus();
	               }
	           }
	       });

	       txtNewPassword2.addKeyListener(new KeyAdapter() {
	           @Override
	           public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == 10) {
	                   btnOK.requestFocus();
	               }
	           }
	       });

	       btnOK.addKeyListener(new KeyAdapter() {
	           @Override
	           public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == 10) {
	                   changePassword();
	               }
	           }
	       });
	   }

	   /**
	   * �޸�����ķ���
	   */
	   private void changePassword() {
	       
	       int id = Application.id;
	       String username = Application.username;
	       String password = new String(txtPassword.getPassword());
	       String newPassword1 = new String(txtNewPassword1.getPassword());
	       String newPassword2 = new String(txtNewPassword2.getPassword());
	       T_userServiceImpl t_userServiceImpl=new T_userServiceImpl();

	       if (t_userServiceImpl.login(username, password) == null) { 
	           JOptionPane.showMessageDialog(null, "������������������룡", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtPassword.requestFocus();
	           txtPassword.selectAll();
	       } else if (newPassword1.equals("")) {
	           JOptionPane.showMessageDialog(null, "�����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.requestFocus();
	       } else if (newPassword2.equals("")) {
	           JOptionPane.showMessageDialog(null, "ȷ�����벻��Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword2.requestFocus();
	       } else if (!newPassword1.equals(newPassword2)) {
	           JOptionPane.showMessageDialog(null, "�������벻һ�£����������룡", "������ʾ", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.setText("");
	           txtNewPassword2.setText("");
	           txtNewPassword1.requestFocus();
	       } else {
	           // ����ʶ����ȡ�û�
	    	   T_user user=findById(id);
	           System.out.println(user);
	           // �޸�����
	           user.setPassword(newPassword1);
	           // �����û���Ϣ
	           int count = update(user);
	           if (count > 0) {
	               JOptionPane.showMessageDialog(null, "�����޸ĳɹ���", "��������", JOptionPane.INFORMATION_MESSAGE);
	               dispose();
	           } else {
	               JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ�", "��������", JOptionPane.WARNING_MESSAGE);
	           }
	       }
	       
	       
	   
	   }
	
	
	   
	   
	//���ݿ����ӷ���
	    public int deleteById(int id) {
	        return 0;
	    }
	 
	    public List<T_user> findAll() {
	        return null;
	    }
	 
	    public T_user findById(int id) {
	        // �����û�
	    	T_user user = null;
	 
	        // ��ȡ���ݿ����Ӷ���
	        Connection conn = ConnectionManager.getConnection();
	        // ����SQL�ַ���
	        String strSQL = "SELECT * FROM t_user WHERE user_id = ?";
	        try {
	            // ����Ԥ��������
	            PreparedStatement pstmt = conn.prepareStatement(strSQL);
	            // ����ռλ����ֵ
	            pstmt.setInt(1, id);
	            // ִ��SQL��ѯ�����ؽ����
	            ResultSet rs = pstmt.executeQuery();
	            // �жϽ�����Ƿ��м�¼
	            if (rs.next()) {
	                // �����û�ʵ��
	                user = new T_user();
	                // ����ʵ������
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
	    
	    public int update(T_user user) {
	        // ������¼�¼��
	        int count = 0;
	 
	        // ������ݿ�����
	        Connection conn = ConnectionManager.getConnection();
	        // ����SQL�ַ���
	        String strSQL = "UPDATE t_user SET user_name = ?, user_password = ?, user_tel = ? WHERE user_id = ?";
	                
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

}