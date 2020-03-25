package manage.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import manage.app.Application;
import manage.studentgui.ChangePassword3;
import manage.studentgui.LookGradeFrame;
import manage.studentgui.LookStudenInforFrame;
import manage.studentgui.LookTeacherInforFrame;
import manage.studentgui.UpdateStudenInforFrame;
import manage.teachergui.ChangePassword2;
import manage.teachergui.LookStudentInforFrame;
import manage.teachergui.LookTeacherinforFrame;

public class MainFrameStudent extends JFrame  {

	/**
	    * 图标对象
	    */
	    private ImageIcon imgExit;
	    private ImageIcon imgPassword;
	    private ImageIcon imgQuery;
	    private ImageIcon imgBrowse;
	    private ImageIcon imgCount;
	    private ImageIcon imgBackground; 
	    
	
	 /**
	    * 按钮
	    */
	    private JButton btnChangePassword;
	    private JButton btnStudentInfor;
	    private JButton btnExit;
	    private JButton btnTeacherInfor;
	    private JButton btngFindGrade;
	

	    /**
	    * 工具栏
	    */
	    private JToolBar toolbar;
	Container contentPane = getContentPane();
    Icon icon = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\Bgstudent.jpg");
    JLabel img = new JLabel();
	JMenuBar jMenuBar1 = new JMenuBar();
	
	JMenu informationjMenu2 = new JMenu("【基本信息】");
	
	
	
	
	JMenu selectjMenu3 = new JMenu("【查看成绩】");
	JMenuItem selectJMenuItem=new JMenuItem("个人成绩");
	
	JMenu managejMenu4 = new JMenu("【系统管理】");
	
	JMenuItem collegeinforItem=new JMenuItem("学校信息");
	JMenu studentjmenu = new JMenu("个人信息");
	
	JMenuItem lookstudentinformation = new JMenuItem("查看个人信息");
	JMenuItem updatestudentinformation = new JMenuItem("修改个人信息");
	
	
	JMenu teacherjMenu  = new JMenu("教师信息");
	
	JMenuItem lookteachertinformation = new JMenuItem("查看任课老师信息");
		
	
	
	JMenuItem aboutjMenuItem11 = new JMenuItem("关于我们");
	JMenuItem updatepasswordjMenuItem12 = new JMenuItem("修改密码");
	JMenuItem exitjMenuItem13 = new JMenuItem("退出系统");
	
	
	Dimension faceSize = new Dimension(400, 600);	
	 JPanel p = new JPanel();
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();
    JButton jb5 = new JButton();
    JButton jb6 = new JButton();
    JButton jb7 = new JButton();
    JButton jb8 = new JButton();
    BorderLayout bord = new BorderLayout();

