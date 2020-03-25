package manage.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionManager {
    /**
     * ���ݿ���������
     */
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * ���ݿ�ͳһ��Դ��ʶ��
     */
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    /**
     * ���ݿ��û���
     */
    private static final String USERNAME = "root";
    /**
     * ���ݿ�����
     */
    private static final String PASSWORD = "3997";
 
    /**
     * ˽�л����췽�����ܾ�ʵ����
     */
    private ConnectionManager() {
    }
 
    /**
     * ������ݿ�����
     *
     * @return ���ݿ����Ӷ���
     */
    public static Connection getConnection() {
        // �������ݿ�����
        Connection conn = null;
        try {
            // ��װ���ݿ���������
            Class.forName(DRIVER);
            // ������ݿ�����
            conn = DriverManager.getConnection(URL
                    + "?useUnicode=true&characterEncoding=UTF8", USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // �������ݿ�����
        return conn;
    }
 
    /**
     * �ر����ݿ�����
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        // �ж����ݿ������Ƿ�Ϊ��
        if (conn != null) {
            // �ж����ݿ������Ƿ�ر�
            try {
                if (!conn.isClosed()) {
                    // �ر����ݿ�����
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * �������ݿ������Ƿ�ɹ�
     *
     * @param args
     */
    public static void main(String[] args) {
        // ������ݿ�����
      /*  Connection conn = getConnection();
        // �ж��Ƿ����ӳɹ�
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "��ϲ�����ݿ����ӳɹ���");
        } else {
            JOptionPane.showMessageDialog(null, "�ź������ݿ�����ʧ�ܣ�");
        }
 
        // �ر����ݿ�����
        closeConnection(conn);*/
    }
}