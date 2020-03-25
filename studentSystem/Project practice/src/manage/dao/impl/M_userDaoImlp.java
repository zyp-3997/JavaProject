package manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manage.bean.M_user;
import manage.dbutil.ConnectionManager;

public class M_userDaoImlp {
	public  M_user login(String username, String password){
	    // �����û�
	    M_user user = null;
	    // ��ȡ���ݿ�����
	    Connection conn = ConnectionManager.getConnection();
	    // ����SQL�ַ���
	    String strSQL = "SELECT * FROM m_user WHERE user_name = ? AND user_password = ?";
	    try {
	        // ����Ԥ��������
	        PreparedStatement pstmt = conn.prepareStatement(strSQL);
	        // ����ռλ����ֵ
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        // ִ�в�ѯ�����ؽ����
	        ResultSet rs = pstmt.executeQuery();
	        // �ж��Ƿ��м�¼
	        if (rs.next()) {
	            // ʵ�����û�
	            user = new M_user();
	            // �����û�����
	       user.setUser_id(rs.getInt("user_id"));
	       user.setUser_name(rs.getString("user_name"));
	       user.setPassword(rs.getString("user_password"));
	       user.setUser_tel(rs.getInt("user_tel"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        ConnectionManager.closeConnection(conn);
	    }

	    // �����û�
	    return user;
}}
