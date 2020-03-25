package manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import manage.bean.S_user;
import manage.dbutil.ConnectionManager;


public class S_userDaoImpl {
	public  S_user login(String username, String password){
    // 声明用户
    S_user user = null;
    // 获取数据库连接
    Connection conn = ConnectionManager.getConnection();
    // 定义SQL字符串
    String strSQL = "SELECT * FROM s_user WHERE user_name = ? AND user_password = ?";
    try {
        // 创建预备语句对象
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        // 设置占位符的值
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        // 执行查询，返回结果集
        ResultSet rs = pstmt.executeQuery();
        // 判断是否有记录
        if (rs.next()) {
            // 实例化用户
            user = new S_user();
            // 设置用户属性
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

    // 返回用户
    return user;
}}