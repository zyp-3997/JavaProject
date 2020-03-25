package manage.gui;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.Icon;
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



public class MainFrame extends JFrame  {
	
	 /**
	    * 图标对象
	    */
	    private ImageIcon imgCollege;
	    private ImageIcon imgExit;
	    private ImageIcon imgPassword;
	    private ImageIcon imgQuery;
	    private ImageIcon imgBrowse;
	    private ImageIcon imgCount;
	    private ImageIcon imgBackground; 
	    
	
	 /**
	    * 按钮
	    */
	    private JButton btnSetClass;
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
	
    Icon icon = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\Bgadmin.jpg");
   
    
    
    JLabel img = new JLabel();
	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu setjMenu1 = new JMenu("【参数设置】");
	
	JMenu informationjMenu2 = new JMenu("【基本信息】");
	
	
	
	
	JMenu selectJMenu=new JMenu("成绩查询");
	JMenu selectjMenu3 = new JMenu("【成绩操作】");
	
	JMenu managejMenu4 = new JMenu("【系统管理】");
	
	JMenuItem gradejMenuItem1  = new JMenuItem("年级设置");
	JMenuItem classjMenuItem2  = new JMenuItem("班级设置");
	JMenuItem subjectjMenuItem3  = new JMenuItem("考试科目");
	JMenuItem sortjMenuItem4  = new JMenuItem("考试类别");
	
	JMenuItem collegeinforItem=new JMenuItem("学校信息");
	JMenu studentjmenu = new JMenu("学生信息");
	
	
	JMenuItem Addstudentinformation = new JMenuItem("添加学生信息");
	JMenuItem lookstudentinformation = new JMenuItem("查看学生信息");
	JMenuItem updatestudentinformation = new JMenuItem("修改学生信息");
	JMenuItem deletestudentinformation = new JMenuItem("删除学生信息");
	
	
	JMenu teacherjMenu  = new JMenu("教师信息");
	
	JMenuItem Addteachertinformation = new JMenuItem("添加老师信息");
	JMenuItem lookteachertinformation = new JMenuItem("查看老师信息");
	JMenuItem updateteacherinformation = new JMenuItem("修改老师信息");
	JMenuItem deleteteacherinformation = new JMenuItem("删除老师信息");
	
	
	JMenuItem updategradejMenuItem7  = new JMenuItem("成绩添加");
	JMenuItem updategradejMenuItem8  = new JMenuItem("成绩更改");

	JMenuItem deletegradejMenuItem10  = new JMenuItem("成绩删除");
	JMenuItem selectgradebyId = new JMenuItem("按学号查询");
	JMenuItem selectgradebyname  = new JMenuItem("按姓名查询");
	JMenuItem selectgradebyclass = new JMenuItem("按班级查询");
	
	
	
	JMenuItem aboutjMenuItem11 = new JMenuItem("关于我们");
	JMenuItem updatepasswordjMenuItem12 = new JMenuItem("修改密码");
	JMenuItem exitjMenuItem13 = new JMenuItem("退出系统");
	
	
	Dimension faceSize = new Dimension(400, 600);	
	 JPanel p = new JPanel();
	 
    
    BorderLayout bord = new BorderLayout();

