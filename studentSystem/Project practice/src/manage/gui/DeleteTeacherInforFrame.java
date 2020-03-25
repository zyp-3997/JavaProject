package manage.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import manage.bean.Teacher;
import manage.service.impl.TeacherServiceImpl;


public class DeleteTeacherInforFrame extends JFrame {
	   
	//定义Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * 学号文本框
	    */
	    private JTextField txtId;
	    
	    private JButton btnQuery;
	    private JButton btnBrowseAll;
	
	
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
	    
	    JButton bdelete;
	    JButton brefresh;
	    JButton bexit;
	    
	  //定义List
	    private List<Teacher> sets;
	    //定义实体类
	    Teacher teacher;
	    
	    //设置构造方法
 public DeleteTeacherInforFrame(String title) {
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
  
  JLabel label1=new JLabel("学号: ");
  JLabel label2=new JLabel("班号: ");
  JLabel label3=new JLabel("姓名: ");
  JLabel label4=new JLabel("性别: ");
  JLabel label5=new JLabel("年龄: ");
  JLabel label6=new JLabel("地址: ");
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
  
   bdelete=new JButton("删除");
   brefresh=new JButton("刷新");
   bexit=new JButton("退出");
   
  p4.add(bdelete);
  p4.add(brefresh);
  p4.add(bexit);
  
  southJPanel.add(p1);
  southJPanel.add(p2);
  southJPanel.add(p3);
  southJPanel.add(p4);
  
  txtId = new JTextField(11);
  txtId.setHorizontalAlignment(JTextField.LEFT);
  btnQuery = new JButton("查询[Q]");
  btnQuery.setMnemonic(KeyEvent.VK_Q);
  btnBrowseAll = new JButton("显示全部记录[A]");
  btnBrowseAll.setMnemonic(KeyEvent.VK_A);
  
  JPanel pnlNorth=new JPanel();
  JLabel lblInputId=new JLabel("输入学号：");
  
  pnlNorth.add(lblInputId);
  pnlNorth.add(txtId);
  pnlNorth.add(btnQuery);
  pnlNorth.add(btnBrowseAll);
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  frame.add(pnlNorth,BorderLayout.NORTH);
  
  teacherServiceImpl=new TeacherServiceImpl();
  sets=teacherServiceImpl.findinforAll();
  //显示结果集方法
  fillTableData();
  pack();
 
  setSize(500,500);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // 重绘窗体
  repaint();
 

  //设计删除按钮事件
  bdelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
    	  if (!rows.isEmpty()) {
              long choice = JOptionPane.showConfirmDialog(null, "是否要删除记录？");
              if (choice == JOptionPane.OK_OPTION) {
                  // 获取待删学生学号
                  String id = text1.getText().trim();
                  // 按学号删除学生
                  int count = teacherServiceImpl.deleteinfor(id);
                  if (count > 0) {
                      JOptionPane.showMessageDialog(null, "记录删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                      // 重新获取全部学生列表
                      sets=teacherServiceImpl.findinforAll();
                      // 清空待删学生学号文本框
                      txtId.setText("");
                      text1.setText("");
                      text2.setText("");
                      text3.setText("");
                      text4.setText("");
                      text5.setText("");
                      text6.setText("");
                      text7.setText("");
                      // 填充数据
                      fillTableData();
                      
                  } else {
                      JOptionPane.showMessageDialog(null, "记录删除失败！", "警告", JOptionPane.WARNING_MESSAGE);
                  }
              }
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
  
  // 【显示全部记录】按钮单击事件
  btnBrowseAll.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
          // 获取全部学生记录
      	sets=teacherServiceImpl.findinforAll();
          // 填充表格数据
          fillTableData();
      }
  });

  // 文本框按键事件
  txtId.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == 10) {
              doQuery();
          }
      }
  });
  
  // 【查询】按钮单击事件
  btnQuery.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
          doQuery();
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
          txtId.setText(table.getValueAt(row,0).toString());
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
	/**
	    * 查询方法
	    */
	    private void doQuery() {
	        // 获取查询学号
	        String id = txtId.getText().trim();
	        if (!id.equals("")) {
	            sets.clear();
	            Teacher teacher=teacherServiceImpl.findinforById(id);
	            if (teacher != null) {
	                // 将查询到的学生添加到列表
	                sets.add(teacher);
	            }
	            // 填充表格
	            fillTableData();
	        } else {
	            JOptionPane.showMessageDialog(this, "请输入待查学生学号！", "警告", JOptionPane.WARNING_MESSAGE);
	            txtId.requestFocus();
	        }
	    }
	
	//设计显示结果集方法
	private void fillTableData() {
        
		// 填充表头
        colHead.clear();
        colHead.add("工号");
        colHead.add("班号");
        colHead.add("姓名");
        colHead.add("性别");
        colHead.add("专业");
        colHead.add("水平");
        colHead.add("电话");
        //sets=setServiceImpl.findgrade();
        // 填充表记录
        rows.clear();//清空
        for (Teacher teacher : sets) {
          	 Vector<String> currentRow = new Vector<String>();
               
               currentRow.addElement(teacher.getTeacher_id()+"");
               currentRow.addElement(teacher.getClass_id()+"");
               currentRow.addElement(teacher.getTeacher_name());
               currentRow.addElement(teacher.getTeacher_sex());
               currentRow.addElement(teacher.getTeacher_major());
               currentRow.addElement(teacher.getTeacher_level());
               currentRow.addElement(teacher.getTeacher_tel()+"");
               
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
	DeleteTeacherInforFrame deleteTeacherInforFrame=new DeleteTeacherInforFrame("删除教师信息");
}



}
