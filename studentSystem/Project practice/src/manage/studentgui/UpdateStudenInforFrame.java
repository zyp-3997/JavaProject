package manage.studentgui;

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
import manage.service.impl.StudentServiceImpl;

public class UpdateStudenInforFrame extends JFrame {
	   
	//����Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * ѧ���ı���
	    */
	
	    //�������ʵ����
	    private StudentServiceImpl studentServiceImpl;
	    
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
	    
	    JButton  bupdate;
	    JButton brefresh;
	    JButton  bexit;
	    
	    //����ʵ����
	    Student student;
	    
	    //���ù��췽��
 public UpdateStudenInforFrame(String title) {
	 super(title);
	 Start();
 }
 //����ִ�з���
	public void Start(){
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
  

  
  JLabel label1=new JLabel("ѧ��: ");
  JLabel label2=new JLabel("���: ");
  JLabel label3=new JLabel("����: ");
  JLabel label4=new JLabel("�Ա�: ");
  JLabel label5=new JLabel("����: ");
  JLabel label6=new JLabel("��ַ: ");
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

   
 
  
  
  
   bupdate=new JButton("�޸�");
   brefresh=new JButton("ˢ��");
   bexit=new JButton("�˳�");
   
 
  
  southJPanel.add(bupdate);
  southJPanel.add(brefresh);
  southJPanel.add(bexit);

  
  
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  frame.add(pnlNorth,BorderLayout.CENTER);
  
  studentServiceImpl =new StudentServiceImpl();
  

  
  
  
  pnlNorth.add(label1); 
  pnlNorth.add(text1); 
  
  update();  
  System.out.println(student);
  //��ʾ���������
  pack();
 
  setSize(300,350);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // �ػ洰��
  repaint();
 
  //�޸İ�ť
  bupdate.addActionListener(new ActionListener() {
	  @Override
      public void actionPerformed(ActionEvent e) {
		  student=new Student();
			student.setStudent_id(Integer.parseInt(text1.getText()));
			student.setClass_id(Integer.parseInt(text2.getText()));
			student.setStudent_name((text3.getText()));
			student.setStudent_sex((text4.getText()));
			student.setStudent_age(Integer.parseInt(text5.getText()));
			student.setStudent_adress((text6.getText()));
			student.setStudent_tel(Integer.parseInt(text7.getText()));
			
			int count=studentServiceImpl.updateinfor(student);

			if (count > 0) {
			    JOptionPane.showMessageDialog(null, "�ɼ��޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			    // ���»�ȡȫ��ѧ���б�
			    text1.setText("");
			    text2.setText("");
			    text3.setText("");
			    text4.setText("");
			    text5.setText("");
			    text6.setText("");
			    text7.setText("");
			    update();
			    // �������
			    
			} else {
				System.out.print(count);
			    JOptionPane.showMessageDialog(null, "�ɼ��޸�ʧ�ܣ�", "����", JOptionPane.WARNING_MESSAGE);
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
	public void update(){
		 String id=Application.id+"";
		student=studentServiceImpl.findinforById(id);
		 text1.setText(student.getStudent_id()+"");
		 text2.setText(student.getClass_id()+"");
		 text3.setText(student.getStudent_name()+"");
		 text4.setText(student.getStudent_sex()+"");
		 text5.setText(student.getStudent_age()+"");
		 text6.setText(student.getStudent_adress()+"");
		 text7.setText(student.getStudent_tel()+"");
	}
	
	

}

