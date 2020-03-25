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

import manage.bean.SetClass;
import manage.service.impl.SetServiceImpl;

public class SetClassFrame extends JFrame {
	   
	//����Vector
	private Vector rows;
	private Vector colHead;
		
	    
	    //�������ʵ����
	    private SetServiceImpl setService;
	    
	    //����gui���
	    private JTable table;
	    private JScrollPane scroller;
	    JPanel frame1;
	    JTextField text1;
	    JTextField text2;
	    JTextField text3;
	    JButton b1;
	    JButton b2;
	    JButton b3;
	    JButton b4;
	    
	    //����List
	    private List<SetClass> sets;

	    //����ʵ����
	    SetClass setClass;
	    
	    //���ù��췽��
 public SetClassFrame(String title) {
	 super(title);
	 Start();
 }
 //����ִ�з���
	public void Start(){
		//vectorʵ����
		rows=new Vector();
		 colHead=new Vector();
		 
		 //gui�������
		 
		   frame1 = (JPanel) getContentPane();
   frame1.setLayout(new BorderLayout());
  
  
  JPanel southJPanel=new JPanel();
  southJPanel.setLayout(new GridLayout(3,1));
  
  JPanel p2=new JPanel();
  JPanel p22=new JPanel();
  JPanel p222=new JPanel();
  JLabel label1=new JLabel("�༶���: ");
  JLabel label2=new JLabel("�꼶���: ");
  JLabel label3=new JLabel("�༶����: ");
  text1=new JTextField(15);
   text2=new JTextField(15);
   text3=new JTextField(15);
  p2.add(label1);
  p2.add(text1);
  p22.add(label2);
  p22.add(text2);
  p222.add(label3);
  p222.add(text3);
  
  JPanel p3=new JPanel();
  
   b1=new JButton("ɾ��");
   b2=new JButton("���");
   b3=new JButton("ˢ��");
   b4=new JButton("�˳�");
  p3.add(b1);
  p3.add(b2);
  p3.add(b3);
  p3.add(b4);
  southJPanel.add(p2);
  southJPanel.add(p22);
  southJPanel.add(p222);
 
  JPanel northJPanel=new JPanel();
  northJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
  northJPanel.add(p3);
  
  frame1.add(northJPanel,BorderLayout.NORTH);
  frame1.add(southJPanel,BorderLayout.SOUTH);
  
  //��ʾ���������
  fillTableData();
  pack();
 
  setSize(400, 350);
  setLocationRelativeTo(null);
  setResizable(false);
  setVisible(true);
  
 
	

  // �ػ洰��
  repaint();
  //���ɾ����ť�¼�
  b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
    	  if (!rows.isEmpty()) {
              long choice = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫɾ����¼��");
              if (choice == JOptionPane.OK_OPTION) {
                  // ��ȡ��ɾѧ��ѧ��
                  String id = text1.getText().trim();
                  // ��ѧ��ɾ��ѧ��
                  int count = setService.deleteclass(id);
                  if (count > 0) {
                      JOptionPane.showMessageDialog(null, "��¼ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                      // ���»�ȡȫ��ѧ���б�
                      sets=setService.findClasses();
                      // ��մ�ɾѧ��ѧ���ı���
                      text1.setText("");
                      text2.setText("");
                      text3.setText("");
                      // �������
                      fillTableData();
                      
                  } else {
                      JOptionPane.showMessageDialog(null, "��¼ɾ��ʧ�ܣ�", "����", JOptionPane.WARNING_MESSAGE);
                  }
              }
          }
      }
  });
 
  //�����Ӱ�ť�¼�
  b2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 SetClass setClass=new SetClass();
		 setClass.setClass_id(Integer.parseInt(text1.getText()));
		 setClass.setGrade_id(Integer.parseInt(text2.getText()));
		 setClass.setClass_name(text3.getText());
int count=setService.insertclass(setClass);

if (count > 0) {
    JOptionPane.showMessageDialog(null, "��¼��ӳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
    // ���»�ȡȫ��ѧ���б�
    sets=setService.findClasses();
    // ��մ�ɾѧ��ѧ���ı���
    text1.setText("");
    text2.setText("");
    text3.setText("");
    // �������
    fillTableData();
    
} else {
    JOptionPane.showMessageDialog(null, "�༶���ֻ��Ψһ��", "����", JOptionPane.WARNING_MESSAGE);
}
		
	}
});
  
  //���ˢ�°�ť�¼�
  b3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  fillTableData();
      }
  });
  
  
  //����˳���ť�¼�
  b4.addActionListener(new ActionListener() {
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
          text2.setText(table.getValueAt(row, 1).toString());
          text3.setText(table.getValueAt(row, 2).toString());
      }
  });
 
 }
	
	//�����ʾ���������
	private void fillTableData() {
        
		setService=new SetServiceImpl();
		  sets=setService.findClasses();
		// ����ͷ
	        colHead.clear();
		  colHead.add("�༶���");
		  colHead.add("�꼶���");
		  colHead.add("�༶����");
        
        //sets=setServiceImpl.findgrade();
        // �����¼
        rows.clear();//���
        for (SetClass setClass : sets) {
            Vector<String> currentRow = new Vector<String>();
            currentRow.addElement(setClass.getClass_id()+"");
            currentRow.addElement(setClass.getGrade_id()+"");
            currentRow.addElement(setClass.getClass_name());
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
        frame1.add(scroller, BorderLayout.CENTER);
 
        // �ػ洰��
        repaint();
 
        // �ж��Ƿ��м�¼��
        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(this, "û�з��������ļ�¼��", "������ʾ", JOptionPane.WARNING_MESSAGE);
            text1.setText("");
            text2.setText("");
            text3.setText("");
        } else {
            // �ù������Ƶ����Ϸ�
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
     





}