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
JLabel userName = new JLabel("�û���:");
JLabel passWord = new JLabel("��    ��:");
JLabel id = new JLabel(" ��    ��:");
TextField uName = new TextField(20);
TextField pWord = new TextField(20);

JButton login=new JButton("��¼");
JButton btnRegister=new JButton("ע��");
JButton btnfindpasswd=new JButton("��������");
JButton exit=new JButton("�˳�");

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

JRadioButton student=new JRadioButton("ѧ��",false);
JRadioButton teacher=new JRadioButton("��ʦ",false);
JRadioButton head=new JRadioButton("����Ա",false);




Border b1 = BorderFactory.createLineBorder(Color.black);
Border b2 = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder());

/*//��ѡ���ֵ
	String studentRadio = student.getText();
	String teacherRadio = teacher.getText();
	String headRadio = head.getText();*/
	
	String studentchoice="";
	String teacherchoice="";
	String managechoice="";
	String  username="";
	   String  password="";
	  
	   
	   
public LoginFrame(){
	//studentchoice="ѧ��";
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
	setTitle("ϵͳ�û���¼");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation((int)(screenSize.width - 150)/2,
			(int)(screenSize.height - 475)/2);
	this.setResizable(false);
	setSize(360, 360);
	setVisible(true);
	
	

	 student.setActionCommand("ѧ��");
	 teacher.setActionCommand("��ʦ");
	 head.setActionCommand("����Ա");
	
	 //��ѡ��ѧ���¼�
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
	//��ѡ���ʦ�¼�
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
		//��ѡ�����Ա�¼�
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
    
	
  //ȷ����ť�����¼�
    login.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            login();
        }
    });

    // ȷ����ť�����¼�
    login.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                login();
            }
        }
    });
    
 // ȡ����ť�����¼�
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
    
    //�һ����밴ť�����¼�
    btnfindpasswd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	
        	if(studentchoice.equals("ѧ��")){
            // ���ص�¼����
        	
            setVisible(false);
            // ʵ����ע�ᴰ��
            Application.findpasswd3=new Findpasswd3("������");
        }
        	else if(teacherchoice.equals("��ʦ")){
        		 // ���ص�¼����
                setVisible(false);
               Application.findPassword2=new FindPassword2("������");
        		
        	}
        	else if(managechoice.equals("����Ա")){
        		// ���ص�¼����
                setVisible(false);
        		Application.findPasswod1=new FindPasswod("������");
        	}
        	
        	else{
        		JOptionPane.showMessageDialog(null, "��ѡ�����"  + "��","ѧ���ɼ�����ϵͳ", JOptionPane.WARNING_MESSAGE);
        	}
        	     
        
        }
    });

  

    
 // ע�ᰴť�����¼�
    btnRegister.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        	
        	if(studentchoice.equals("ѧ��")){
            // ���ص�¼����
            setVisible(false);
            // ʵ����ע�ᴰ��
            Application.registerFrame3 =new RegisterFrame3("ע��");
        }
        	else if(teacherchoice.equals("��ʦ")){
        		 // ���ص�¼����
                setVisible(false);
                // ʵ����ע�ᴰ��
                Application.registerFrame2=new RegisterFrame2("ע��");
        		
        	}
        	
        	else{
        		JOptionPane.showMessageDialog(null, "��ѡ�����"  + "��","ѧ���ɼ�����ϵͳ", JOptionPane.WARNING_MESSAGE);
        	}
        	     
        
        }
    });

  
    
}






public static void main(String[] args) {
LoginFrame lg = new LoginFrame(); 
		
}
private void login() {
	 // ��ȡ�û���
   
   username= uName.getText().trim();
    // ��ȡ����
   
   password= new String(pWord.getText().trim());
    // �����û��������
   S_userServiceImpl s_userServiceImpl=new S_userServiceImpl();
   T_userServiceImpl t_userServiceImpl=new T_userServiceImpl();
   M_userServiceImpl m_userServiceImpl=new M_userServiceImpl();
    // �û���¼
   S_user s_user=s_userServiceImpl.login(username, password);
   T_user t_user=t_userServiceImpl.login(username, password);
   M_user m_user=m_userServiceImpl.login(username, password);
    // �ж��Ƿ��¼�ɹ�
   
 
    if (s_user != null&&studentchoice.equals("ѧ��")) {
    	
    	JOptionPane.showMessageDialog(null, "��ӭʹ�óɼ���ѯϵͳ"  + "��",
                "ѧ����Ϣ����ϵͳ", JOptionPane.INFORMATION_MESSAGE);
       
        // ����״̬�������
        
        // �����û���ʶ
    	Application.id = s_user.getUser_id();
        // �����û���
       Application.username = s_user.getUser_name();
        // ��ʾ�û���¼�ɹ�
        
         //��ʾϵͳ������
       Application.mainFrameStudent=new MainFrameStudent("�ɼ���ѯϵͳ��ѧ���ˡ�");
        // �ͷŵ�¼����
        // ���ص�¼����
        setVisible(false);
        dispose();
        
    }  else if (t_user != null&&teacherchoice.equals("��ʦ")) {
    	
    	JOptionPane.showMessageDialog(null, "��ӭʹ�óɼ��޸�ϵͳ"  + "��",
                "ѧ���ɼ��޸�ϵͳ", JOptionPane.INFORMATION_MESSAGE);
       
        // ����״̬�������
        
        // �����û���ʶ
    	Application.id = t_user.getUser_id();
        // �����û���
       Application.username = t_user.getUser_name();
        // ��ʾ�û���¼�ɹ�
        
         //��ʾϵͳ������
       Application.mainFrameTeacher=new MainFrameTeacher("�ɼ��޸�ϵͳ����ʦ�ˡ�");
        // �ͷŵ�¼����
        // ���ص�¼����
        setVisible(false);
        dispose();
    	
    }
    else if (m_user !=null&&managechoice.equals("����Ա")) {
    	
    	JOptionPane.showMessageDialog(null, "��ӭʹ��ѧ���ɼ�����ϵͳ"  + "��",
                "ѧ���ɼ�����ϵͳ", JOptionPane.INFORMATION_MESSAGE);
       
        // ����״̬�������
        
        // �����û���ʶ
    	Application.id = m_user.getUser_id();
        // �����û���
       Application.username = m_user.getUser_name();
        // ��ʾ�û���¼�ɹ�
        
         //��ʾϵͳ������
       Application.mainFrame=new MainFrame("ѧ���ɼ�����ϵͳ������Ա��");
        // �ͷŵ�¼����
        // ���ص�¼����
        setVisible(false);
        dispose();
    	
    }
    else if(bg.isSelected(null)){
    	JOptionPane.showMessageDialog(null, "��ѡ��������ݣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
    }
    else{
    	System.out.println(s_user);
    	System.out.println(studentchoice);
        // ���ص�¼����
    	setVisible(false);
    	//Application.loginFrame.setVisible(false);
        // ��ʾ�û���¼ʧ��
        JOptionPane.showMessageDialog(null, "�û���������������������룡", "ѧ���ɼ�����ϵͳ", JOptionPane.ERROR_MESSAGE);
        // ��ʾ��¼����
        //Application.loginFrame.setVisible(true);
        setVisible(true);
        // �û����ı�ȫ��ѡ��
        uName.selectAll();
        // �����ı�ȫ��ѡ��
        pWord.selectAll();
        // �û����ı����ȡ����
        uName.requestFocus();
    
}}

}