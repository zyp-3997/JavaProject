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
    * 标签
    */
	private JLabel lblUserId;
	 private JLabel lblNewPassword1;
	   private JLabel lblNewPassword2;
    private JLabel lblTelephone;
 
    /**
    * 文本框
    */
    private JTextField txtUserId;
   
    private JTextField txtTelephone;
    
    private JPasswordField txtNewPassword1;
	  private JPasswordField txtNewPassword2;
 
    /**
    * 按钮
    */
    private JButton btnSubmit;
    private JButton btnCancel;
    private JButton btnLogin;
 
    /**
    * 面板
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
    * 学生管理应用程序
    */
    private static Application app;
    
    /**
    * 构造方法
    * 
    * @param title
    */
    public FindPassword2(String title) {
        super(title);
        // 创建学生管理应用程序
        app = new Application();
        Application.loginFrame=new LoginFrame();
        Application.loginFrame.setVisible(false);
        initGUI();
    }
 
    /**
    * 初始化用户界面
    */
    private void initGUI() {
        // 创建对象
    	lblUserId=new JLabel("管理号：");
        lblNewPassword1 = new JLabel("新密码：");
        lblNewPassword2 = new JLabel("确    认：");
        lblTelephone = new JLabel("电    话：");
        
        txtUserId = new JTextField("", 15);
        txtNewPassword1= new JPasswordField("", 15);
        txtNewPassword2 = new JPasswordField("", 15);
        txtTelephone = new JTextField("", 15);
        btnSubmit = new JButton("提交[S]");
        btnCancel = new JButton("取消[C]");
        btnLogin = new JButton("登录[L]");
        
        panel = (JPanel) getContentPane();
        
        panel10 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
 
        // 添加组件
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
 
        // 设置属性
        setSize(260,200); // 设置窗口大小
        setLocationRelativeTo(null);// 让窗口居中
        setResizable(false); // 窗口不可调整大小
        //pack(); // 使窗口恰好容纳组件
        setVisible(true); // 让窗口可见
        btnSubmit.setMnemonic(KeyEvent.VK_O); // 设置热键字母
        btnCancel.setMnemonic(KeyEvent.VK_C);// 设置热键字母
        btnLogin.setMnemonic(KeyEvent.VK_R);// 设置热键字母
 
        /*
        * 注册监听器，编写事件处理代码 采用匿名内部类方式来实现
        */
        // 提交按钮单击事件
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	findpassword();
            }
        });
 
        // 提交按钮按键事件
        btnSubmit.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                	findpassword();
                }
            }
        });
 
        // 取消按钮单击事件
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 显示登录窗口
                Application.loginFrame.setVisible(true);
                setVisible(false);
                // 关闭当前窗口
                dispose();
            }
        });
 
        // 登录按钮按键事件
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 显示登录窗口
                Application.loginFrame.setVisible(true);
                setVisible(false);
                // 关闭当前窗口
                dispose();
            }
        });
 
     // 用户名文本框按键事件
        txtUserId.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                   txtTelephone.requestFocus();
                }
            }
        });
        // 用户名文本框按键事件
        txtTelephone.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtNewPassword1.requestFocus();
                }
            }
        });
 
        // 密码文本框按键事件
        txtNewPassword1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtNewPassword2.requestFocus();
                }
            }
        });
 
        // 电话文本框按键事件
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
    * 注册方法
    */
    private void findpassword() {
        // 获取用户名
    	userid=txtUserId.getText().trim();
    	 telephone = txtTelephone.getText().trim();
    	 
    	 password1 = new String(txtNewPassword1.getPassword());
	     password2 = new String(txtNewPassword2.getPassword());
       
        
        // 定义用户服务对象
        
        // 添加用户
        if (id(userid) == null) { 
	           JOptionPane.showMessageDialog(null, "管理员号不正确，请重新输入！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtUserId.requestFocus();
	           txtUserId.selectAll();
	       } else if(idtel(userid, telephone)==null){
	    	   JOptionPane.showMessageDialog(null, "电话号不正确，请重新输入！", "错误提示", JOptionPane.ERROR_MESSAGE);
	    	 txtTelephone.requestFocus();
	    	 txtTelephone.selectAll();
	       }
	       
        
        else if (password1.equals("")) {
	           JOptionPane.showMessageDialog(null, "新密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.requestFocus();
	       } else if (password2.equals("")) {
	           JOptionPane.showMessageDialog(null, "确认密码不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword2.requestFocus();
	       } else if (!password1.equals(password2)) {
	           JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！", "错误提示", JOptionPane.ERROR_MESSAGE);
	           txtNewPassword1.setText("");
	           txtNewPassword2.setText("");
	           txtNewPassword1.requestFocus();
	       } else {
	           // 按标识符获取用户
	    	  T_user user=id(userid);
	           System.out.println(user);
	           // 修改密码
	           user.setPassword(password1);
	           // 更新用户信息
	           int count = update(user);
	           if (count > 0) {
	        	   setVisible(false);
	               dispose();
	               Application.loginFrame.setVisible(true);
	           
	               JOptionPane.showMessageDialog(null, "密码修改成功！", "设置密码", JOptionPane.INFORMATION_MESSAGE);
	               dispose();
	           } else 
	               JOptionPane.showMessageDialog(null, "密码修改失败！", "设置密码", JOptionPane.WARNING_MESSAGE);
	           }
        
        
        
	       }
      
        public int update(T_user user) {
	        // 定义更新记录数
	        int count = 0;
	 
	        // 获得数据库连接
	        Connection conn = ConnectionManager.getConnection();
	        // 定义SQL字符串
	        String strSQL = "UPDATE m_user SET user_name = ?, user_password = ?, user_tel = ? WHERE user_id = ?";
	                
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
    
        public  T_user idtel(String userid, String usertel){
    	    // 声明用户
    	    T_user user = null;
    	    // 获取数据库连接
    	    Connection conn = ConnectionManager.getConnection();
    	    // 定义SQL字符串
    	    String strSQL = "SELECT * FROM m_user WHERE user_id = ? AND user_tel = ?";
    	    try {
    	        // 创建预备语句对象
    	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
    	        // 设置占位符的值
    	        pstmt.setString(1, userid);
    	        pstmt.setString(2, usertel);
    	        // 执行查询，返回结果集
    	        ResultSet rs = pstmt.executeQuery();
    	        // 判断是否有记录
    	        if (rs.next()) {
    	            // 实例化用户
    	            user = new T_user();
    	            // 设置用户属性
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
    
        public  T_user id(String userid){
    	    // 声明用户
    	   T_user user = null;
    	    // 获取数据库连接
    	    Connection conn = ConnectionManager.getConnection();
    	    // 定义SQL字符串
    	    String strSQL = "SELECT * FROM m_user WHERE user_id = ?";
    	    try {
    	        // 创建预备语句对象
    	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
    	        // 设置占位符的值
    	        pstmt.setString(1, userid);
    	        // 执行查询，返回结果集
    	        ResultSet rs = pstmt.executeQuery();
    	        // 判断是否有记录
    	        if (rs.next()) {
    	            // 实例化用户
    	            user = new T_user();
    	            // 设置用户属性
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
 
        public static void main(String args[]){
        FindPassword2 findPassword2=new FindPassword2("新密码");
        }
    }
