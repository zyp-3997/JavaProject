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
	   
	//����Vector
	private Vector rows;
	private Vector colHead;
		
	
	 
	    /**
	    * ѧ���ı���
	    */
	    private JTextField txtId;
	    
	    private JButton btnQuery;
	    private JButton btnBrowseAll;
	
	
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
	    
	    JButton bdelete;
	    JButton brefresh;
	    JButton bexit;
	    
	  //����List
	    private List<Teacher> sets;
	    //����ʵ����
	    Teacher teacher;
	    
	    //���ù��췽��
 public DeleteTeacherInforFrame(String title) {
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
  
  JLabel label1=new JLabel("ѧ��: ");
  JLabel label2=new JLabel("���: ");
  JLabel label3=new JLabel("����: ");
  JLabel label4=new JLabel("�Ա�: ");
  JLabel label5=new JLabel("����: ");
  JLabel label6=new JLabel("��ַ: ");
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
  
   bdelete=new JButton("ɾ��");
   brefresh=new JButton("ˢ��");
   bexit=new JButton("�˳�");
   
  p4.add(bdelete);
  p4.add(brefresh);
  p4.add(bexit);
  
  southJPanel.add(p1);
  southJPanel.add(p2);
  southJPanel.add(p3);
  southJPanel.add(p4);
  
  txtId = new JTextField(11);
  txtId.setHorizontalAlignment(JTextField.LEFT);
  btnQuery = new JButton("��ѯ[Q]");
  btnQuery.setMnemonic(KeyEvent.VK_Q);
  btnBrowseAll = new JButton("��ʾȫ����¼[A]");
  btnBrowseAll.setMnemonic(KeyEvent.VK_A);
  
  JPanel pnlNorth=new JPanel();
  JLabel lblInputId=new JLabel("����ѧ�ţ�");
  
  pnlNorth.add(lblInputId);
  pnlNorth.add(txtId);
  pnlNorth.add(btnQuery);
  pnlNorth.add(btnBrowseAll);
  
  
  frame.add(southJPanel,BorderLayout.SOUTH);
  frame.add(pnlNorth,BorderLayout.NORTH);
  
  teacherServiceImpl=new TeacherServiceImpl();
  sets=teacherServiceImpl.findinforAll();
  //��ʾ���������
  fillTableData();
  pack();
 
  setSize(500,500);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // �ػ洰��
  repaint();
 

  //���ɾ����ť�¼�
  bdelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
    	  if (!rows.isEmpty()) {
              long choice = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫɾ����¼��");
              if (choice == JOptionPane.OK_OPTION) {
                  // ��ȡ��ɾѧ��ѧ��
                  String id = text1.getText().trim();
                  // ��ѧ��ɾ��ѧ��
                  int count = teacherServiceImpl.deleteinfor(id);
                  if (count > 0) {
                      JOptionPane.showMessageDialog(null, "��¼ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                      // ���»�ȡȫ��ѧ���б�
                      sets=teacherServiceImpl.findinforAll();
                      // ��մ�ɾѧ��ѧ���ı���
                      txtId.setText("");
                      text1.setText("");
                      text2.setText("");
                      text3.setText("");
                      text4.setText("");
                      text5.setText("");
                      text6.setText("");
                      text7.setText("");
                      // �������
                      fillTableData();
                      
                  } else {
                      JOptionPane.showMessageDialog(null, "��¼ɾ��ʧ�ܣ�", "����", JOptionPane.WARNING_MESSAGE);
                  }
              }
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
  
  // ����ʾȫ����¼����ť�����¼�
  btnBrowseAll.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
          // ��ȡȫ��ѧ����¼
      	sets=teacherServiceImpl.findinforAll();
          // ����������
          fillTableData();
      }
  });

  // �ı��򰴼��¼�
  txtId.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == 10) {
              doQuery();
          }
      }
  });
  
  // ����ѯ����ť�����¼�
  btnQuery.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
          doQuery();
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
	    * ��ѯ����
	    */
	    private void doQuery() {
	        // ��ȡ��ѯѧ��
	        String id = txtId.getText().trim();
	        if (!id.equals("")) {
	            sets.clear();
	            Teacher teacher=teacherServiceImpl.findinforById(id);
	            if (teacher != null) {
	                // ����ѯ����ѧ�����ӵ��б�
	                sets.add(teacher);
	            }
	            // ������
	            fillTableData();
	        } else {
	            JOptionPane.showMessageDialog(this, "���������ѧ��ѧ�ţ�", "����", JOptionPane.WARNING_MESSAGE);
	            txtId.requestFocus();
	        }
	    }
	
	//�����ʾ���������
	private void fillTableData() {
        
		// ����ͷ
        colHead.clear();
        colHead.add("����");
        colHead.add("���");
        colHead.add("����");
        colHead.add("�Ա�");
        colHead.add("רҵ");
        colHead.add("ˮƽ");
        colHead.add("�绰");
        //sets=setServiceImpl.findgrade();
        // ������¼
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
               
               // ����ǰ�����ӵ���¼�м�
               rows.add(currentRow);
          }
 
        // �������񣨲���1����¼��������2����ͷ��
        table = new JTable(rows, colHead);
 
        // ����������
        scroller = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
     // ���ô˱��Ƿ�ʼ�մ�����������ӿڵĸ߶ȡ�
     			table.setFillsViewportHeight(true);
     			table.setAutoCreateRowSorter(true);//��������
        // ������������ӵ��������
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
	DeleteTeacherInforFrame deleteTeacherInforFrame=new DeleteTeacherInforFrame("ɾ����ʦ��Ϣ");
}



}