	public MainFrameStudent(String title){
		super(title);
		Start();
	}
		public void Start(){
			    imgPassword = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\update.png");
			    imgQuery = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\teacher.png");
			    imgBrowse = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\student.png");
			    imgCount = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\select.png");
			    imgExit = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\exit.png");
			    
			 // 创建工具栏
		        toolbar = new JToolBar();
		        btnChangePassword = new JButton("修改密码", imgPassword);
		        btnChangePassword.setToolTipText("修改学生密码");//在控件上显示提示信息
		        btnChangePassword.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnChangePassword.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        btnStudentInfor = new JButton("个人信息", imgBrowse);
		        btnStudentInfor.setToolTipText("浏览自己信息");
		        btnStudentInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnStudentInfor.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        btnTeacherInfor = new JButton("老师信息", imgQuery);
		        btnTeacherInfor.setToolTipText("浏览任课老师信息");
		        btnTeacherInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnTeacherInfor.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        btngFindGrade = new JButton("查看成绩", imgCount);
		        btngFindGrade.setToolTipText("查看自己成绩");
		        btngFindGrade.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btngFindGrade.setHorizontalTextPosition(AbstractButton.CENTER);
		        btnExit = new JButton("退出系统", imgExit);
		        btnExit.setToolTipText("退出系统");
		        btnExit.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnExit.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        
		        toolbar.add(btnStudentInfor);
		        toolbar.add(btnTeacherInfor);
		        toolbar.add(btngFindGrade);
		        toolbar.add(btnChangePassword);
		        toolbar.add(btnExit);
		        
		        
		jMenuBar1.add(informationjMenu2);
		jMenuBar1.add(selectjMenu3);
		jMenuBar1.add(managejMenu4);		
		

		informationjMenu2.add(collegeinforItem);
		
		informationjMenu2.add(studentjmenu);
		
		studentjmenu.add(lookstudentinformation);
		studentjmenu.add(updatestudentinformation);
		
		informationjMenu2.add(teacherjMenu);
		
		teacherjMenu.add(lookteachertinformation);
		selectjMenu3.add(selectJMenuItem);
		
	;
		
		managejMenu4.add(aboutjMenuItem11);
		managejMenu4.add(updatepasswordjMenuItem12);
		managejMenu4.add(exitjMenuItem13);
		
		img.setIcon(icon);
		setJMenuBar(jMenuBar1);
		setContentPane(p);
        p.setLayout(bord);
        p.add("North",toolbar);  
        p.add("Center",img);
		this.setSize(faceSize);
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - faceSize.getWidth()) / 2,
						 (int) (screenSize.height - faceSize.getHeight()) / 2);
		pack();
		setSize(650, 465);
		 setLocationRelativeTo(null);
		  setResizable(false);
		  setVisible(true);
		  
		  //设置学校信息
	        collegeinforItem.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {

					LookCollegeInforFrame lookCollegeInforFrame=new LookCollegeInforFrame("查看大学信息");
				}
			});
		
		// 关闭窗口单击事件
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });
 
        //学生查看个人成绩
        selectJMenuItem.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				LookGradeFrame lookGradeFrame=new LookGradeFrame("查看个人成绩");
				
			}
		});
        
        //学生查看信息事件
       lookstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				LookStudenInforFrame lookStudentInforFrame=new LookStudenInforFrame("查看个人信息");
				
			}
		});
     
       //学生更新信息事件
       updatestudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				UpdateStudenInforFrame updateStudenInforFrame=new UpdateStudenInforFrame("修改个人信息");
				
			}
		});

      
       
     //老师查看信息事件
         lookteachertinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("查看任课教师信息");
		
	}
});
  
        
         
         
      

    

 
    //按成绩查询事件
selectjMenu3.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("按学号查询成绩");

}
});



        


//关于我们事件
aboutjMenuItem11.addActionListener(new ActionListener() {



	public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "开发团队：红鲤鱼与绿鲤鱼与驴队" + "\n组长：朱雨鹏   " + 
                         "\n组员：陈钲禧 黄咪咪 郭钦 陈艺文 " ,
                "学生成绩管理系统" , JOptionPane.INFORMATION_MESSAGE);
    

}
});


//修改密码事件
updatepasswordjMenuItem12.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {

	ChangePassword3 changePassword3=new ChangePassword3("修改密码");
}
});
     
        
        
        
        // 【退出】按钮
        exitjMenuItem13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
 
    
		
	
		 // 工具栏按钮单击事件
		 
        // 【修改密码】按钮
        btnChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
ChangePassword3 changePassword3=new ChangePassword3("修改密码");
            }
        });
 
        // 【浏览学生信息】按钮
        btnStudentInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           LookStudenInforFrame lookStudenInforFrame=new LookStudenInforFrame("浏览个人信息");
            }
        });
 
        // 【浏览老师信息】按钮
        btnTeacherInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("查看任课老师信息");
            }
        });
 
        // 【成绩查询】按钮
        btngFindGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookGradeFrame gradeFrame=new LookGradeFrame("查看自己成绩");
            }
        });
 
        // 【退出】按钮
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });}
		
		
	  /**
	    * 退出系统
	    */
	    protected void exitSystem() {
	        int choice = JOptionPane.showConfirmDialog(null, "你是否要退出系统？", "学生信息管理系统", JOptionPane.YES_NO_OPTION);
	        if (choice == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        } else {
	            // 关闭当前窗口
	            dispose();
	            Application.mainFrameStudent = new MainFrameStudent("学生成绩管理系统【学生端】");
	        }
	 
	    }

	//public static void main(String[] args) {
		//MainFrame mf = new MainFrame("学生成绩管理系统");}
		

	

}


