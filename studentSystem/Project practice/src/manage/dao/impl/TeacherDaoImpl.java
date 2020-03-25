package manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import manage.bean.Teacher;
import manage.dbutil.ConnectionManager;

public  class TeacherDaoImpl{
public int addinfoinfor(Teacher teacher) {
	int count = 0;
	 
    // ������ݿ�����
    Connection conn = ConnectionManager.getConnection();
    // ����SQL�ַ���
    String strSQL = "insert into teacher values(?,?,?,?,?,?,?)";
    try {
    	// ����Ԥ��������
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
     // ����ռλ����ֵ
        pstmt.setInt(1, teacher.getTeacher_id());
        pstmt.setInt(2, teacher.getClass_id());
        pstmt.setString(3, teacher.getTeacher_name());
        pstmt.setString(4, teacher.getTeacher_sex());
        pstmt.setString(5, teacher.getTeacher_major());
        pstmt.setString(6, teacher.getTeacher_level());
        pstmt.setInt(7, teacher.getTeacher_tel());
        
        
        //ִ�в������ݲ���
        count=pstmt.executeUpdate();
	} catch (Exception e) {
      e.printStackTrace();
	}
    finally{
    	ConnectionManager.closeConnection(conn);
    }
    //���ؼ�¼��
	return count;
}


public int updateinfor(Teacher teacher) {
	int count = 0;
	 
    // ������ݿ�����
    Connection conn = ConnectionManager.getConnection();
    // ����SQL�ַ���
    String strSQL = "update teacher SET class_id= ?, teacher_name = ?, teacher_sex = ?, teacher_major = ?, teacher_level = ?, teacher_tel = ? where teacher_id=?";
    try {
    	// ����Ԥ��������
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
     // ����ռλ����ֵ
        pstmt.setInt(1, teacher.getClass_id());
        pstmt.setString(2, teacher.getTeacher_name());
        pstmt.setString(3, teacher.getTeacher_sex());
        pstmt.setString(4, teacher.getTeacher_major());
        pstmt.setString(5, teacher.getTeacher_level());
        pstmt.setInt(6, teacher.getTeacher_tel());
        pstmt.setInt(7, teacher.getTeacher_id());
        
        //ִ�в������ݲ���
        count=pstmt.executeUpdate();
	} catch (Exception e) {
      e.printStackTrace();
	}
    finally{
    	ConnectionManager.closeConnection(conn);
    }
    //���ؼ�¼��
	return count;
}

public int deleteinfor(String id) {
	// ����ɾ����¼��
    int count = 0;

    // ������ݿ�����
    Connection conn = ConnectionManager.getConnection();
    // ����SQL�ַ���
    String strSQL = "DELETE FROM teacher WHERE teacher_id = ?";
    try {
        // ����Ԥ��������
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        // ����ռλ����ֵ
        pstmt.setString(1,id);
        // ִ�и��²�����ɾ����¼
        count = pstmt.executeUpdate();
        // �ر�Ԥ��������
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ConnectionManager.closeConnection(conn);
    }

    // ����ɾ����¼��

	return count;
}

public List<Teacher> findinforAll() {
	List<Teacher> sets=new ArrayList<Teacher>();
    // ������ݿ�����
    Connection conn = ConnectionManager.getConnection();
    // ����SQL�ַ���
    String strSQL = "select * from teacher";
    try {
        // ����Ԥ��������
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        // ����ռλ����ֵ
     // ����������
        Statement stmt = conn.createStatement();
        // ִ��SQL�����ؽ����
        ResultSet rs = stmt.executeQuery(strSQL);

        // ���������
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

public Teacher findinforById(String id){
    // ����ѧ��
	Teacher  teacher=null;
    // ��ȡ���ݿ����Ӷ���
    Connection conn = ConnectionManager.getConnection();
    // ����SQL�ַ���
    String strSQL = "SELECT * FROM teacher WHERE teacher_id = ?";
    try {
        // ����Ԥ��������
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        // ����ռλ����ֵ
        pstmt.setString(1, id);
        // ִ��SQL��ѯ�����ؽ����
        ResultSet rs = pstmt.executeQuery();
        // �жϽ�����Ƿ��м�¼
        if (rs.next()) {
            // ����ѧ��ʵ��
        	  teacher=new Teacher();
      	   teacher.setTeacher_id(rs.getInt("teacher_id"));
      	   teacher.setClass_id(rs.getInt("class_id"));
      	   teacher.setTeacher_name(rs.getString("teacher_name"));
      	   teacher.setTeacher_sex(rs.getString("teacher_sex"));
      	   teacher.setTeacher_major(rs.getString("teacher_major"));
      	   teacher.setTeacher_level(rs.getString("teacher_level"));
      	   teacher.setTeacher_tel(rs.getInt("teacher_tel"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ConnectionManager.closeConnection(conn);
    }

    // ����ѧ��
    return teacher;
}

}
