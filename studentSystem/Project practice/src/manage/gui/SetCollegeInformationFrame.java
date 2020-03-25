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
import manage.dbutil.ConnectionManager;
 
public class SetCollegeInformationFrame extends JFrame {
 
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
    * 学校服务
    */
    /**
    * 学校对象
    */
    private College college;
    /**
    * 学校标识符
    */
    private int id = 1;
 
    /**
    * 构造方法
    * 
    * @param title
    */
    public SetCollegeInformationFrame(String title) {
        super(title);
        // 创建学校服务对象
        initGUI();
    }
 
    /**
    * 初始化用户界面
    */
    private void initGUI() {
        // 创建组件
        panel = (JPanel) getContentPane();
        pnlNorth = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
 
        lblName = new JLabel("学校名称：");
        lblPresident = new JLabel("校         长：");
        lblStartTime = new JLabel("建校时间：");
        lblTelephone = new JLabel("联系电话：");
        lblEmail = new JLabel("电子邮箱：");
        lblAddress = new JLabel("通讯地址：");
        lblProfile = new JLabel("学校简介：");
 
        txtName = new JTextField(30);
        txtPresident = new JTextField(11);
        txtStartTime = new JTextField(12);
        txtTelephone = new JTextField(11);
        txtEMail = new JTextField(12);
        txtAddress = new JTextField(30);
        txtProfile = new JTextArea(5, 37);
        txtProfile.setLineWrap(true);// 让文本区自动换行
        scrollPane = new JScrollPane(txtProfile, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        btnSave = new JButton("保存[S]");
        btnSave.setMnemonic(KeyEvent.VK_S);
        btnExit = new JButton("退出[X]");
        btnExit.setMnemonic(KeyEvent.VK_X);
 
        // 添加组件
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
 
        // 获取学校对象
        college = findById(id);
        txtName.setText(college.getName());
        txtPresident.setText(college.getPresident());
        txtStartTime.setText(college.getStartTime().toString());
        txtTelephone.setText(college.getTelephone());
        txtEMail.setText(college.getEmail());
        txtAddress.setText(college.getAddress());
        txtProfile.setText(college.getProfile());
 
        // 设置窗口属性
        setVisible(true);
        setSize(450, 350);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
 
        // 给【关闭】按钮注册监听器
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // 关闭窗口
                dispose();
            }
        });
 
        // 给【保存】按钮注册监听器
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {   
                    // 修改学校对象属性
                    college.setName(txtName.getText());
                    college.setPresident(txtPresident.getText());
                    college.setStartTime(new Timestamp(
                            new SimpleDateFormat("yyyy-MM-dd")
                            .parse(txtStartTime.getText().toString()).getTime()));
                    college.setTelephone(txtTelephone.getText());
                    college.setEmail(txtEMail.getText());
                    college.setAddress(txtAddress.getText());
                    college.setProfile(txtProfile.getText());
                    // 更新学校信息
                   update(college);
                    // 提示用户更新成功
                    JOptionPane.showMessageDialog(null, "更新数据成功！");                  
                } catch (ParseException e) {
                    // 提示用户更新失败
                    JOptionPane.showMessageDialog(null, "更新数据失败！");
                }
            }
        });
 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 关闭窗口
                dispose();
            }
        });
        
        
    }
    
    public College findById(int id) {
        // 声明学校对象
        College college = null;
 
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM t_college WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setInt(1, id);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 实例化学校
                college = new College();
                // 利用当前记录字段值去设置学校对象的属性
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
 
        // 返回学校对象
        return college;
    }
 
    public int update(College college) {
        // 定义更新记录数
        int count = 0;
 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "UPDATE t_college SET name = ?, president = ?, start_time = ?,"
                + " telephone = ?, email = ?, address = ?, profile = ? WHERE id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, college.getName());
            pstmt.setString(2, college.getPresident());
            pstmt.setTimestamp(3, new Timestamp(college.getStartTime().getTime()));
            pstmt.setString(4, college.getTelephone());
            pstmt.setString(5, college.getEmail());
            pstmt.setString(6, college.getAddress());
            pstmt.setString(7, college.getProfile());
            pstmt.setInt(8, college.getId());
            // 执行更新操作，更新记录
            count = pstmt.executeUpdate();
            // 关闭预备语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
 
        // 返回更新记录数
        return count;
    }
}

