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
	   * 面板
	   */
	   private JPanel panel;
	   private JPanel pnlRow1;
	   private JPanel pnlRow2;
	   private JPanel pnlRow3;
	   private JPanel pnlRow4;
	   private JPanel pnlRow5;

	   /**
	   * 标签
	   */
	   private JLabel lblUsername;
	   private JLabel lblPassword;
	   private JLabel lblNewPassword1;
	   private JLabel lblNewPassword2;

	   /**
	   * 文本框
	   */
	   private JTextField txtUsername;
	   private JPasswordField txtPassword;
	   private JPasswordField txtNewPassword1;
	   private JPasswordField txtNewPassword2;

	   /**
	   * 按钮
	   */
	   private JButton btnOK;
	   private JButton btnCancel;

	   /**
	   * 学生管理应用程序
	   */
	   private static Application app;
	   /**
	   * 创建用户服务对象
	   */

	   public ChangePassword2(String title) {
	       super(title);
	       // 初始化用户界面
	       initGUI();
	   }

	   /**
	   * 初始化用户界面
	   */
	   private void initGUI() {
	       // 创建对象
	       panel = (JPanel) getContentPane();
	       pnlRow1 = new JPanel();
	       pnlRow2 = new JPanel();
	       pnlRow3 = new JPanel();
	       pnlRow4 = new JPanel();
	       pnlRow5 = new JPanel();

	       lblUsername = new JLabel("用户名：");
	       lblPassword = new JLabel("旧密码：");
	       lblNewPassword1 = new JLabel("新密码：");
	       lblNewPassword2 = new JLabel("确    认：");

	       txtUsername = new JTextField(20);
	       txtUsername.setEditable(false);
	       txtPassword = new JPasswordField(20);
	       txtNewPassword1 = new JPasswordField(20);
	       txtNewPassword2 = new JPasswordField(20);

	       btnOK = new JButton("确定[O]");
	       btnOK.setMnemonic(KeyEvent.VK_O);
	       btnCancel = new JButton("取消[C]");
	       btnCancel.setMnemonic(KeyEvent.VK_C);

	       // 添加组件
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

	       // 设置窗口属性
	       pack();
	       setVisible(true);
	       setResizable(false);
	       pack();
	       setLocationRelativeTo(null);

	       // 设置控件属性
	       txtUsername.setEditable(false);
	       txtUsername.setText(Application.username);

	       // 注册监听器，实现监听器接口，编写事件处理代码
	       // 取消按钮单击事件
	       btnCancel.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	               dispose();
	           }
	       });

	       // 确定按钮单击事件
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
	               if (e.getKeyCode() == 10) {//如果回车
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
	   * 修改密码的方法
	   */
	   private void changePassword() {
	       
	       int id = Application.id;
	       String username = Application.username;
	       String password = new String(txtPassword.getPassword());
	       String newPassword1 = new String(txtNewPassword1.getPassword());
	       String newPassword2 = new String(txtNewPassword2.getPassword());
	       T_userServiceImpl t_userServiceImpl=new T_userServiceImpl();

	       if (t_userServiceImpl.login(username, password) == null) { 
	           JOptionPane.showMessageDialog(null, "旧密码错误，请重新输入！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtPassword.requestFocus();
	           txtPassword.selectAll();
	       } else if (newPassword1.equals("")) {
	           JOptionPane.showMessageDialog(null, "新密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.requestFocus();
	       } else if (newPassword2.equals("")) {
	           JOptionPane.showMessageDialog(null, "确认密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword2.requestFocus();
	       } else if (!newPassword1.equals(newPassword2)) {
	           JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.setText("");
	           txtNewPassword2.setText("");
	           txtNewPassword1.requestFocus();
	       } else {
	           // 按标识符获取用户
	    	   T_user user=findById(id);
	           System.out.println(user);
	           // 修改密码
	           user.setPassword(newPassword1);
	           // 更新用户信息
	           int count = update(user);
	           if (count > 0) {
	               JOptionPane.showMessageDialog(null, "密码修改成功！", "设置密码", JOptionPane.INFORMATION_MESSAGE);
	               dispose();
	           } else {
	               JOptionPane.showMessageDialog(null, "密码修改失败！", "设置密码", JOptionPane.WARNING_MESSAGE);
	           }
	       }
	       
	       
	   
	   }
	
	
	   
	   
	//数据库连接方法
	    public int deleteById(int id) {
	        return 0;
	    }
	 
	    public List<T_user> findAll() {
	        return null;
	    }
	 
	    public T_user findById(int id) {
	        // 声明用户
	    	T_user user = null;
	 
	        // 获取数据库连接对象
	        Connection conn = ConnectionManager.getConnection();
	        // 定义SQL字符串
	        String strSQL = "SELECT * FROM t_user WHERE user_id = ?";
	        try {
	            // 创建预备语句对象
	            PreparedStatement pstmt = conn.prepareStatement(strSQL);
	            // 设置占位符的值
	            pstmt.setInt(1, id);
	            // 执行SQL查询，返回结果集
	            ResultSet rs = pstmt.executeQuery();
	            // 判断结果集是否有记录
	            if (rs.next()) {
	                // 创建用户实体
	                user = new T_user();
	                // 设置实体属性
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
	 
	        // 返回用户
	        return user;
	    }
	    
	    public int update(T_user user) {
	        // 定义更新记录数
	        int count = 0;
	 
	        // 获得数据库连接
	        Connection conn = ConnectionManager.getConnection();
	        // 定义SQL字符串
	        String strSQL = "UPDATE t_user SET user_name = ?, user_password = ?, user_tel = ? WHERE user_id = ?";
	                
	        try {
	            // 创建预备语句对象
	            PreparedStatement pstmt = conn.prepareStatement(strSQL);
	            // 设置占位符的值
	            pstmt.setString(1, user.getUser_name());
	            pstmt.setString(2, user.getPassword());
	            pstmt.setInt(3, user.getUser_tel());
	            pstmt.setInt(4, user.getUser_id());
	            // 执行更新操作，更新记录
	            count = pstmt.executeUpdate();
	            // 关闭预备语句对象
	            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionManager.closeConnection(conn);
	        }
	 
	        // 返回更新记录数
	        return count;
	    }

}