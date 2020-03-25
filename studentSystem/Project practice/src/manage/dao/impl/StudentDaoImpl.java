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
		 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "insert into student values(?,?,?,?,?,?,?)";
        try {
        	// 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // 设置占位符的值
            pstmt.setInt(1, student.getStudent_id());
            pstmt.setInt(2, student.getClass_id());
            pstmt.setString(3, student.getStudent_name());
            pstmt.setString(4, student.getStudent_sex());
            pstmt.setInt(5, student.getStudent_age());
            pstmt.setString(6, student.getStudent_adress());
            pstmt.setInt(7, student.getStudent_tel());
            
            
            //执行插入数据操作
            count=pstmt.executeUpdate();
		} catch (Exception e) {
          e.printStackTrace();
		}
        finally{
        	ConnectionManager.closeConnection(conn);
        }
        //返回记录数
		return count;
	}
	
	
	public int updateinfor(Student student) {
		int count = 0;
		 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "update student SET class_id= ?, student_name = ?, student_sex = ?, student_age = ?, student_adress = ?, student_tel = ? where student_id=?";
        try {
        	// 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // 设置占位符的值
            pstmt.setInt(1, student.getClass_id());
            pstmt.setString(2, student.getStudent_name());
            pstmt.setString(3, student.getStudent_sex());
            pstmt.setInt(4, student.getStudent_age());
            pstmt.setString(5, student.getStudent_adress());
            pstmt.setInt(6, student.getStudent_tel());
            pstmt.setInt(7, student.getStudent_id());
            
            //执行插入数据操作
            count=pstmt.executeUpdate();
		} catch (Exception e) {
          e.printStackTrace();
		}
        finally{
        	ConnectionManager.closeConnection(conn);
        }
        //返回记录数
		return count;
	}

	public int deleteinfor(String id) {
		// 定义删除记录数
        int count = 0;
 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "DELETE FROM student WHERE student_id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1,id);
            // 执行更新操作，删除记录
            count = pstmt.executeUpdate();
            // 关闭预备语句对象
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
 
        // 返回删除记录数

		return count;
	}

	public List<Student> findinforAll() {
		List<Student> sets=new ArrayList<Student>();
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "select * from student";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
         // 创建语句对象
            Statement stmt = conn.createStatement();
            // 执行SQL，返回结果集
            ResultSet rs = stmt.executeQuery(strSQL);

            // 遍历结果集
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
 
        // 返回删除记录数

		return sets;
	}
	
	public Student findinforById(String id){
        // 声明学生
       Student student=null;
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM student WHERE student_id = ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, id);
            // 执行SQL查询，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 判断结果集是否有记录
            if (rs.next()) {
                // 创建学生实体
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
 
        // 返回学生
        return student;
    }
	

}
