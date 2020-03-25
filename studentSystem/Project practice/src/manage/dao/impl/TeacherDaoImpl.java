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
	 
    // 获得数据库连接
    Connection conn = ConnectionManager.getConnection();
    // 定义SQL字符串
    String strSQL = "insert into teacher values(?,?,?,?,?,?,?)";
    try {
    	// 创建预备语句对象
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
     // 设置占位符的值
        pstmt.setInt(1, teacher.getTeacher_id());
        pstmt.setInt(2, teacher.getClass_id());
        pstmt.setString(3, teacher.getTeacher_name());
        pstmt.setString(4, teacher.getTeacher_sex());
        pstmt.setString(5, teacher.getTeacher_major());
        pstmt.setString(6, teacher.getTeacher_level());
        pstmt.setInt(7, teacher.getTeacher_tel());
        
        
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


public int updateinfor(Teacher teacher) {
	int count = 0;
	 
    // 获得数据库连接
    Connection conn = ConnectionManager.getConnection();
    // 定义SQL字符串
    String strSQL = "update teacher SET class_id= ?, teacher_name = ?, teacher_sex = ?, teacher_major = ?, teacher_level = ?, teacher_tel = ? where teacher_id=?";
    try {
    	// 创建预备语句对象
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
     // 设置占位符的值
        pstmt.setInt(1, teacher.getClass_id());
        pstmt.setString(2, teacher.getTeacher_name());
        pstmt.setString(3, teacher.getTeacher_sex());
        pstmt.setString(4, teacher.getTeacher_major());
        pstmt.setString(5, teacher.getTeacher_level());
        pstmt.setInt(6, teacher.getTeacher_tel());
        pstmt.setInt(7, teacher.getTeacher_id());
        
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
    String strSQL = "DELETE FROM teacher WHERE teacher_id = ?";
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

public List<Teacher> findinforAll() {
	List<Teacher> sets=new ArrayList<Teacher>();
    // 获得数据库连接
    Connection conn = ConnectionManager.getConnection();
    // 定义SQL字符串
    String strSQL = "select * from teacher";
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

    // 返回删除记录数

	return sets;
}

public Teacher findinforById(String id){
    // 声明学生
	Teacher  teacher=null;
    // 获取数据库连接对象
    Connection conn = ConnectionManager.getConnection();
    // 定义SQL字符串
    String strSQL = "SELECT * FROM teacher WHERE teacher_id = ?";
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

    // 返回学生
    return teacher;
}

}
