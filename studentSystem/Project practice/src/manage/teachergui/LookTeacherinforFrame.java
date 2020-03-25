package manage.teachergui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import manage.app.Application;
import manage.bean.Grade;
import manage.bean.Student;
import manage.bean.Teacher;
import manage.service.impl.StudentServiceImpl;
import manage.service.impl.TeacherServiceImpl;

public class LookTeacherinforFrame extends JFrame {
	   
	//����Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * ѧ���ı���
	    */
	
	    //�������ʵ����
	    private TeacherServiceImpl teacherServiceImpl;
	    
	    //����gui���
	    private JTable table;
	    private JScrollPane scroller;
	    JPanel frame;
	    JTextField text1;
	    JTextField text2;
	    JTextField text3;
	    JTextField text4;
	    JTextField text5;
	    JTextField text6;
	    JTextField text7;
	    
	    JButton bprint;
	    JButton brefresh;
	    JButton bexit;
	    
	    //����ʵ����
	    Teacher teacher;
	    
	    //���ù��췽��
 public LookTeacherinforFrame(String title) {
	 super(title);
	 Start();
 }
 //����ִ�з���
	public void Start(){
		 table=new JTable();
		//vectorʵ����
		rows=new Vector();
		 colHead=new Vector();
		 
		 //gui�������
		 
		   frame = (JPanel) getContentPane();
   frame.setLayout(new BorderLayout());
  
   JPanel pnlNorth=new JPanel();
   pnlNorth.setLayout(new GridLayout(7,2));
   
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new FlowLayout());
  

  

  JLabel label1=new JLabel("����:");
  JLabel label2=new JLabel("���: ");
  JLabel label3=new JLabel("����: ");
  JLabel label4=new JLabel("�Ա�: ");
  JLabel label5=new JLabel("רҵ: ");
  JLabel label6=new JLabel("ˮƽ: ");
  JLabel label7=new JLabel("�绰: ");
  
  text1=new JTextField(11);
  text2=new JTextField(11);
  text3=new JTextField(11);
  text4=new JTextField(11);
  text5=new JTextField(11);
  text6=new JTextField(11);
  text7=new JTextField(11);
   
  pnlNorth.add(label1); 
  pnlNorth.add(text1); 
  pnlNorth.add(label2); 
  pnlNorth.add(text2); 
  
  pnlNorth.add(label3); 
  pnlNorth.add(text3); 
  
  pnlNorth.add(label4); 
  pnlNorth.add(text4); 
  
  pnlNorth.add(label5); 
  pnlNorth.add(text5); 
  
  pnlNorth.add(label6); 
  pnlNorth.add(text6); 
  
  pnlNorth.add(label7); 
  pnlNorth.add(text7); 
  
  
  
   text1.setEditable(false);
   text2.setEditable(false);
   text3.setEditable(false);
   text4.setEditable(false);
   text5.setEditable(false);
   text6.setEditable(false);
   text7.setEditable(false);
 
   
 
  
  
  
   bprint=new JButton("��ӡ");
   brefresh=new JButton("ˢ��");
   bexit=new JButton("�˳�");
   
 
  
  southJPanel.add(bprint);
  southJPanel.add(brefresh);
  southJPanel.add(bexit);

  
  
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  frame.add(pnlNorth,BorderLayout.CENTER);
  
  teacherServiceImpl=new TeacherServiceImpl();
  String id=Application.id+"";
  
  
  
  pnlNorth.add(label1); 
  pnlNorth.add(text1); 
  teacher=teacherServiceImpl.findinforById(id);
  
 text1.setText(teacher.getTeacher_id()+"");
 text2.setText(teacher.getClass_id()+"");
 text3.setText(teacher.getTeacher_name()+"");
 text4.setText(teacher.getTeacher_sex()+"");
 text5.setText(teacher.getTeacher_major()+"");
 text6.setText(teacher.getTeacher_level()+"");
 text7.setText(teacher.getTeacher_tel()+"");
		  
  System.out.println(teacher);
  //��ʾ���������
  pack();
 
  setSize(300,350);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // �ػ洰��
  repaint();
 
  //��ӡ��ť
  bprint.addActionListener(new ActionListener() {
	  @Override
      public void actionPerformed(ActionEvent e) {
          try {
        	 
              table.print();
          } catch (PrinterException e1) {
              e1.printStackTrace();
          }
      }
  });
  
  //���ˢ�°�ť�¼�
  brefresh.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
  });
  
  
  //����˳���ť�¼�
  bexit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
          dispose();
      }
  });  
  
  
 
 }
	
	
     

}
