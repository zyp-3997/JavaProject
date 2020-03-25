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
	    * ͼ�����
	    */
	    private ImageIcon imgCollege;
	    private ImageIcon imgExit;
	    private ImageIcon imgPassword;
	    private ImageIcon imgQuery;
	    private ImageIcon imgBrowse;
	    private ImageIcon imgCount;
	    private ImageIcon imgBackground; 
	    
	
	 /**
	    * ��ť
	    */
	    private JButton btnSetClass;
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
	
    Icon icon = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\Bgadmin.jpg");
   
    
    
    JLabel img = new JLabel();
	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu setjMenu1 = new JMenu("���������á�");
	
	JMenu informationjMenu2 = new JMenu("��������Ϣ��");
	
	
	
	
	JMenu selectJMenu=new JMenu("�ɼ���ѯ");
	JMenu selectjMenu3 = new JMenu("���ɼ�������");
	
	JMenu managejMenu4 = new JMenu("��ϵͳ����");
	
	JMenuItem gradejMenuItem1  = new JMenuItem("�꼶����");
	JMenuItem classjMenuItem2  = new JMenuItem("�༶����");
	JMenuItem subjectjMenuItem3  = new JMenuItem("���Կ�Ŀ");
	JMenuItem sortjMenuItem4  = new JMenuItem("�������");
	
	JMenuItem collegeinforItem=new JMenuItem("ѧУ��Ϣ");
	JMenu studentjmenu = new JMenu("ѧ����Ϣ");
	
	
	JMenuItem Addstudentinformation = new JMenuItem("���ѧ����Ϣ");
	JMenuItem lookstudentinformation = new JMenuItem("�鿴ѧ����Ϣ");
	JMenuItem updatestudentinformation = new JMenuItem("�޸�ѧ����Ϣ");
	JMenuItem deletestudentinformation = new JMenuItem("ɾ��ѧ����Ϣ");
	
	
	JMenu teacherjMenu  = new JMenu("��ʦ��Ϣ");
	
	JMenuItem Addteachertinformation = new JMenuItem("�����ʦ��Ϣ");
	JMenuItem lookteachertinformation = new JMenuItem("�鿴��ʦ��Ϣ");
	JMenuItem updateteacherinformation = new JMenuItem("�޸���ʦ��Ϣ");
	JMenuItem deleteteacherinformation = new JMenuItem("ɾ����ʦ��Ϣ");
	
	
	JMenuItem updategradejMenuItem7  = new JMenuItem("�ɼ����");
	JMenuItem updategradejMenuItem8  = new JMenuItem("�ɼ�����");

	JMenuItem deletegradejMenuItem10  = new JMenuItem("�ɼ�ɾ��");
	JMenuItem selectgradebyId = new JMenuItem("��ѧ�Ų�ѯ");
	JMenuItem selectgradebyname  = new JMenuItem("��������ѯ");
	JMenuItem selectgradebyclass = new JMenuItem("���༶��ѯ");
	
	
	
	JMenuItem aboutjMenuItem11 = new JMenuItem("��������");
	JMenuItem updatepasswordjMenuItem12 = new JMenuItem("�޸�����");
	JMenuItem exitjMenuItem13 = new JMenuItem("�˳�ϵͳ");
	
	
	Dimension faceSize = new Dimension(400, 600);	
	 JPanel p = new JPanel();
	 
    
    BorderLayout bord = new BorderLayout();

	public MainFrame(String title){
		super(title);
		Start();
	}
		public void Start(){
			

		    // ����ͼ�����
		    imgCollege = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\2.png");
		    imgPassword = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\student.png");
		    imgQuery = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\teacher.png");
		    imgBrowse = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\select.png");
		    imgCount = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\update.png");
		    imgExit = new ImageIcon("E:\\study\\java jdk\\Project practice\\images\\exit.png");
		    
		 // ����������
	        toolbar = new JToolBar();
	        btnSetClass = new JButton("�༶����", imgCollege);
	        btnSetClass.setToolTipText("���ð༶����");
	        
	        //���ñ�ǩ���ı������ͼ��Ĵ�ֱλ�á�
	        
	        btnSetClass.setVerticalTextPosition(AbstractButton.BOTTOM);
	     
	        btnSetClass.setHorizontalTextPosition(AbstractButton.CENTER);
	        btnChangePassword = new JButton("�޸�����", imgPassword);
	        btnChangePassword.setToolTipText("�޸Ĺ���Ա����");//�ڿؼ�����ʾ��ʾ��Ϣ
	        btnChangePassword.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnChangePassword.setHorizontalTextPosition(AbstractButton.CENTER);
	        btnStudentInfor = new JButton("ѧ����Ϣ", imgBrowse);
	        btnStudentInfor.setToolTipText("���ѧ����Ϣ");
	        btnStudentInfor.setVerticalTextPosition(AbstractButton.BOTTOM);
	        btnStudentInfor.setHorizontalTextPosition(AbstractButton.CENTER);
	        
	        btnTeacherInfor = new JButton("��ʦ��Ϣ", imgQuery);
	        btnTeacherInfor.setToolTipText("�����ʦ��Ϣ");
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
		
		// �رմ��ڵ����¼�
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitSystem();
            }
        });
        
        //����ѧУ��Ϣ
        collegeinforItem.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				SetCollegeInformationFrame setCollegeInformationFrame=new SetCollegeInformationFrame("�޸�ѧУ��Ϣ");
				
			}
		});
 
        //�����꼶�¼�
        gradejMenuItem1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				SetgradeFrame setgradeFrame=new SetgradeFrame("�꼶��Ϣ����");
				
			}
		});
        
        //�༶�¼�
        classjMenuItem2.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				 SetClassFrame setClassFrame=new SetClassFrame("�༶��Ϣ����");
				
			}
		});
        
        //���Կ�Ŀ�¼�
        subjectjMenuItem3.addActionListener(new ActionListener() {
    		
        	public void actionPerformed(ActionEvent arg0) {
				SetSubjectFrame setSubjectFrame=new SetSubjectFrame("���Կ�Ŀ����");
				
			}
		});
        
        //��������¼�
        sortjMenuItem4.addActionListener(new ActionListener() {
    		
        	public void actionPerformed(ActionEvent arg0) {
        		SetSortFrame setSortFrame=new SetSortFrame("�����������") ;
        	}

		});
        
        //ѧ�������Ϣ
    Addstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				AddStudentInforFrame addStudentInforFrame=new AddStudentInforFrame("���ѧ����Ϣ");
				
			}
		});
        //ѧ���鿴��Ϣ�¼�
       lookstudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				LookStudentInforFrame lookStudentInforFrame=new LookStudentInforFrame("�鿴ѧ����Ϣ");
				
			}
		});
       //ѧ��ɾ����Ϣ�¼�
       deletestudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				DeleteStudentInfoFrame deleteStudentInfoFrame=new DeleteStudentInfoFrame("ɾ��ѧ����Ϣ");
				
			}
		});
       //ѧ��������Ϣ�¼�
       updatestudentinformation.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent arg0) {
				UpdateStudentInforFrame updateStudentInforFrame=new UpdateStudentInforFrame("�޸�ѧ����Ϣ");
				
			}
		});

       
       //��ʦ�����Ϣ�¼�
       Addteachertinformation.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent arg0) {
    			AddTeacherInforFrame addTeacherInforFrame=new AddTeacherInforFrame("��ӽ�ʦ��Ϣ");
    			
    		}
    	});
       
     //��ʦ�鿴��Ϣ�¼�
         lookteachertinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("�鿴��ʦ��Ϣ");
		
	}
});
  
         //��ʦ�޸���Ϣ�¼�
         updateteacherinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		UpdataTeacherInforFrame updataTeacherInforFrame=new UpdataTeacherInforFrame("�޸���ʦ��Ϣ");
		
	}
});
         //��ʦɾ����Ϣ�¼�
        deleteteacherinformation.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		DeleteTeacherInforFrame deleteTeacherInforFrame=new DeleteTeacherInforFrame("ɾ����ʦ��Ϣ");
		
	}
});
        
        //�ɼ�����¼�
        updategradejMenuItem7.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		AddStudentGradeFrame addStudentGradeFrame=new AddStudentGradeFrame("���ѧ���ɼ�");
        	}
        });
         
         
         //�ɼ������¼�
      updategradejMenuItem8.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent arg0) {
		UpdateStudentGradeFrame updateStudentGradeFrame=new UpdateStudentGradeFrame("ѧ���ɼ��޸�");
		
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
	FindStudentByIdFrame findStudentByIdFrame=new FindStudentByIdFrame("��ѧ�Ų�ѯ�ɼ�");

}
});


