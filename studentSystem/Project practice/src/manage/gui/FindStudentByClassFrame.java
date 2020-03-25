package manage.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
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
import javax.swing.border.TitledBorder;

import manage.bean.Grade;
import manage.service.impl.GradeServiceImpl;
public class FindStudentByClassFrame extends JFrame {
    /**
    * 学号标签
    */
    private JLabel lblInputId;
    /**
    * 学号文本框
    */
    private JTextField txtId;
 
    /**
    * 面板
    */
    private JPanel panel;
    private JPanel pnlSouth;
    private JPanel pnlCenter;
    private JPanel pnlNorth;
 
    /**
    * 按钮
    */
    private JButton btnQuery;
    private JButton btnBrowseAll;
    private JButton btnPrint;
    private JButton btnExit;
 
    /**
    * 记录行集
    */
    private Vector rows;
    /**
    * 表格列标题
    */
    private Vector<String> colHead;
    /**
    * 表格
    */
    private JTable table;
    /**
    * 滚动面板
    */
    private JScrollPane scroller;
 
    /**
    * 当前记录行号
    */
    private int currentRow;
    /**
    * 学生列表
    */
    private List<Grade> grades;
    /**
    * 创建学生服务对象
    */
    private GradeServiceImpl gradeServiceImpl;
 
    /**
    * 构造方法
    * 
    * @param title
    */
    public FindStudentByClassFrame(String title) {
        super(title);
        intiGUI();
    }
 
    /**
    * 初始化用户界面
    */
    private void intiGUI() {
        // 创建对象
        panel = (JPanel) getContentPane();
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
 
        rows = new Vector();
        colHead = new Vector();
 
        lblInputId = new JLabel("输入班级：");
        txtId = new JTextField(11);
        txtId.setHorizontalAlignment(JTextField.LEFT);
        btnQuery = new JButton("查询[Q]");
        btnQuery.setMnemonic(KeyEvent.VK_Q);
        btnBrowseAll = new JButton("显示全部记录[A]");
        btnBrowseAll.setMnemonic(KeyEvent.VK_A);
        btnPrint = new JButton("打印[P]");
        btnPrint.setMnemonic(KeyEvent.VK_D);
        btnExit = new JButton("退出[X]");
        btnExit.setMnemonic(KeyEvent.VK_X);
 
        // 添加组件
        panel.add(pnlSouth, BorderLayout.SOUTH);
        panel.add(pnlCenter, BorderLayout.CENTER);
        panel.add(pnlNorth, BorderLayout.NORTH);
 
        pnlNorth.add(lblInputId);
        pnlNorth.add(txtId);
        pnlNorth.add(btnQuery);
        pnlNorth.add(btnBrowseAll);
        pnlSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlSouth.add(btnPrint);
        pnlSouth.add(btnExit);
        pnlCenter.setLayout(new BorderLayout());
 
        // 创建标题边框对象
        TitledBorder tb = new TitledBorder("查询结果");
        pnlCenter.setBorder(tb);
 
        // 创建学生服务对象
        gradeServiceImpl=new GradeServiceImpl();
        // 获取全部学生列表
        grades=gradeServiceImpl.findgradeAll();
        // 填充表格数据
        fillTableData();
 
        // 设置窗口属性
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
 
        // 【退出】按钮单击事件
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
 
        // 【打印】按钮单击事件
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
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
 
        // 【显示全部记录】按钮单击事件
        btnBrowseAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // 获取全部学生记录
            	grades=gradeServiceImpl.findgradeAll();
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
 
        // JTable单击事件
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // 获取当前行的行数
                int row = table.rowAtPoint(e.getPoint());
                // 选中鼠标单击的行
                table.setRowSelectionInterval(row, row);
                // 设置文本框内容
                txtId.setText(table.getValueAt(row, 2).toString());
            }
        });
    }
 
    /**
    * 查询方法
    */
    private void doQuery() {
        // 获取查询学号
        String name = txtId.getText().trim();
        if (!name.equals("")) {
            grades.clear();
            grades=gradeServiceImpl.findgradeByClass(name);
           
            // 填充表格
            fillTableData();
        } else {
            JOptionPane.showMessageDialog(this, "请输入待查学生姓名！", "警告", JOptionPane.WARNING_MESSAGE);
            txtId.requestFocus();
        }
    }
 
    /**
    * 填充表格方法
    */
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
 
        // 填充表记录
        rows.clear();//清空
        for (Grade grade : grades) {
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
        // 将滚动面板添加到中心面板
        pnlCenter.add(scroller, BorderLayout.CENTER);
        
     // 设置此表是否始终大到足以填充封闭视口的高度。
			table.setFillsViewportHeight(true);
			table.setAutoCreateRowSorter(true);//设置排序
        // 重绘窗体
        repaint();
 
        // 判断是否有记录行
        if (rows.isEmpty()) {
        	System.out.println(rows);
            JOptionPane.showMessageDialog(this, "没有符合条件的记录！", "错误提示", JOptionPane.WARNING_MESSAGE);
            txtId.setText("");
        } else {
            // 让滚动条移到最上方
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
    
}
