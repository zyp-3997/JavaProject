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
	    private GradeServiceImpl gradeServiceImpl;
	    
	    //����gui���
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
	    
	    //����List
	    private List<Grade> sets;
	    //����ʵ����
	   Grade grade;
	    
	    //���ù��췽��
 public DeleteStudentGradeFrame(String title) {
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
  JLabel label2=new JLabel("����: ");
  JLabel label3=new JLabel("�༶: ");
  JLabel label4=new JLabel("����: ");
  JLabel label5=new JLabel("��ѧ: ");
  JLabel label6=new JLabel("Ӣ��: ");
  JLabel label7=new JLabel("����: ");
  JLabel label8=new JLabel("��ѧ: ");
  JLabel label9=new JLabel("����: ");
  
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
  
  gradeServiceImpl=new GradeServiceImpl();
  sets=gradeServiceImpl.findgradeAll();
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
                  String id = idtext.getText().trim();
                  // ��ѧ��ɾ��ѧ��
                  int count = gradeServiceImpl.deletegrade(id);
                  if (count > 0) {
                      JOptionPane.showMessageDialog(null, "��¼ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                      // ���»�ȡȫ��ѧ���б�
                      sets=gradeServiceImpl.findgradeAll();
                      // ��մ�ɾѧ��ѧ���ı���
                      idtext.setText("");
                      nametext.setText("");
                      classtext.setText("");
                      chinesetext.setText("");
                      mathtext.setText("");
                      englishtext.setText("");
                      physicstext.setText("");
                      chemistrytext.setText("");
                      biologtext.setText("");
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
      	sets=gradeServiceImpl.findgradeAll();
          // ���������
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
	    * ��ѯ����
	    */
	    private void doQuery() {
	        // ��ȡ��ѯѧ��
	        String id = txtId.getText().trim();
	        if (!id.equals("")) {
	            sets.clear();
	            Grade grade=gradeServiceImpl.findgradeById(id);
	            if (grade != null) {
	                // ����ѯ����ѧ����ӵ��б�
	                sets.add(grade);
	            }
	            // �����
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
        colHead.add("ѧ��");
        colHead.add("����");
        colHead.add("�༶");
        colHead.add("����");
        colHead.add("��ѧ");
        colHead.add("Ӣ��");
        colHead.add("����");
        colHead.add("��ѧ");
        colHead.add("����");
        
        //sets=setServiceImpl.findgrade();
        // �����¼
        rows.clear();//���
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
            // �ù������Ƶ����Ϸ�
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
     



}