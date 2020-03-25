package manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import manage.bean.Grade;
import manage.bean.SetGrade;
import manage.bean.Student;
import manage.dbutil.ConnectionManager;

public class StudentDaoImpl{

	public int addinfo(Student student) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "insert into student values(?,?,?,?,?,?,?)";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1, student.getStudent_id());
            pstmt.setInt(2, student.getClass_id());
            pstmt.setString(3, student.getStudent_name());
            pstmt.setString(4, student.getStudent_sex());
            pstmt.setInt(5, student.getStudent_age());
            pstmt.setString(6, student.getStudent_adress());
            pstmt.setInt(7, student.getStudent_tel());
            
            
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
	
	
	public int updateinfor(Student student) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "update student SET class_id= ?, student_name = ?, student_sex = ?, student_age = ?, student_adress = ?, student_tel = ? where student_id=?";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1, student.getClass_id());
            pstmt.setString(2, student.getStudent_name());
            pstmt.setString(3, student.getStudent_sex());
            pstmt.setInt(4, student.getStudent_age());
            pstmt.setString(5, student.getStudent_adress());
            pstmt.setInt(6, student.getStudent_tel());
            pstmt.setInt(7, student.getStudent_id());
            
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
        String strSQL = "DELETE FROM student WHERE student_id = ?";
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

	public List<Student> findinforAll() {
		List<Student> sets=new ArrayList<Student>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "select * from student";
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
        	   Student student=new Student();
        	   student.setStudent_id(rs.getInt("student_id"));
        	   student.setClass_id(rs.getInt("class_id"));
        	   student.setStudent_name(rs.getString("student_name"));
        	   student.setStudent_sex(rs.getString("student_sex"));
        	   student.setStudent_age(rs.getInt("student_age"));
        	   student.setStudent_adress(rs.getString("student_adress"));
        	   student.setStudent_tel(rs.getInt("student_tel"));
        	
        	   sets.add(student);
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
	
	public Student findinforById(String id){
        // ����ѧ��
       Student student=null;
        // ��ȡ���ݿ����Ӷ���
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "SELECT * FROM student WHERE student_id = ?";
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
            	  student=new Student();
          	   student.setStudent_id(rs.getInt("student_id"));
          	   student.setClass_id(rs.getInt("class_id"));
          	   student.setStudent_name(rs.getString("student_name"));
          	   student.setStudent_sex(rs.getString("student_sex"));
          	   student.setStudent_age(rs.getInt("student_age"));
          	   student.setStudent_adress(rs.getString("student_adress"));
          	   student.setStudent_tel(rs.getInt("student_tel"));
          	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
 
        // ����ѧ��
        return student;
    }
	

}
