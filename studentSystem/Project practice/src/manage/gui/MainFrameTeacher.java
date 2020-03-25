package manage.gui;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.PublicKey;

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
import javax.xml.stream.events.StartDocument;

import manage.app.Application;
import manage.teachergui.ChangePassword2;
import manage.teachergui.LookStudentInforFrame;
import manage.teachergui.LookTeacherinforFrame;
import manage.teachergui.UpdateGradeFrame;
import manage.teachergui.UpdateTeacherInforFrame;


public class MainFrameTeacher extends JFrame  {
	
	/**
	    * ͼ�����
	    */
	    private ImageIcon imgExit;
	    private ImageIcon imgPassword;
	    private ImageIcon imgQuery;
	    private ImageIcon imgBrowse;
	    private ImageIcon imgCount;
	    
	
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
    Icon icon = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\Bgteacher.jpg");
   
    
    JLabel img = new JLabel();
	JMenuBar jMenuBar1 = new JMenuBar();
	
	JMenu informationjMenu2 = new JMenu("��������Ϣ��");
	
	
	
	
	JMenu selectjMenu3 = new JMenu("���ɼ�������");
	
	JMenu managejMenu4 = new JMenu("��ϵͳ����");
	
	
	JMenu studentjmenu = new JMenu("ѧ����Ϣ");
	
	JMenuItem lookstudentinformation = new JMenuItem("�鿴����ѧ����Ϣ");
	
	JMenu teacherjMenu  = new JMenu("������Ϣ");
	JMenuItem collegeinforItem=new JMenuItem("ѧУ��Ϣ");
	JMenuItem lookteachertinformation = new JMenuItem("�鿴������Ϣ");
	JMenuItem updateteacherinformation = new JMenuItem("�޸ĸ�����Ϣ");
	
	

	JMenuItem addgradejMenuItem8  = new JMenuItem("�ɼ����");
	JMenuItem updategradejMenuItem8  = new JMenuItem("�ɼ�����");
	JMenuItem selectgradebyId = new JMenuItem("�ɼ���ѯ");
	JMenuItem deletegradejMenuItem10  = new JMenuItem("�ɼ�ɾ��");
	;
	
	
	
	JMenuItem aboutjMenuItem11 = new JMenuItem("��������");
	JMenuItem updatepasswordjMenuItem12 = new JMenuItem("�޸�����");
	JMenuItem exitjMenuItem13 = new JMenuItem("�˳�ϵͳ");
	
	
	Dimension faceSize = new Dimension(400, 600);	
	 JPanel p = new JPanel();
   
 
    BorderLayout bord = new BorderLayout();

	public MainFrameTeacher(String title){
		super(title);
		Start();
	}
		public void Start(){
			 // ����ͼ�����
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
	        
	        btnStudentInfor = new JButton("ѧ����Ϣ", imgBrowse);
	        btnStudentInfor.setToolTipText("����Լ�����ѧ����Ϣ");
	        btnStudentInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnStudentInfor.setHorizontalTextPosition(AbstractButton.CENTER);
	        
	        btnTeacherInfor = new JButton("������Ϣ", imgQuery);
	        btnTeacherInfor.setToolTipText("����Լ���Ϣ");
	        btnTeacherInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnTeacherInfor.setHorizontalTextPosition(AbstractButton.CENTER);
	        
	        btngFindGrade = new JButton("�ɼ���ѯ", imgCount);
	        btngFindGrade.setToolTipText("��ѧ�Ų�ѯ�ɼ�");
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
		
		informationjMenu2.add(teacherjMenu);
		
		teacherjMenu.add(lookteachertinformation);
		teacherjMenu.add(updateteacherinformation);
		
		
		selectjMenu3.add(addgradejMenuItem8 );
		selectjMenu3.add(updategradejMenuItem8);
		selectjMenu3.add(selectgradebyId);
		selectjMenu3.add(deletegradejMenuItem10);
		
		
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
        //ѧ���鿴��Ϣ�¼�
       lookstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {

				LookStudentInforFrame lookStudentInforFrame=new LookStudentInforFrame("�鿴����ѧ����Ϣ");
				
			}
		});
       
     //��ʦ�鿴��Ϣ�¼�
         lookteachertinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		LookTeacherinforFrame lookTeacherinforFrame=new LookTeacherinforFrame("�鿴������Ϣ");
		
	}
});
  
         //��ʦ�޸���Ϣ�¼�
         updateteacherinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		UpdateTeacherInforFrame updateTeacherInforFrame=new UpdateTeacherInforFrame("�޸ĸ�����Ϣ");
	}
});
         
         addgradejMenuItem8.addActionListener(new ActionListener() {
        		
        		public void actionPerformed(ActionEvent arg0) {

 AddStudentGradeFrame addStudentGradeFrame=new AddStudentGradeFrame("�ɼ����");       			
        		}
        	});
         //�ɼ������¼�
      updategradejMenuItem8.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {

		UpdateStudentGradeFrame updateStudentGradeFrame=new UpdateStudentGradeFrame("�޸�ѧ���ɼ�");
	}
});

      //�ɼ�ɾ���¼�
    deletegradejMenuItem10.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		DeleteStudentGradeFrame deleteStudentGradeFrame=new DeleteStudentGradeFrame("ѧ���ɼ�ɾ��");
		
	}
});

 
    //��ѧ�Ų�ѯ�¼�
    selectgradebyId.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("ѧ���ɼ���ѯ");

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
ChangePassword2 changePassword2=new ChangePassword2("�޸�����");
	
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
            @Override
            public void actionPerformed(ActionEvent e) {
            	ChangePassword2 changePassword2=new ChangePassword2("�޸�����");
            }
        });
 
        // �����ѧ����Ϣ����ť
        btnStudentInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            LookStudentInforFrame studentInforFrame=new LookStudentInforFrame("�������ѧ����Ϣ");
            }
        });
 
        // �������ʦ��Ϣ����ť
        btnTeacherInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LookTeacherinforFrame lookTeacherinforFrame=new LookTeacherinforFrame("�鿴������Ϣ");   
            	
            }
        });
 
        // ���ɼ���ѯ����ť
        btngFindGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("��ѧ�Ų�ѯ�ɼ�");
            }
        });
 
        // ���˳�����ť
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
        
        
		
	}
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
	            Application.mainFrameTeacher=new MainFrameTeacher("ѧ���ɼ��޸�ϵͳ����ʦ�ˡ�");
	        }
	 
	    }

	public static void main(String[] args) {
MainFrameTeacher mainFrameTeacher=new MainFrameTeacher("");		

	

}
}
