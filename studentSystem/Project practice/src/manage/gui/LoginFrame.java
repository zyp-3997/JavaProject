package manage.gui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import manage.app.Application;
import manage.bean.M_user;
import manage.bean.S_user;
import manage.bean.Student;
import manage.bean.T_user;
import manage.dao.impl.M_userDaoImlp;
import manage.service.impl.M_userServiceImpl;
import manage.service.impl.S_userServiceImpl;
import manage.service.impl.T_userServiceImpl;
import manage.studentgui.Findpasswd3;
import manage.studentgui.RegisterFrame3;
import manage.teachergui.FindPassword2;
import manage.teachergui.RegisterFrame2;


public class LoginFrame extends JFrame {
	
Container content = getContentPane();
JLabel userName = new JLabel("用户名:");
JLabel passWord = new JLabel("密    码:");
JLabel id = new JLabel(" 身    份:");
TextField uName = new TextField(20);
TextField pWord = new TextField(20);

JButton login=new JButton("登录");
JButton btnRegister=new JButton("注册");
JButton btnfindpasswd=new JButton("忘记密码");
JButton exit=new JButton("退出");

JPanel image = new JPanel();
JPanel info = new JPanel(new FlowLayout());
JPanel jpa = new JPanel(new GridLayout(3, 1));
JPanel jp1= new JPanel();
JPanel jp2= new JPanel();
JPanel jp3= new JPanel();
JPanel jp4= new JPanel();
Icon icon = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\login.jpg");
JLabel img = new JLabel();

ButtonGroup bg = new ButtonGroup();

JRadioButton student=new JRadioButton("学生",false);
JRadioButton teacher=new JRadioButton("教师",false);
JRadioButton head=new JRadioButton("管理员",false);




Border b1 = BorderFactory.createLineBorder(Color.black);
Border b2 = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder());

/*//单选框的值
	String studentRadio = student.getText();
	String teacherRadio = teacher.getText();
	String headRadio = head.getText();*/
	
	String studentchoice="";
	String teacherchoice="";
	String managechoice="";
	String  username="";
	   String  password="";
	  
	   
	   
public LoginFrame(){
	//studentchoice="学生";
content.setLayout(new GridLayout(2,1));
pWord.setEchoChar('*');
jpa.add(jp1);
jpa.add(jp2);
jpa.add(jp3);
jp1.add(new Label("        "));
jp1.add(userName);
jp1.add(new Label("       "));
jp1.add(uName);
jp1.add(new Label("        "));
jp2.add(passWord);
jp2.add(new Label("        "));
jp2.add(pWord);
jp3.add(id);
jp3.add(new Label("     "));
jp3.add(student);
jp3.add(teacher);
jp3.add(head);
jp4.add(login);
jp4.add(btnRegister);
jp4.add(btnfindpasswd);
jp4.add(exit);

bg.add(student);
bg.add(teacher);
bg.add(head);
img.setIcon(icon);
image.add(img);
info.add(jpa);
info.add(jp4);
add(image);
add(info);
jpa.setBorder(BorderFactory.createCompoundBorder(b1,b2));
	pack();
	setTitle("系统用户登录");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation((int)(screenSize.width - 150)/2,
			(int)(screenSize.height - 475)/2);
	this.setResizable(false);
	setSize(360, 360);
	setVisible(true);
	
	

	 student.setActionCommand("学生");
	 teacher.setActionCommand("教师");
	 head.setActionCommand("管理员");
	
	 //单选框学生事件
	 student.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			studentchoice=bg.getSelection().getActionCommand();
			managechoice="";
			teacherchoice="";
			System.out.println(studentchoice);
			
			btnRegister.setEnabled(true);
			
		}
	});
	//单选框教师事件
		 teacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				teacherchoice=bg.getSelection().getActionCommand();
				studentchoice="";
				managechoice="";
				System.out.println(teacherchoice);
				btnRegister.setEnabled(true);
			}
		});
		//单选框管理员事件
		 head.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				managechoice=bg.getSelection().getActionCommand();
				teacherchoice="";
				studentchoice="";
				System.out.println(managechoice);
				btnRegister.setEnabled(false);
			}
		});
	 
	 
	uName.addKeyListener(new KeyAdapter() {
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == 10) {
	           pWord.requestFocus();
	        }
	    }
	});	
	
    this.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e){
    		System.exit(0);
    	}
    });
    
	
  //确定按钮单击事件
    login.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            login();
        }
    });

    // 确定按钮按键事件
    login.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                login();
            }
        }
    });
    
 // 取消按钮单击事件
    exit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    
    pWord.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                login();
            }
        }
    });
    
    //找回密码按钮单击事件
    btnfindpasswd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	
        	if(studentchoice.equals("学生")){
            // 隐藏登录窗口
        	
            setVisible(false);
            // 实例化注册窗口
            Application.findpasswd3=new Findpasswd3("新密码");
        }
        	else if(teacherchoice.equals("教师")){
        		 // 隐藏登录窗口
                setVisible(false);
               Application.findPassword2=new FindPassword2("新密码");
        		
        	}
        	else if(managechoice.equals("管理员")){
        		// 隐藏登录窗口
                setVisible(false);
        		Application.findPasswod1=new FindPasswod("新密码");
        	}
        	
        	else{
        		JOptionPane.showMessageDialog(null, "请选择身份"  + "！","学生成绩管理系统", JOptionPane.WARNING_MESSAGE);
        	}
        	     
        
        }
    });

  

    
 // 注册按钮单击事件
    btnRegister.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	
        	if(studentchoice.equals("学生")){
            // 隐藏登录窗口
            setVisible(false);
            // 实例化注册窗口
            Application.registerFrame3 =new RegisterFrame3("注册");
        }
        	else if(teacherchoice.equals("教师")){
        		 // 隐藏登录窗口
                setVisible(false);
                // 实例化注册窗口
                Application.registerFrame2=new RegisterFrame2("注册");
        		
        	}
        	
        	else{
        		JOptionPane.showMessageDialog(null, "请选择身份"  + "！","学生成绩管理系统", JOptionPane.WARNING_MESSAGE);
        	}
        	     
        
        }
    });

  
    
}






