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
    * ѧ�ű�ǩ
    */
    private JLabel lblInputId;
    /**
    * ѧ���ı���
    */
    private JTextField txtId;
 
    /**
    * ���
    */
    private JPanel panel;
    private JPanel pnlSouth;
    private JPanel pnlCenter;
    private JPanel pnlNorth;
 
    /**
    * ��ť
    */
    private JButton btnQuery;
    private JButton btnBrowseAll;
    private JButton btnPrint;
    private JButton btnExit;
 
    /**
    * ��¼�м�
    */
    private Vector rows;
    /**
    * ����б���
    */
    private Vector<String> colHead;
    /**
    * ���
    */
    private JTable table;
    /**
    * �������
    */
    private JScrollPane scroller;
 
    /**
    * ��ǰ��¼�к�
    */
    private int currentRow;
    /**
    * ѧ���б�
    */
    private List<Grade> grades;
    /**
    * ����ѧ���������
    */
    private GradeServiceImpl gradeServiceImpl;
 
    /**
    * ���췽��
    * 
    * @param title
    */
    public FindStudentByClassFrame(String title) {
        super(title);
        intiGUI();
    }
 
    /**
    * ��ʼ���û�����
    */
    private void intiGUI() {
        // ��������
        panel = (JPanel) getContentPane();
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
 
        rows = new Vector();
        colHead = new Vector();
 
        lblInputId = new JLabel("����༶��");
        txtId = new JTextField(11);
        txtId.setHorizontalAlignment(JTextField.LEFT);
        btnQuery = new JButton("��ѯ[Q]");
        btnQuery.setMnemonic(KeyEvent.VK_Q);
        btnBrowseAll = new JButton("��ʾȫ����¼[A]");
        btnBrowseAll.setMnemonic(KeyEvent.VK_A);
        btnPrint = new JButton("��ӡ[P]");
        btnPrint.setMnemonic(KeyEvent.VK_D);
        btnExit = new JButton("�˳�[X]");
        btnExit.setMnemonic(KeyEvent.VK_X);
 
        // ������
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
 
        // ��������߿����
        TitledBorder tb = new TitledBorder("��ѯ���");
        pnlCenter.setBorder(tb);
 
        // ����ѧ���������
        gradeServiceImpl=new GradeServiceImpl();
        // ��ȡȫ��ѧ���б�
        grades=gradeServiceImpl.findgradeAll();
        // ���������
        fillTableData();
 
        // ���ô�������
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
 
        // ���˳�����ť�����¼�
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
 
        // ����ӡ����ť�����¼�
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
 
        // ����ѯ����ť�����¼�
        btnQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                doQuery();
            }
        });
 
        // ����ʾȫ����¼����ť�����¼�
        btnBrowseAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // ��ȡȫ��ѧ����¼
            	grades=gradeServiceImpl.findgradeAll();
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
 
        // JTable�����¼�
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // ��ȡ��ǰ�е�����
                int row = table.rowAtPoint(e.getPoint());
                // ѡ����굥������
                table.setRowSelectionInterval(row, row);
                // �����ı�������
                txtId.setText(table.getValueAt(row, 2).toString());
            }
        });
    }
 
    /**
    * ��ѯ����
    */
    private void doQuery() {
        // ��ȡ��ѯѧ��
        String name = txtId.getText().trim();
        if (!name.equals("")) {
            grades.clear();
            grades=gradeServiceImpl.findgradeByClass(name);
           
            // �����
            fillTableData();
        } else {
            JOptionPane.showMessageDialog(this, "���������ѧ��������", "����", JOptionPane.WARNING_MESSAGE);
            txtId.requestFocus();
        }
    }
 
    /**
    * ����񷽷�
    */
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
 
        // �����¼
        rows.clear();//���
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
            // ����ǰ����ӵ���¼�м�
            rows.add(currentRow);
        }
 
        // ������񣨲���1����¼��������2����ͷ��
        table = new JTable(rows, colHead);
 
        // ����������
        scroller = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // �����������ӵ��������
        pnlCenter.add(scroller, BorderLayout.CENTER);
        
     // ���ô˱��Ƿ�ʼ�մ�����������ӿڵĸ߶ȡ�
			table.setFillsViewportHeight(true);
			table.setAutoCreateRowSorter(true);//��������
        // �ػ洰��
        repaint();
 
        // �ж��Ƿ��м�¼��
        if (rows.isEmpty()) {
        	System.out.println(rows);
            JOptionPane.showMessageDialog(this, "û�з��������ļ�¼��", "������ʾ", JOptionPane.WARNING_MESSAGE);
            txtId.setText("");
        } else {
            // �ù������Ƶ����Ϸ�
            scroller.getVerticalScrollBar().setValue(0);
        }
    }
    
}
