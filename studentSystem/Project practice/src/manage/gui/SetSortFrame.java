package manage.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import manage.bean.SetGrade;
import manage.bean.SetSort;
import manage.service.impl.SetServiceImpl;

public class SetSortFrame extends JFrame {
	   
	//定义Vector
	private Vector rows;
	private Vector colHead;
		
	    
	    //定义服务实现类
	    private SetServiceImpl setService;
	    
	    //定义gui组件
	    private JTable table;
	    private JScrollPane scroller;
	    JPanel frame1;
	    JTextField text1;
	    JTextField text2;
	    
	    JButton b1;
	    JButton b2;
	    JButton b3;
	    JButton b4;
	    
	    //定义List
	    private List<SetSort> sets;

	    //定义实体类
	    SetSort setSort;
	    
	    //设置构造方法
 public SetSortFrame(String title) {
	 super(title);
	 Start();
 }
 //定义执行方法
	public void Start(){
		//vector实例化
		rows=new Vector();
		 colHead=new Vector();
		 
		 //gui界面设计
		 
		   frame1 = (JPanel) getContentPane();
   frame1.setLayout(new BorderLayout());
  
  
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new GridLayout(3,1));
  
  JPanel p2=new JPanel();
  JPanel p22=new JPanel();
  JLabel label1=new JLabel("考试类别编号: ");
  JLabel label2=new JLabel("考试类别名称: ");
  text1=new JTextField(15);
   text2=new JTextField(15);
  p2.add(label1);
  p2.add(text1);
  p22.add(label2);
  p22.add(text2);
  JPanel p3=new JPanel();
  p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
   b1=new JButton("删除");
   b2=new JButton("添加");
   b3=new JButton("刷新");
   b4=new JButton("退出");
  p3.add(b1);
  p3.add(b2);
  p3.add(b3);
  p3.add(b4);
  southJPanel.add(p2);
  southJPanel.add(p22);
  southJPanel.add(p3);
  
  frame1.add(southJPanel,BorderLayout.SOUTH);
  
  //显示结果集方法
  fillTableData();
  pack();
 
  setSize(400, 350);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // 重绘窗体
  repaint();
  //设计删除按钮事件
  b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
    	  if (!rows.isEmpty()) {
              long choice = JOptionPane.showConfirmDialog(null, "是否要删除记录？");
              if (choice == JOptionPane.OK_OPTION) {
                  // 获取待删学生学号
                  String id = text1.getText().trim();
                  // 按学号删除学生
                  int count = setService.deletesort(id);
                  if (count > 0) {
                      JOptionPane.showMessageDialog(null, "记录删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                      // 重新获取全部学生列表
                      sets=setService.findsort();
                      // 清空待删学生学号文本框
                      text1.setText("");
                      text2.setText("");
                      // 填充数据
                      fillTableData();
                      
                  } else {
                      JOptionPane.showMessageDialog(null, "考试类别编号只能唯一！", "警告", JOptionPane.WARNING_MESSAGE);
                  }
              }
          }
      }
  });
 
  //设计添加按钮事件
  b2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		setSort=new SetSort();
		setSort.setSort_id(Integer.parseInt(text1.getText()));
		setSort.setSort_name(text2.getText());
    
		int count=setService.insertsort(setSort);

if (count > 0) {
    JOptionPane.showMessageDialog(null, "记录添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
    // 重新获取全部学生列表
    sets=setService.findsort();
    // 清空待删学生学号文本框
    text1.setText("");
    text2.setText("");
    // 填充数据
    fillTableData();
    
} else {
    JOptionPane.showMessageDialog(null, "年级编号只能唯一！", "警告", JOptionPane.WARNING_MESSAGE);
}
		
	}
});
  
  //设计刷新按钮事件
  b3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  fillTableData();
      }
  });
  
  
  //设计退出按钮事件
  b4.addActionListener(new ActionListener() {
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
          text2.setText(table.getValueAt(row, 1).toString());
      }
  });
 
 }
	
	//设计显示结果集方法
	private void fillTableData() {
        
		setService=new SetServiceImpl();
		  sets=setService.findsort();
		// 填充表头
	        //colHead.clear();
		  colHead.add("考试类别编号");
		  colHead.add("考试类别名称");
        
        //sets=setServiceImpl.findgrade();
        // 填充表记录
        rows.clear();//清空
        for (SetSort setSort : sets) {
            Vector<String> currentRow = new Vector<String>();
            currentRow.addElement(setSort.getSort_id()+"");
            currentRow.addElement(setSort.getSort_name());
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
        frame1.add(scroller, BorderLayout.CENTER);
 
        // 重绘窗体
        repaint();
 
        // 判断是否有记录行
        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(this, "没有符合条件的记录！", "错误提示", JOptionPane.WARNING_MESSAGE);
            text1.setText("");
            text2.setText("");
        } else {
            // 让滚动条移到最上方
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
     




}
