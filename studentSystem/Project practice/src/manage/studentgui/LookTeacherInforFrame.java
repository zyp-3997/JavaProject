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
import manage.bean.Teacher;
import manage.dbutil.ConnectionManager;
import manage.service.impl.TeacherServiceImpl;


public class LookTeacherInforFrame extends JFrame {
	   
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
	    

	    //����List
	    private List<Teacher> sets;
	    //����ʵ����
	    Teacher teacher;
	    
	    //���ù��췽��
 public LookTeacherInforFrame(String title) {
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
  
  
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new GridLayout(4,1));
  
  JPanel p1=new JPanel();
  JPanel p2=new JPanel();
  JPanel p3=new JPanel();
  
  
  JLabel label1=new JLabel("                             ��ʦ��: ");
  JLabel label2=new JLabel("���: ");
  JLabel label3=new JLabel("����: ");
  JLabel label4=new JLabel("�Ա�: ");
  JLabel label5=new JLabel("רҵ: ");
  JLabel label6=new JLabel("ˮƽ: ");
  JLabel label7=new JLabel("�绰: ");
  
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
  
   bprint=new JButton("��ӡ");
   brefresh=new JButton("ˢ��");
   bexit=new JButton("�˳�");
   
  p4.add(bprint);
  p4.add(brefresh);
  p4.add(bexit);
  
  southJPanel.add(p1);
  southJPanel.add(p2);
  southJPanel.add(p3);
  southJPanel.add(p4);
  
  
  
  
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  
  teacherServiceImpl=new TeacherServiceImpl();
  
  String id=getClass_id(Application.id);
  sets=findinforByClass_id(id);
  //��ʾ���������
  fillTableData();
  pack();
 
  setSize(500,500);
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
    	  fillTableData();
      }
  });
  
  
  //����˳���ť�¼�
  bexit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
          dispose();
      }
  });  
  
  
  
  //����������ʾ�¼�
  table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
          // ��ȡ��ǰ�е�����
          int row = table.rowAtPoint(e.getPoint());
          // ѡ����굥������
          table.setRowSelectionInterval(row, row);
          // �����ı�������
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
	//�����ʾ���������
	private void fillTableData() {
        
		// ����ͷ
        colHead.clear();
        colHead.add("��ʦ��");
        colHead.add("���");
        colHead.add("����");
        colHead.add("�Ա�");
        colHead.add("רҵ");
        colHead.add("ˮƽ");
        colHead.add("�绰");
        //sets=setServiceImpl.findgrade();
        // �����¼
        rows.clear();//���
        for (Teacher teacher : sets) {
          	 Vector<String> currentRow = new Vector<String>();
               
               currentRow.addElement(teacher.getTeacher_id()+"");
               currentRow.addElement(teacher.getClass_id()+"");
               currentRow.addElement(teacher.getTeacher_name());
               currentRow.addElement(teacher.getTeacher_sex());
               currentRow.addElement(teacher.getTeacher_major());
               currentRow.addElement(teacher.getTeacher_level());
               currentRow.addElement(teacher.getTeacher_tel()+"");
               
               // ����ǰ����ӵ���¼�м�
               rows.add(currentRow);
          }
 
        // ������񣨲���1����¼��������2����ͷ��
        table = new JTable(rows, colHead);
 
        // ����������
        scroller = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
     // ���ô˱��Ƿ�ʼ�մ�����������ӿڵĸ߶ȡ�
     			table.setFillsViewportHeight(true);
     			table.setAutoCreateRowSorter(true);//��������
        // �����������ӵ��������
        frame.add(scroller, BorderLayout.CENTER);
 
        // �ػ洰��
        repaint();
 
        // �ж��Ƿ��м�¼��
        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(this, "û�з��������ļ�¼��", "������ʾ", JOptionPane.WARNING_MESSAGE);
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            text6.setText("");
            text7.setText("");
        } else {
            // �ù������Ƶ����Ϸ�
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
     
public static void main (String args[]){
	
	LookTeacherInforFrame lookTeacherInforFrame=new LookTeacherInforFrame("�鿴�ον�ʦ��Ϣ");
}

 public List<Teacher> findinforByClass_id(String id){
	 List<Teacher> sets=new ArrayList<Teacher>();
	    // ������ݿ�����
	    Connection conn = ConnectionManager.getConnection();
	    // ����SQL�ַ���
	    String strSQL = "select * from teacher where class_id = ?";
	    try {
	    	 // ����Ԥ��������
	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
	        // ����ռλ����ֵ
	        pstmt.setString(1, id);
	        // ִ��SQL��ѯ�����ؽ����
	        ResultSet rs = pstmt.executeQuery();
	        // �жϽ�����Ƿ��м�¼
	       while(rs.next()){
	    	   Teacher teacher=new Teacher();
	    	   teacher.setTeacher_id(rs.getInt("teacher_id"));
	    	   teacher.setClass_id(rs.getInt("class_id"));
	    	   teacher.setTeacher_name(rs.getString("teacher_name"));
	    	   teacher.setTeacher_sex(rs.getString("teacher_sex"));
	    	   teacher.setTeacher_major(rs.getString("teacher_major"));
	    	   teacher.setTeacher_level(rs.getString("teacher_level"));
	    	   teacher.setTeacher_tel(rs.getInt("teacher_tel"));
	    	
	    	   sets.add(teacher);
	        }
	        rs.close();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        ConnectionManager.closeConnection(conn);
	    }

	    // ����ɾ����¼��

		return sets;
 }

 public String getClass_id(int id){
	 String getclass=null;
	 Connection conn = ConnectionManager.getConnection();
	 String strSQL = "SELECT class_id FROM student WHERE student_id = ?";
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		 }
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	return getclass; 
 }
 

}