	public MainFrame(String title){
		super(title);
		Start();
	}
		public void Start(){
			

		    // 创建图标对象
		    imgCollege = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\2.png");
		    imgPassword = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\student.png");
		    imgQuery = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\teacher.png");
		    imgBrowse = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\select.png");
		    imgCount = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\update.png");
		    imgExit = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\exit.png");
		    
		 // 创建工具栏
	        toolbar = new JToolBar();
	        btnSetClass = new JButton("班级设置", imgCollege);
	        btnSetClass.setToolTipText("设置班级参数");
	        
	        //设置标签的文本相对其图像的垂直位置。
	        
	        btnSetClass.setVerticalTextPosition(AbstractButton.BOTTOM);
	     
	        btnSetClass.setHorizontalTextPosition(AbstractButton.CENTER);
	        btnChangePassword = new JButton("修改密码", imgPassword);
	        btnChangePassword.setToolTipText("修改管理员密码");//在控件上显示提示信息
	        btnChangePassword.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnChangePassword.setHorizontalTextPosition(AbstractButton.CENTER);
	        btnStudentInfor = new JButton("学生信息", imgBrowse);
	        btnStudentInfor.setToolTipText("浏览学生信息");
	        btnStudentInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnStudentInfor.setHorizontalTextPosition(AbstractButton.CENTER);
	        
	        btnTeacherInfor = new JButton("老师信息", imgQuery);
	        btnTeacherInfor.setToolTipText("浏览老师信息");
	        btnTeacherInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnTeacherInfor.setHorizontalTextPosition(AbstractButton.CENTER);
	        
	        btngFindGrade = new JButton("成绩查询", imgCount);
	        btngFindGrade.setToolTipText("按学号查询成绩");
	        btngFindGrade.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btngFindGrade.setHorizontalTextPosition(AbstractButton.CENTER);
	        btnExit = new JButton("退出系统", imgExit);
	        btnExit.setToolTipText("退出系统");
	        btnExit.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnExit.setHorizontalTextPosition(AbstractButton.CENTER);
	        
	        toolbar.add(btnSetClass);
	        
	        toolbar.add(btnStudentInfor);
	        toolbar.add(btnTeacherInfor);
	        toolbar.add(btngFindGrade);
	        toolbar.add(btnChangePassword);
	        toolbar.add(btnExit);
			
		jMenuBar1.add(setjMenu1);
		jMenuBar1.add(informationjMenu2);
		jMenuBar1.add(selectjMenu3);
		jMenuBar1.add(managejMenu4);		
		
		
		
		setjMenu1.add(gradejMenuItem1);
		setjMenu1.add(classjMenuItem2);
		setjMenu1.add(subjectjMenuItem3);
		setjMenu1.add(sortjMenuItem4);
		
		
		
		informationjMenu2.add(collegeinforItem);
		informationjMenu2.add(studentjmenu);
		
		studentjmenu.add(Addstudentinformation);
		studentjmenu.add(lookstudentinformation);
		studentjmenu.add(updatestudentinformation);
		studentjmenu.add(deletestudentinformation);
		
		informationjMenu2.add(teacherjMenu);
		
		teacherjMenu.add(Addteachertinformation);
		teacherjMenu.add(lookteachertinformation);
		teacherjMenu.add(updateteacherinformation);
		teacherjMenu.add(deleteteacherinformation);
		
		
		selectjMenu3.add(updategradejMenuItem7);
		selectjMenu3.add(updategradejMenuItem8);
		selectjMenu3.add(selectJMenu);
		selectjMenu3.add(deletegradejMenuItem10);
		
		selectJMenu.add(selectgradebyId);
		selectJMenu.add(selectgradebyname);
		selectJMenu.add(selectgradebyclass);
		
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
		
		// 关闭窗口单击事件
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });
        
        //设置学校信息
        collegeinforItem.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				SetCollegeInformationFrame setCollegeInformationFrame=new SetCollegeInformationFrame("修改学校信息");
				
			}
		});
 
        //设置年级事件
        gradejMenuItem1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				SetgradeFrame setgradeFrame=new SetgradeFrame("年级信息设置");
				
			}
		});
        
        //班级事件
        classjMenuItem2.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				 SetClassFrame setClassFrame=new SetClassFrame("班级信息设置");
				
			}
		});
        
        //考试科目事件
        subjectjMenuItem3.addActionListener(new ActionListener() {
    		
        	public void actionPerformed(ActionEvent arg0) {
				SetSubjectFrame setSubjectFrame=new SetSubjectFrame("考试科目设置");
				
			}
		});
        
        //考试类别事件
        sortjMenuItem4.addActionListener(new ActionListener() {
    		
        	public void actionPerformed(ActionEvent arg0) {
        		SetSortFrame setSortFrame=new SetSortFrame("考试类别设置") ;
        	}

		});
        
        //学生添加信息
    Addstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				AddStudentInforFrame addStudentInforFrame=new AddStudentInforFrame("添加学生信息");
				
			}
		});
        //学生查看信息事件
       lookstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				LookStudentInforFrame lookStudentInforFrame=new LookStudentInforFrame("查看学生信息");
				
			}
		});
       //学生删除信息事件
       deletestudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				DeleteStudentInfoFrame deleteStudentInfoFrame=new DeleteStudentInfoFrame("删除学生信息");
				
			}
		});
       //学生更新信息事件
       updatestudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				UpdateStudentInforFrame updateStudentInforFrame=new UpdateStudentInforFrame("修改学生信息");
				
			}
		});

       
       //老师添加信息事件
       Addteachertinformation.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent arg0) {
    			AddTeacherInforFrame addTeacherInforFrame=new AddTeacherInforFrame("添加教师信息");
    			
    		}
    	});
       
     //老师查看信息事件
         lookteachertinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("查看教师信息");
		
	}
});
  
         //老师修改信息事件
         updateteacherinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		UpdataTeacherInforFrame updataTeacherInforFrame=new UpdataTeacherInforFrame("修改老师信息");
		
	}
});
         //老师删除信息事件
        deleteteacherinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		DeleteTeacherInforFrame deleteTeacherInforFrame=new DeleteTeacherInforFrame("删除教师信息");
		
	}
});
        
        //成绩添加事件
        updategradejMenuItem7.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		AddStudentGradeFrame addStudentGradeFrame=new AddStudentGradeFrame("添加学生成绩");
        	}
        });
         
         
         //成绩插入事件
      updategradejMenuItem8.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		UpdateStudentGradeFrame updateStudentGradeFrame=new UpdateStudentGradeFrame("学生成绩修改");
		
	}
});

      //成绩删除事件
    deletegradejMenuItem10.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		DeleteStudentGradeFrame deleteStudentGradeFrame=new DeleteStudentGradeFrame("学生成绩删除");
		
	}
});

 
    //按学号查询事件
