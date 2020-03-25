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
    * 标签
    */
	private JLabel lblUserId;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblTelephone;
 
    /**
    * 文本框
    */
    private JTextField txtUserId;
    private JTextField txtUsername;
    private JTextField txtTelephone;
    private JPasswordField txtPassword;
 
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
 
    private int userid;
    private String username;
    private String password;
    private int  telephone;
 
    /**
    * 学生管理应用程序
    */
    private static Application app;
    
    /**
    * 构造方法
    * 
    * @param title
    */
    public RegisterFrame3(String title) {
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
    	lblUserId=new JLabel("学    号：");
        lblUsername = new JLabel("用户名：");
        lblPassword = new JLabel("密    码：");
        lblTelephone = new JLabel("电   话：");
        
        txtUserId = new JTextField("", 15);
        txtUsername = new JTextField("", 15);
        txtPassword = new JPasswordField("", 15);
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
 
        // 设置属性
        setSize(350, 300); // 设置窗口大小
        setLocationRelativeTo(null);// 让窗口居中
        setResizable(false); // 窗口不可调整大小
        pack(); // 使窗口恰好容纳组件
        setVisible(true); // 让窗口可见
        btnSubmit.setMnemonic(KeyEvent.VK_O); // 设置热键字母
        btnCancel.setMnemonic(KeyEvent.VK_C);// 设置热键字母
        btnLogin.setMnemonic(KeyEvent.VK_R);// 设置热键字母
        txtPassword.setEchoChar('*');// 设置回显字符
 
        /*
        * 注册监听器，编写事件处理代码 采用匿名内部类方式来实现
        */
        // 提交按钮单击事件
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
 
        // 提交按钮按键事件
        btnSubmit.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    register();
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
                // 关闭当前窗口
                dispose();
            }
        });
 
     // 用户名文本框按键事件
        txtUserId.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtUsername.requestFocus();
                }
            }
        });
        // 用户名文本框按键事件
        txtUsername.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtPassword.requestFocus();
                }
            }
        });
 
        // 密码文本框按键事件
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    txtTelephone.requestFocus();
                }
            }
        });
 
        // 电话文本框按键事件
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
    * 注册方法
    */
    private void register() {
        // 获取用户名
    	userid=0;
    	userid=Integer.parseInt(txtUserId.getText().trim());
        username = txtUsername.getText().trim();
        // 获取密码
        password = new String(txtPassword.getPassword());
        // 获取电话
        telephone = Integer.parseInt(txtTelephone.getText().trim());
        
        // 定义用户服务对象
        S_userServiceImpl s_userServiceImpl=new S_userServiceImpl();
        S_user user=new S_user();
        // 创建用户
        
        user.setUser_id(userid);
        user.setUser_name(username);
        user.setPassword(password);
        user.setUser_tel(telephone);
        
        // 添加用户
        
        int count = insert(user);
        
        // 判断是否添加成功
        if (count > 0) {
            setVisible(false);
            dispose();
            Application.loginFrame.setVisible(true);
            JOptionPane.showMessageDialog(null, "恭喜！注册成功！", "学生成绩管理系统", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
        	
            JOptionPane.showMessageDialog(null, "您已经注册过！", "学生成绩管理系统", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public int insert(S_user user) {
        // 定义插入记录数
        int count = 0;
 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "INSERT INTO s_user "
                + " VALUES (?, ?, ?,?)";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            
            pstmt.setInt(1,user.getUser_id());
            pstmt.setString(2, user.getUser_name());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4,user.getUser_tel());
           
            // 执行更新操作，插入新记录
            count = pstmt.executeUpdate();
            // 关闭预备语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           ConnectionManager.closeConnection(conn);
        }
 
        // 返回插入记录数
        return count;
    }
    
    }