//��������ѯ�¼�
selectgradebyname.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByNameFrame findStudentByNameFrame=new FindStudentByNameFrame("��������ѯ�ɼ�");

}
});
        
//���༶��ѯ�¼�
selectgradebyclass.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {
	FindStudentByClassFrame findStudentByClassFrame=new FindStudentByClassFrame("���༶��ѯ�ɼ�");
	
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
ChangePasswordFrame changePasswordFrame=new ChangePasswordFrame("�޸�����");

}
});

     
        
        
        
        // ���˳���ʱ��
        exitjMenuItem13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitSystem();
            }
        });
 
    
     // ��������ť�����¼�
        // �����ð༶����ť
        btnSetClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
SetClassFrame setClassFrame=new SetClassFrame("�༶����");
            }
        });
 
        // ���޸����롿��ť
        btnChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ChangePasswordFrame changePasswordFrame=new ChangePasswordFrame("�޸�����");
            }
        });
 
        // �����ѧ����Ϣ����ť
        btnStudentInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookStudentInforFrame lookStudentInforFrame=new LookStudentInforFrame("ѧ����Ϣ");
            }
        });
 
        // �������ʦ��Ϣ����ť
        btnTeacherInfor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("��ʦ��Ϣ");
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
	            Application.mainFrame = new MainFrame("ѧ���ɼ�����ϵͳ������Ա��");
	        }
	 
	    }

	//public static void main(String[] args) {
		//MainFrame mf = new MainFrame("ѧ���ɼ�����ϵͳ");}
		

	

}