selectgradebyId.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("按学号查询成绩");

}
});


//按姓名查询事件
selectgradebyname.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByNameFrame findStudentByNameFrame=new FindStudentByNameFrame("按姓名查询成绩");

}
});
        
//按班级查询事件
selectgradebyclass.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByClassFrame findStudentByClassFrame=new FindStudentByClassFrame("按班级查询成绩");
	
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
ChangePasswordFrame changePasswordFrame=new ChangePasswordFrame("修改密码");

}
});

     
        
        
        
        // 【退出】时间
        exitjMenuItem13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
 
    
     // 工具栏按钮单击事件
        // 【设置班级】按钮
        btnSetClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
SetClassFrame setClassFrame=new SetClassFrame("班级设置");
            }
        });
 
        // 【修改密码】按钮
        btnChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ChangePasswordFrame changePasswordFrame=new ChangePasswordFrame("修改密码");
            }
        });
 
        // 【浏览学生信息】按钮
        btnStudentInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookStudentInforFrame lookStudentInforFrame=new LookStudentInforFrame("学生信息");
            }
        });
 
        // 【浏览老师信息】按钮
        btnTeacherInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("老师信息");
            }
        });
 
        // 【成绩查询】按钮
        btngFindGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("按学号查询成绩");
            }
        });
 
        // 【退出】按钮
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
        
        
        
		
	}
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
	            Application.mainFrame = new MainFrame("学生成绩管理系统【管理员】");
	        }
	 
	    }

	//public static void main(String[] args) {
		//MainFrame mf = new MainFrame("学生成绩管理系统");}
		

	

}