public static void main(String[] args) {
LoginFrame lg = new LoginFrame(); 
		
}
private void login() {
	 // 获取用户名
   
   username= uName.getText().trim();
    // 获取密码
   
   password= new String(pWord.getText().trim());
    // 创建用户服务对象
   S_userServiceImpl s_userServiceImpl=new S_userServiceImpl();
   T_userServiceImpl t_userServiceImpl=new T_userServiceImpl();
   M_userServiceImpl m_userServiceImpl=new M_userServiceImpl();
    // 用户登录
   S_user s_user=s_userServiceImpl.login(username, password);
   T_user t_user=t_userServiceImpl.login(username, password);
   M_user m_user=m_userServiceImpl.login(username, password);
    // 判断是否登录成功
   
 
    if (s_user != null&&studentchoice.equals("学生")) {
    	
    	JOptionPane.showMessageDialog(null, "欢迎使用成绩查询系统"  + "！",
                "学生信息管理系统", JOptionPane.INFORMATION_MESSAGE);
       
        // 定义状态服务对象
        
        // 保存用户标识
    	Application.id = s_user.getUser_id();
        // 保存用户名
       Application.username = s_user.getUser_name();
        // 提示用户登录成功
        
         //显示系统主窗口
       Application.mainFrameStudent=new MainFrameStudent("成绩查询系统【学生端】");
        // 释放登录窗口
        // 隐藏登录窗口
        setVisible(false);
        dispose();
        
    }  else if (t_user != null&&teacherchoice.equals("教师")) {
    	
    	JOptionPane.showMessageDialog(null, "欢迎使用成绩修改系统"  + "！",
                "学生成绩修改系统", JOptionPane.INFORMATION_MESSAGE);
       
        // 定义状态服务对象
        
        // 保存用户标识
    	Application.id = t_user.getUser_id();
        // 保存用户名
       Application.username = t_user.getUser_name();
        // 提示用户登录成功
        
         //显示系统主窗口
       Application.mainFrameTeacher=new MainFrameTeacher("成绩修改系统【教师端】");
        // 释放登录窗口
        // 隐藏登录窗口
        setVisible(false);
        dispose();
    	
    }
    else if (m_user !=null&&managechoice.equals("管理员")) {
    	
    	JOptionPane.showMessageDialog(null, "欢迎使用学生成绩管理系统"  + "！",
                "学生成绩管理系统", JOptionPane.INFORMATION_MESSAGE);
       
        // 定义状态服务对象
        
        // 保存用户标识
    	Application.id = m_user.getUser_id();
        // 保存用户名
       Application.username = m_user.getUser_name();
        // 提示用户登录成功
        
         //显示系统主窗口
       Application.mainFrame=new MainFrame("学生成绩管理系统【管理员】");
        // 释放登录窗口
        // 隐藏登录窗口
        setVisible(false);
        dispose();
    	
    }
    else if(bg.isSelected(null)){
    	JOptionPane.showMessageDialog(null, "请选择您的身份！", "提示", JOptionPane.WARNING_MESSAGE);
    }
    else{
    	System.out.println(s_user);
    	System.out.println(studentchoice);
        // 隐藏登录窗口
    	setVisible(false);
    	//Application.loginFrame.setVisible(false);
        // 提示用户登录失败
        JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！", "学生成绩管理系统", JOptionPane.ERROR_MESSAGE);
        // 显示登录窗口
        //Application.loginFrame.setVisible(true);
        setVisible(true);
        // 用户名文本全部选中
        uName.selectAll();
        // 密码文本全部选中
        pWord.selectAll();
        // 用户名文本框获取焦点
        uName.requestFocus();
    
}}

}