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

import manage.bean.Grade;
import manage.service.impl.GradeServiceImpl;

public class DeleteStudentGradeFrame extends JFrame {
	   
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
	    private GradeServiceImpl gradeServiceImpl;
	    
	    //定义gui组件
	    private JTable table;
	    private JScrollPane scroller;
	    JPanel frame;
	    JTextField idtext;
	    JTextField nametext;
	    JTextField classtext;
	    JTextField chinesetext;
	    JTextField mathtext;
	    JTextField englishtext;
	    JTextField physicstext;
	    JTextField chemistrytext;
	    JTextField biologtext;
	    
	    JButton bdelete;
	    JButton brefresh;
	    JButton bexit;
	    
	    //定义List
	    private List<Grade> sets;
	    //定义实体类
	   Grade grade;
	    
	    //设置构造方法
 public DeleteStudentGradeFrame(String title) {
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
  JLabel label2=new JLabel("姓名: ");
  JLabel label3=new JLabel("班级: ");
  JLabel label4=new JLabel("语文: ");
  JLabel label5=new JLabel("数学: ");
  JLabel label6=new JLabel("英语: ");
  JLabel label7=new JLabel("物理: ");
  JLabel label8=new JLabel("化学: ");
  JLabel label9=new JLabel("生物: ");
  
  idtext=new JTextField(10);
   nametext=new JTextField(10);
   classtext=new JTextField(10);
   chinesetext=new JTextField(10);
   mathtext=new JTextField(10);
   englishtext=new JTextField(10);
   physicstext=new JTextField(10);
   chemistrytext=new JTextField(10);
   biologtext=new JTextField(10);
   
   idtext.setEditable(false);
   
   nametext.setEditable(false);
   classtext.setEditable(false);
  p1.add(label1);
  p1.add(idtext);
  p1.add(label2);
  p1.add(nametext);
  p1.add(label3);
  p1.add(classtext);
  
  p2.add(label4);
  p2.add(chinesetext);
  p2.add(label5);
  p2.add(mathtext);
  p2.add(label6);
  p2.add(englishtext);
  
  p3.add(label7);
  p3.add(physicstext);
  p3.add(label8);
  p3.add(chemistrytext);
  p3.add(label9);
  p3.add(biologtext);
  
  
  JPanel p4=new JPanel();
  p4.setLayout(new FlowLayout(FlowLayout.CENTER));
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
  
  gradeServiceImpl=new GradeServiceImpl();
  sets=gradeServiceImpl.findgradeAll();
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
                  String id = idtext.getText().trim();
                  // 按学号删除学生
                  int count = gradeServiceImpl.deletegrade(id);
                  if (count > 0) {
                      JOptionPane.showMessageDialog(null, "记录删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                      // 重新获取全部学生列表
                      sets=gradeServiceImpl.findgradeAll();
                      // 清空待删学生学号文本框
                      idtext.setText("");
                      nametext.setText("");
                      classtext.setText("");
                      chinesetext.setText("");
                      mathtext.setText("");
                      englishtext.setText("");
                      physicstext.setText("");
                      chemistrytext.setText("");
                      biologtext.setText("");
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
      	sets=gradeServiceImpl.findgradeAll();
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
          idtext.setText(table.getValueAt(row,0).toString());
          nametext.setText(table.getValueAt(row,1).toString());
          classtext.setText(table.getValueAt(row,2).toString());
          chinesetext.setText(table.getValueAt(row,3).toString());
          mathtext.setText(table.getValueAt(row,4).toString());
          englishtext.setText(table.getValueAt(row,5).toString());
          physicstext.setText(table.getValueAt(row,6).toString());
          chemistrytext.setText(table.getValueAt(row,7).toString());
          biologtext.setText(table.getValueAt(row,8).toString());
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
	            Grade grade=gradeServiceImpl.findgradeById(id);
	            if (grade != null) {
	                // 将查询到的学生添加到列表
	                sets.add(grade);
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
        colHead.add("学号");
        colHead.add("姓名");
        colHead.add("班级");
        colHead.add("语文");
        colHead.add("数学");
        colHead.add("英语");
        colHead.add("物理");
        colHead.add("化学");
        colHead.add("生物");
        
        //sets=setServiceImpl.findgrade();
        // 填充表记录
        rows.clear();//清空
        for (Grade grade : sets) {
        	 Vector<String> currentRow = new Vector<String>();
             
             currentRow.addElement(grade.getStudent_id()+"");
             currentRow.addElement(grade.getStudent_names());
             currentRow.addElement(grade.getClass_names());
             currentRow.addElement(grade.getChinese() + "");
             currentRow.addElement(grade.getMath()+"");
             currentRow.addElement(grade.getEnglish()+"");
             currentRow.addElement(grade.getPhysics()+"");
             currentRow.addElement(grade.getChemistry()+"");
             currentRow.addElement(grade.getBiolog()+"");
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
            idtext.setText("");
            nametext.setText("");
            classtext.setText("");
            chinesetext.setText("");
            mathtext.setText("");
            englishtext.setText("");
            physicstext.setText("");
            chemistrytext.setText("");
            biologtext.setText("");
        } else {
            // 让滚动条移到最上方
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
     



}