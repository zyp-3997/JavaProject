package manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import manage.bean.Grade;
import manage.bean.Student;
import manage.dbutil.ConnectionManager;


public class GradeDaoImpl {
	
	public int addgrade(Grade grade) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "insert into grade values(?,?,?,?,?,?,?,?,?)";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1, grade.getStudent_id());
            pstmt.setString(2, grade.getStudent_names());
            pstmt.setString(3, grade.getClass_names());
            pstmt.setInt(4, grade.getChinese());
            pstmt.setInt(5, grade.getMath());
            pstmt.setInt(6, grade.getEnglish());
            pstmt.setInt(7, grade.getPhysics());
            pstmt.setInt(8, grade.getChemistry());
            pstmt.setInt(9, grade.getBiolog());
            
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
	
	
	public int updategrade(Grade grade) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "update grade SET chinese = ?, math = ?, english = ?,physics = ?, chemistry = ?, biolog = ? where student_id=?";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1, grade.getChinese());
            pstmt.setInt(2, grade.getMath());
            pstmt.setInt(3, grade.getEnglish());
            pstmt.setInt(4, grade.getPhysics());
            pstmt.setInt(5, grade.getChemistry());
            pstmt.setInt(6, grade.getBiolog());
            pstmt.setInt(7, grade.getStudent_id());
            
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

	public int deletegrade(String id) {
		// ����ɾ����¼��
        int count = 0;
 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "DELETE FROM grade WHERE student_id = ?";
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

	public List<Grade> findgradeAll() {
		List<Grade> sets=new ArrayList<Grade>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "select * from grade";
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
        	   Grade grade=new Grade();
        	   grade.setStudent_id(rs.getInt("student_id"));
        	   grade.setStudent_names(rs.getString("student_name"));
        	   grade.setClass_names(rs.getString("class_name"));
        	   grade.setChinese(rs.getInt("chinese"));
        	   grade.setMath(rs.getInt("math"));
        	   grade.setEnglish(rs.getInt("english"));
        	   grade.setPhysics(rs.getInt("physics"));
        	   grade.setChemistry(rs.getInt("chemistry"));
        	   grade.setBiolog(rs.getInt("biolog"));
        	   
        	   
        	   sets.add(grade);
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
	

    public Grade findgradeById(String id){
        // ����ѧ��
        Grade grade=null;
 
        // ��ȡ���ݿ����Ӷ���
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "SELECT * FROM grade WHERE student_id = ?";
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
            	grade=new Grade();
                // ����ʵ������
            	 grade.setStudent_id(rs.getInt("student_id"));
          	   grade.setStudent_names(rs.getString("student_name"));
          	   grade.setClass_names(rs.getString("class_name"));
          	   grade.setChinese(rs.getInt("chinese"));
          	   grade.setMath(rs.getInt("math"));
          	   grade.setEnglish(rs.getInt("english"));
          	   grade.setPhysics(rs.getInt("physics"));
          	   grade.setChemistry(rs.getInt("chemistry"));
          	   grade.setBiolog(rs.getInt("biolog"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
 
        // ����ѧ��
        return grade;
    }
	
	
	
	public List<Grade> findgradeByname(String name) {
		List<Grade> sets=new ArrayList<Grade>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
     // ����SQL�ַ���
        String strSQL = "SELECT * FROM grade WHERE student_name LIKE ?";
        try {
            // ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // ����ռλ����ֵ
            pstmt.setString(1, name + "%");
            // ִ��SQL�����ؽ����
            ResultSet rs = pstmt.executeQuery();
            // ���������
           while(rs.next()){
        	   
        	   Grade grade=new Grade();
        	   grade.setStudent_id(rs.getInt("student_id"));
        	   grade.setStudent_names(rs.getString("student_name"));
        	   grade.setClass_names(rs.getString("class_name"));
        	   grade.setChinese(rs.getInt("chinese"));
        	   grade.setMath(rs.getInt("math"));
        	   grade.setEnglish(rs.getInt("english"));
        	   grade.setPhysics(rs.getInt("physics"));
        	   grade.setChemistry(rs.getInt("chemistry"));
        	   grade.setBiolog(rs.getInt("biolog"));
        	   
        	   
        	   sets.add(grade);
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
	public List<Grade> findgradeByClass(String name) {
		List<Grade> sets=new ArrayList<Grade>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "SELECT * FROM grade WHERE class_name LIKE ?";
        try {
            // ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // ����ռλ����ֵ
            pstmt.setString(1, name + "%");
            // ִ��SQL�����ؽ����
            ResultSet rs = pstmt.executeQuery();
            // ���������
           while(rs.next()){
        	   
        	   Grade grade=new Grade();
        	   grade.setStudent_id(rs.getInt("student_id"));
        	   grade.setStudent_names(rs.getString("student_name"));
        	   grade.setClass_names(rs.getString("class_name"));
        	   grade.setChinese(rs.getInt("chinese"));
        	   grade.setMath(rs.getInt("math"));
        	   grade.setEnglish(rs.getInt("english"));
        	   grade.setPhysics(rs.getInt("physics"));
        	   grade.setChemistry(rs.getInt("chemistry"));
        	   grade.setBiolog(rs.getInt("biolog"));
        	   
        	   
        	   sets.add(grade);
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

 
}
