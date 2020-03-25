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
	   
	//定义Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * 学号文本框
	    */
	
	    //定义服务实现类
	    private StudentServiceImpl studentServiceImpl;
	    
	    //定义gui组件
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
	    
	    //定义实体类
	    Student student;
	    
	    //设置构造方法
 public UpdateStudenInforFrame(String title) {
	 super(title);
	 Start();
 }
 //定义执行方法
	public void Start(){
		//vector实例化
		rows=new Vector();
		 colHead=new Vector();
		 
		 //gui界面设计
		 
		   frame = (JPanel) getContentPane();
   frame.setLayout(new BorderLayout());
  
   JPanel pnlNorth=new JPanel();
   pnlNorth.setLayout(new GridLayout(7,2));
   
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new FlowLayout());
  

  
  JLabel label1=new JLabel("学号: ");
  JLabel label2=new JLabel("班号: ");
  JLabel label3=new JLabel("姓名: ");
  JLabel label4=new JLabel("性别: ");
  JLabel label5=new JLabel("年龄: ");
  JLabel label6=new JLabel("地址: ");
  JLabel label7=new JLabel("电话: ");
  
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

   
 
  
  
  
   bupdate=new JButton("修改");
   brefresh=new JButton("刷新");
   bexit=new JButton("退出");
   
 
  
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
  //显示结果集方法
  pack();
 
  setSize(300,350);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // 重绘窗体
  repaint();
 
  //修改按钮
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
			    JOptionPane.showMessageDialog(null, "成绩修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
			    // 重新获取全部学生列表
			    text1.setText("");
			    text2.setText("");
			    text3.setText("");
			    text4.setText("");
			    text5.setText("");
			    text6.setText("");
			    text7.setText("");
			    update();
			    // 填充数据
			    
			} else {
				System.out.print(count);
			    JOptionPane.showMessageDialog(null, "成绩修改失败！", "警告", JOptionPane.WARNING_MESSAGE);
			}
					
				}
			});
  
  //设计刷新按钮事件
  brefresh.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
  });
  
  
  //设计退出按钮事件
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

