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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import manage.app.Application;
import manage.bean.Student;
import manage.bean.Teacher;
import manage.dbutil.ConnectionManager;
import manage.service.impl.TeacherServiceImpl;


public class LookStudentInforFrame extends JFrame {
	   
	//定义Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * 学号文本框
	    */
	   
	
	
	    //定义服务实现类
	    private TeacherServiceImpl teacherServiceImpl;
	    
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
	    
	    JButton bprint;
	    JButton brefresh;
	    JButton bexit;
	    

	    //定义List
	    private List<Student> sets;
	    //定义实体类
	    Student student;
	    
	    //设置构造方法
 public LookStudentInforFrame (String title) {
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
  
  
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new GridLayout(4,1));
  
  JPanel p1=new JPanel();
  JPanel p2=new JPanel();
  JPanel p3=new JPanel();
  
  
  JLabel label1=new JLabel("                             教师号: ");
  JLabel label2=new JLabel("班号: ");
  JLabel label3=new JLabel("姓名: ");
  JLabel label4=new JLabel("性别: ");
  JLabel label5=new JLabel("专业: ");
  JLabel label6=new JLabel("水平: ");
  JLabel label7=new JLabel("电话: ");
  
  text1=new JTextField(8);
  text2=new JTextField(11);
  text3=new JTextField(11);
  text4=new JTextField(11);
  text5=new JTextField(11);
  text6=new JTextField(11);
  text7=new JTextField(11);
   
   
   text1.setEditable(false);
   text2.setEditable(false);
   text3.setEditable(false);
   text4.setEditable(false);
   text5.setEditable(false);
   text6.setEditable(false);
   text7.setEditable(false);
 
   
  
  p1.add(label2);
  p1.add(text2);
  p1.add(label3);
  p1.add(text3);
  
  p2.add(label4);
  p2.add(text4);
  
  p2.add(label5);
  p2.add(text5);
  
  p3.add(label6);
  p3.add(text6);
  p3.add(label7);
  p3.add(text7);
  
  
  JPanel p4=new JPanel();
  p4.setLayout(new FlowLayout(FlowLayout.CENTER));
  
  p4.add(label1);
  p4.add(text1);
  
   bprint=new JButton("打印");
   brefresh=new JButton("刷新");
   bexit=new JButton("退出");
   
  p4.add(bprint);
  p4.add(brefresh);
  p4.add(bexit);
  
  southJPanel.add(p1);
  southJPanel.add(p2);
  southJPanel.add(p3);
  southJPanel.add(p4);
  
  
  
  
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  
  
  String id=getClass_id(Application.id);
  sets=findinforByClass_id(id);
  //显示结果集方法
  fillTableData();
  pack();
 
  setSize(500,500);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // 重绘窗体
  repaint();
 
  //打印按钮
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
  
  //设计刷新按钮事件
  brefresh.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  fillTableData();
      }
  });
  
  
  //设计退出按钮事件
  bexit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
          dispose();
      }
  });  
  
  
  
  //设计鼠标点击显示事件
  table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
          // 获取当前行的行数
          int row = table.rowAtPoint(e.getPoint());
          // 选中鼠标单击的行
          table.setRowSelectionInterval(row, row);
          // 设置文本框内容
          text1.setText(table.getValueAt(row,0).toString());
          text2.setText(table.getValueAt(row,1).toString());
          text3.setText(table.getValueAt(row,2).toString());
          text4.setText(table.getValueAt(row,3).toString());
          text5.setText(table.getValueAt(row,4).toString());
          text6.setText(table.getValueAt(row,5).toString());
          text7.setText(table.getValueAt(row,6).toString());
          
      }
  });
 
	}	
	//设计显示结果集方法
	private void fillTableData() {
        
		// 填充表头
        colHead.clear();
        colHead.add("学号");
        colHead.add("班号");
        colHead.add("姓名");
        colHead.add("性别");
        colHead.add("年龄");
        colHead.add("地址");
        colHead.add("电话");
        //sets=setServiceImpl.findgrade();
        rows.clear();//清空
        for (Student student : sets) {
        	 Vector<String> currentRow = new Vector<String>();
             
             currentRow.addElement(student.getStudent_id()+"");
             currentRow.addElement(student.getClass_id()+"");
             currentRow.addElement(student.getStudent_name());
             currentRow.addElement(student.getStudent_sex());
             currentRow.addElement(student.getStudent_age()+"");
             currentRow.addElement(student.getStudent_adress());
             currentRow.addElement(student.getStudent_tel()+"");
             
             // 将当前行添加到记录行集
             rows.add(currentRow);
          }
 
        // 创建表格（参数1：记录集；参数2：表头）
        table = new JTable(rows, colHead);
 
        // 定义滚动面板
        scroller = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
     // 设置此表是否始终大到足以填充封闭视口的高度。
     			table.setFillsViewportHeight(true);
     			table.setAutoCreateRowSorter(true);//设置排序
        // 将滚动面板添加到中心面板
        frame.add(scroller, BorderLayout.CENTER);
 
        // 重绘窗体
        repaint();
 
        // 判断是否有记录行
        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(this, "没有符合条件的记录！", "错误提示", JOptionPane.WARNING_MESSAGE);
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            text6.setText("");
            text7.setText("");
        } else {
            // 让滚动条移到最上方
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
     
public static void main (String args[]){
	LookStudentInforFrame  lookStudentInforFrame=new LookStudentInforFrame("查看所教学生信息");
	
}

 public List<Student> findinforByClass_id(String id){
	 List<Student> sets=new ArrayList<Student>();
	    // 获得数据库连接
	    Connection conn = ConnectionManager.getConnection();
	    // 定义SQL字符串
	    String strSQL = "select * from student where class_id = ?";
	    try {
	    	 // 创建预备语句对象
	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
	        // 设置占位符的值
	        pstmt.setString(1, id);
	        // 执行SQL查询，返回结果集
	        ResultSet rs = pstmt.executeQuery();
	        // 判断结果集是否有记录
	       while(rs.next()){
	    	   Student student=new Student();
        	   student.setStudent_id(rs.getInt("student_id"));
        	   student.setClass_id(rs.getInt("class_id"));
        	   student.setStudent_name(rs.getString("student_name"));
        	   student.setStudent_sex(rs.getString("student_sex"));
        	   student.setStudent_age(rs.getInt("student_age"));
        	   student.setStudent_adress(rs.getString("student_adress"));
        	   student.setStudent_tel(rs.getInt("student_tel"));
        	
        	   sets.add(student);
	        }
	        rs.close();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        ConnectionManager.closeConnection(conn);
	    }

	    // 返回删除记录数

		return sets;
 }

 public String getClass_id(int id){
	 String getclass=null;
	 Connection conn = ConnectionManager.getConnection();
	 String strSQL = "SELECT class_id FROM teacher WHERE teacher_id = ?";
	 PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(strSQL);
	
		pstmt.setInt(1, id);
	
      ResultSet rs;
	
		rs = pstmt.executeQuery();
	
  
		if (rs.next()) {
			 try {
				getclass=rs.getString("class_id"+"");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		 }
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return getclass; 
 }
 

}
