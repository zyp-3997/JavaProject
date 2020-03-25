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
import manage.service.impl.GradeServiceImpl;
import manage.service.impl.StudentServiceImpl;

public class LookGradeFrame extends JFrame {
	   
	//����Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * ѧ���ı���
	    */
	
	    //�������ʵ����
	    private GradeServiceImpl gradeServiceImpl;
	    
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
	    JTextField text8;
	    JTextField text9;
	    
	    JButton bprint;
	    JButton brefresh;
	    JButton bexit;
	    
	    //����ʵ����
	    Grade grade;
	    
	    //���ù��췽��
 public  LookGradeFrame(String title) {
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
   pnlNorth.setLayout(new GridLayout(9,2));
   
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new FlowLayout());
  

  
  JLabel label1=new JLabel("ѧ��: ");
  JLabel label2=new JLabel("���: ");
  JLabel label3=new JLabel("����: ");
  JLabel label4=new JLabel("����: ");
  JLabel label5=new JLabel("��ѧ: ");
  JLabel label6=new JLabel("Ӣ��: ");
  JLabel label7=new JLabel("����: ");
  JLabel label8=new JLabel("��ѧ: ");
  JLabel label9=new JLabel("����: ");
  
  text1=new JTextField(11);
  text2=new JTextField(11);
  text3=new JTextField(11);
  text4=new JTextField(11);
  text5=new JTextField(11);
  text6=new JTextField(11);
  text7=new JTextField(11);
  text8=new JTextField(11);
  text9=new JTextField(11);
   
  pnlNorth.add(label1); 
  pnlNorth.add(text1)
  ; 
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
  
  
  pnlNorth.add(label8); 
  pnlNorth.add(text8); 
  
  pnlNorth.add(label9); 
  pnlNorth.add(text9); 
  
  
   text1.setEditable(false);
   text2.setEditable(false);
   text3.setEditable(false);
   text4.setEditable(false);
   text5.setEditable(false);
   text6.setEditable(false);
   text7.setEditable(false);
   text8.setEditable(false);
   text9.setEditable(false);
 
   
 
  
  
  
   bprint=new JButton("��ӡ");
   brefresh=new JButton("ˢ��");
   bexit=new JButton("�˳�");
   
 
  
  southJPanel.add(bprint);
  southJPanel.add(brefresh);
  southJPanel.add(bexit);

  
  
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  frame.add(pnlNorth,BorderLayout.CENTER);
  
  gradeServiceImpl=new GradeServiceImpl();
  
  String id=Application.id+"";
  
  
  
  pnlNorth.add(label1); 
  pnlNorth.add(text1); 
  
  grade=gradeServiceImpl.findgradeById(id);
  
 text1.setText(grade.getStudent_id()+"");
 text2.setText(grade.getStudent_names());
 text3.setText(grade.getClass_names()+"");
 text4.setText(grade.getChinese()+"");
 text5.setText(grade.getMath()+"");
 text6.setText(grade.getEnglish()+"");
 text7.setText(grade.getPhysics()+"");
 text8.setText(grade.getChemistry()+"");
 text9.setText(grade.getBiolog()+"");
		  
  System.out.println(grade);
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
	
	
     
public static void main (String args[]){
	LookGradeFrame lookGradeFrame=new LookGradeFrame("�鿴���˳ɼ�");
}

}
