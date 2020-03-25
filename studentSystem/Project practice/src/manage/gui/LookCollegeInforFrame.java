package manage.gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 





import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import manage.bean.College;
import manage.bean.Grade;
import manage.bean.SetClass;
import manage.dbutil.ConnectionManager;
 
public class LookCollegeInforFrame extends JFrame {
 
    JPanel panel;
    JPanel pnlNorth, p1, p2, p3, p4, p5;
    JPanel pnlCenter;
    JPanel pnlSouth;
 
    JLabel lblName;
    JLabel lblPresident;
    JLabel lblStartTime;
    JLabel lblTelephone;
    JLabel lblEmail;
    JLabel lblAddress;
    JLabel lblProfile;
 
    JTextField txtName;
    JTextField txtPresident;
    JTextField txtStartTime;
    JTextField txtTelephone;
    JTextField txtEMail;
    JTextField txtAddress;
    JTextArea txtProfile;
    JScrollPane scrollPane;
    JButton btnSave;
    JButton btnExit;
    /**
    * ѧУ����
    */
    /**
    * ѧУ����
    */
    private College college;
    /**
    * ѧУ��ʶ��
    */
    private int id = 1;
 
    /**
    * ���췽��
    * 
    * @param title
    */
    public LookCollegeInforFrame(String title) {
        super(title);
        // ����ѧУ�������
        initGUI();
    }
 
    /**
    * ��ʼ���û�����
    */
    private void initGUI() {
        // �������
        panel = (JPanel) getContentPane();
        pnlNorth = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
 
        lblName = new JLabel("ѧУ���ƣ�");
        lblPresident = new JLabel("У         ����");
        lblStartTime = new JLabel("��Уʱ�䣺");
        lblTelephone = new JLabel("��ϵ�绰��");
        lblEmail = new JLabel("�������䣺");
        lblAddress = new JLabel("ͨѶ��ַ��");
        lblProfile = new JLabel("ѧУ��飺");
 
        txtName = new JTextField(30);
        txtPresident = new JTextField(11);
        txtStartTime = new JTextField(12);
        txtTelephone = new JTextField(11);
        txtEMail = new JTextField(12);
        txtAddress = new JTextField(30);
        txtProfile = new JTextArea(5, 37);
        txtProfile.setLineWrap(true);// ���ı����Զ�����
        scrollPane = new JScrollPane(txtProfile, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        btnSave = new JButton("ȷ��");
        btnSave.setMnemonic(KeyEvent.VK_S);
        btnExit = new JButton("�˳�");
        btnExit.setMnemonic(KeyEvent.VK_X);
 
        // ������
        panel.setLayout(new BorderLayout());
        panel.add(pnlNorth, "North");
        panel.add(pnlCenter, "Center");
        panel.add(pnlSouth, "South");
 
        pnlNorth.setLayout(new GridLayout(5, 1));
        pnlNorth.add(p1);
        pnlNorth.add(p2);
        pnlNorth.add(p3);
        pnlNorth.add(p4);
        pnlNorth.add(p5);
 
        p1.add(lblName);
        p1.add(txtName);
        p2.add(lblPresident);
        p2.add(txtPresident);
        p2.add(lblStartTime);
        p2.add(txtStartTime);
        p3.add(lblTelephone);
        p3.add(txtTelephone);
        p3.add(lblEmail);
        p3.add(txtEMail);
        p4.add(lblAddress);
        p4.add(txtAddress);
        p5.add(lblProfile);
        pnlCenter.add(scrollPane);
        pnlSouth.add(btnSave);
        pnlSouth.add(btnExit);
 
        //
        
        txtName.setEditable(false);
        txtPresident.setEditable(false);
        txtStartTime.setEditable(false);
        txtTelephone.setEditable(false);
        txtEMail.setEditable(false);
        txtAddress.setEditable(false);;
        txtProfile.setEditable(false);
        
        // ��ȡѧУ����
        college = findById(id);
        txtName.setText(college.getName());
        txtPresident.setText(college.getPresident());
        txtStartTime.setText(college.getStartTime().toString());
        txtTelephone.setText(college.getTelephone());
        txtEMail.setText(college.getEmail());
        txtAddress.setText(college.getAddress());
        txtProfile.setText(college.getProfile());
 
        // ���ô�������
        setVisible(true);
        setSize(450, 350);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
 
        // �����رա���ťע�������
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // �رմ���
                dispose();
            }
        });
 
        // �������桿��ťע�������
        btnSave.addActionListener(new ActionListener() {
        	  @Override
              public void actionPerformed(ActionEvent event) {
                  // �رմ���
                  dispose();
              }
        });
 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // �رմ���
                dispose();
            }
        });
        
        
    }
    
    public College findById(int id) {
        // ����ѧУ����
        College college = null;
 
        // ��ȡ���ݿ����Ӷ���
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "SELECT * FROM t_college WHERE id = ?";
        try {
            // ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // ����ռλ����ֵ
            pstmt.setInt(1, id);
            // ִ��SQL��ѯ�����ؽ����
            ResultSet rs = pstmt.executeQuery();
            // �жϽ�����Ƿ��м�¼
            if (rs.next()) {
                // ʵ����ѧУ
                college = new College();
                // ���õ�ǰ��¼�ֶ�ֵȥ����ѧУ���������
                college.setId(rs.getInt("id"));
                college.setName(rs.getString("name"));
                college.setPresident(rs.getString("president"));
                college.setStartTime(rs.getDate("start_time"));
                college.setTelephone(rs.getString("telephone"));
                college.setEmail(rs.getString("email"));
                college.setAddress(rs.getString("address"));
                college.setProfile(rs.getString("profile"));                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
 
        // ����ѧУ����
        return college;
    }
   
}

