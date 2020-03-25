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
	    * ͼ�����
	    */
	    private ImageIcon imgExit;
	    private ImageIcon imgPassword;
	    private ImageIcon imgQuery;
	    private ImageIcon imgBrowse;
	    private ImageIcon imgCount;
	    private ImageIcon imgBackground; 
	    
	
	 /**
	    * ��ť
	    */
	    private JButton btnChangePassword;
	    private JButton btnStudentInfor;
	    private JButton btnExit;
	    private JButton btnTeacherInfor;
	    private JButton btngFindGrade;
	

	    /**
	    * ������
	    */
	    private JToolBar toolbar;
	Container contentPane = getContentPane();
    Icon icon = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\Bgstudent.jpg");
    JLabel img = new JLabel();
	JMenuBar jMenuBar1 = new JMenuBar();
	
	JMenu informationjMenu2 = new JMenu("��������Ϣ��");
	
	
	
	
	JMenu selectjMenu3 = new JMenu("���鿴�ɼ���");
	JMenuItem selectJMenuItem=new JMenuItem("���˳ɼ�");
	
	JMenu managejMenu4 = new JMenu("��ϵͳ����");
	
	JMenuItem collegeinforItem=new JMenuItem("ѧУ��Ϣ");
	JMenu studentjmenu = new JMenu("������Ϣ");
	
	JMenuItem lookstudentinformation = new JMenuItem("�鿴������Ϣ");
	JMenuItem updatestudentinformation = new JMenuItem("�޸ĸ�����Ϣ");
	
	
	JMenu teacherjMenu  = new JMenu("��ʦ��Ϣ");
	
	JMenuItem lookteachertinformation = new JMenuItem("�鿴�ο���ʦ��Ϣ");
		
	
	
	JMenuItem aboutjMenuItem11 = new JMenuItem("��������");
	JMenuItem updatepasswordjMenuItem12 = new JMenuItem("�޸�����");
	JMenuItem exitjMenuItem13 = new JMenuItem("�˳�ϵͳ");
	
	
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
			    
			 // ����������
		        toolbar = new JToolBar();
		        btnChangePassword = new JButton("�޸�����", imgPassword);
		        btnChangePassword.setToolTipText("�޸�ѧ������");//�ڿؼ�����ʾ��ʾ��Ϣ
		        btnChangePassword.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnChangePassword.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        btnStudentInfor = new JButton("������Ϣ", imgBrowse);
		        btnStudentInfor.setToolTipText("����Լ���Ϣ");
		        btnStudentInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnStudentInfor.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        btnTeacherInfor = new JButton("��ʦ��Ϣ", imgQuery);
		        btnTeacherInfor.setToolTipText("����ο���ʦ��Ϣ");
		        btnTeacherInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btnTeacherInfor.setHorizontalTextPosition(AbstractButton.CENTER);
		        
		        btngFindGrade = new JButton("�鿴�ɼ�", imgCount);
		        btngFindGrade.setToolTipText("�鿴�Լ��ɼ�");
		        btngFindGrade.setVerticalTextPosition(AbstractButton.BOTTOM);
		        btngFindGrade.setHorizontalTextPosition(AbstractButton.CENTER);
		        btnExit = new JButton("�˳�ϵͳ", imgExit);
		        btnExit.setToolTipText("�˳�ϵͳ");
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
		  
		  //����ѧУ��Ϣ
	        collegeinforItem.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {

					LookCollegeInforFrame lookCollegeInforFrame=new LookCollegeInforFrame("�鿴��ѧ��Ϣ");
				}
			});
		
		// �رմ��ڵ����¼�
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });
 
        //ѧ���鿴���˳ɼ�
        selectJMenuItem.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				LookGradeFrame lookGradeFrame=new LookGradeFrame("�鿴���˳ɼ�");
				
			}
		});
        
        //ѧ���鿴��Ϣ�¼�
       lookstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				LookStudenInforFrame lookStudentInforFrame=new LookStudenInforFrame("�鿴������Ϣ");
				
			}
		});
     
       //ѧ��������Ϣ�¼�
       updatestudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				UpdateStudenInforFrame updateStudenInforFrame=new UpdateStudenInforFrame("�޸ĸ�����Ϣ");
				
			}
		});

      
       
     //��ʦ�鿴��Ϣ�¼�
         lookteachertinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("�鿴�ον�ʦ��Ϣ");
		
	}
});
  
        
         
         
      

    

 
    //���ɼ���ѯ�¼�
selectjMenu3.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("��ѧ�Ų�ѯ�ɼ�");

}
});



        


//���������¼�
aboutjMenuItem11.addActionListener(new ActionListener() {



	public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "�����Ŷӣ�����������������¿��" + "\n�鳤��������   " + 
                         "\n��Ա�������� ������ ���� ������ " ,
                "ѧ���ɼ�����ϵͳ" , JOptionPane.INFORMATION_MESSAGE);
    

}
});


//�޸������¼�
updatepasswordjMenuItem12.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {

	ChangePassword3 changePassword3=new ChangePassword3("�޸�����");
}
});
     
        
        
        
        // ���˳�����ť
        exitjMenuItem13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
 
    
		
	
		 // ��������ť�����¼�
		 
        // ���޸����롿��ť
        btnChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
ChangePassword3 changePassword3=new ChangePassword3("�޸�����");
            }
        });
 
        // �����ѧ����Ϣ����ť
        btnStudentInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           LookStudenInforFrame lookStudenInforFrame=new LookStudenInforFrame("���������Ϣ");
            }
        });
 
        // �������ʦ��Ϣ����ť
        btnTeacherInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("�鿴�ο���ʦ��Ϣ");
            }
        });
 
        // ���ɼ���ѯ����ť
        btngFindGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookGradeFrame gradeFrame=new LookGradeFrame("�鿴�Լ��ɼ�");
            }
        });
 
        // ���˳�����ť
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });}
		
		
	  /**
	    * �˳�ϵͳ
	    */
	    protected void exitSystem() {
	        int choice = JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫ�˳�ϵͳ��", "ѧ����Ϣ����ϵͳ", JOptionPane.YES_NO_OPTION);
	        if (choice == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        } else {
	            // �رյ�ǰ����
	            dispose();
	            Application.mainFrameStudent = new MainFrameStudent("ѧ���ɼ�����ϵͳ��ѧ���ˡ�");
	        }
	 
	    }

	//public static void main(String[] args) {
		//MainFrame mf = new MainFrame("ѧ���ɼ�����ϵͳ");}
		

	

}


