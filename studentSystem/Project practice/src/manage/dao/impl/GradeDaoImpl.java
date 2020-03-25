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
		 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "insert into grade values(?,?,?,?,?,?,?,?,?)";
        try {
        	// 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // 设置占位符的值
            pstmt.setInt(1, grade.getStudent_id());
            pstmt.setString(2, grade.getStudent_names());
            pstmt.setString(3, grade.getClass_names());
            pstmt.setInt(4, grade.getChinese());
            pstmt.setInt(5, grade.getMath());
            pstmt.setInt(6, grade.getEnglish());
            pstmt.setInt(7, grade.getPhysics());
            pstmt.setInt(8, grade.getChemistry());
            pstmt.setInt(9, grade.getBiolog());
            
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
	
	
	public int updategrade(Grade grade) {
		int count = 0;
		 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "update grade SET chinese = ?, math = ?, english = ?,physics = ?, chemistry = ?, biolog = ? where student_id=?";
        try {
        	// 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // 设置占位符的值
            pstmt.setInt(1, grade.getChinese());
            pstmt.setInt(2, grade.getMath());
            pstmt.setInt(3, grade.getEnglish());
            pstmt.setInt(4, grade.getPhysics());
            pstmt.setInt(5, grade.getChemistry());
            pstmt.setInt(6, grade.getBiolog());
            pstmt.setInt(7, grade.getStudent_id());
            
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

	public int deletegrade(String id) {
		// 定义删除记录数
        int count = 0;
 
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "DELETE FROM grade WHERE student_id = ?";
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

	public List<Grade> findgradeAll() {
		List<Grade> sets=new ArrayList<Grade>();
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "select * from grade";
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
 
        // 返回删除记录数

		return sets;
	}
	

    public Grade findgradeById(String id){
        // 声明学生
        Grade grade=null;
 
        // 获取数据库连接对象
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM grade WHERE student_id = ?";
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
            	grade=new Grade();
                // 设置实体属性
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
 
        // 返回学生
        return grade;
    }
	
	
	
	public List<Grade> findgradeByname(String name) {
		List<Grade> sets=new ArrayList<Grade>();
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
     // 定义SQL字符串
        String strSQL = "SELECT * FROM grade WHERE student_name LIKE ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, name + "%");
            // 执行SQL，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 遍历结果集
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
 
        // 返回删除记录数

		return sets;
	}
	public List<Grade> findgradeByClass(String name) {
		List<Grade> sets=new ArrayList<Grade>();
        // 获得数据库连接
        Connection conn = ConnectionManager.getConnection();
        // 定义SQL字符串
        String strSQL = "SELECT * FROM grade WHERE class_name LIKE ?";
        try {
            // 创建预备语句对象
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 设置占位符的值
            pstmt.setString(1, name + "%");
            // 执行SQL，返回结果集
            ResultSet rs = pstmt.executeQuery();
            // 遍历结果集
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
 
        // 返回删除记录数

		return sets;
	}

 
}
