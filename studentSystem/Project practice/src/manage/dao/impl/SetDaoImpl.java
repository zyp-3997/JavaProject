package manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import manage.bean.Set;
import manage.bean.SetClass;
import manage.bean.SetGrade;
import manage.bean.SetSort;
import manage.bean.SetSubject;
import manage.dbutil.ConnectionManager;

public class SetDaoImpl {

	public int insertgrade(SetGrade setGrade) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "insert into set_grade values(?,?)";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1,setGrade.getGrade_id());
            pstmt.setString(2, setGrade.getGrade_name());
            
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
        String strSQL = "DELETE FROM set_grade WHERE grade_id = ?";
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

	public List<SetGrade> findgrade() {
		List<SetGrade> sets=new ArrayList<SetGrade>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "select * from set_grade";
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
        	   SetGrade setGrade=new SetGrade();
        	   setGrade.setGrade_id(rs.getInt("grade_id"));
        	   setGrade.setGrade_name(rs.getString("grade_name"));
            	 /*Vector currentgrade=new Vector();
            	 currentgrade.addElement(rs.getInt("grade_id")+"");
            	 currentgrade.addElement(rs.getString("grade_name"));
            	 sets.addElement(currentgrade);*/
        	   sets.add(setGrade);
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
	public int insertclass(SetClass setClass) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "insert into set_class values(?,?,?)";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1,setClass.getClass_id());
            pstmt.setInt(2,setClass.getGrade_id());
            pstmt.setString(3,setClass.getClass_name());
            
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

	public int deleteclass(String id) {
		// ����ɾ����¼��
        int count = 0;
 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "DELETE FROM set_class WHERE class_id = ?";
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
	public List<SetClass> findClasses() {
		List<SetClass> sets=new ArrayList<SetClass>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "select * from set_class";
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
        	   SetClass setClass=new SetClass();
        	   setClass.setClass_id(rs.getInt("class_id"));
        	   setClass.setGrade_id(rs.getInt("grade_id"));
        	   setClass.setClass_name(rs.getString("Class_name"));
        	   sets.add(setClass);
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
	public int insertsubject(SetSubject setSubject) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "insert into set_subject values(?,?)";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1,setSubject.getSubject_id());
            pstmt.setString(2, setSubject.getSubject_name());
            
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

	public int deletesubject(String id) {
		// ����ɾ����¼��
        int count = 0;
 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "DELETE FROM set_subject WHERE subject_id = ?";
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
	public List<SetSubject> findsubject() {
		List<SetSubject> sets=new ArrayList<SetSubject>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "select * from set_subject";
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
        	  SetSubject setSubject=new SetSubject();
        	  setSubject.setSubject_id(rs.getInt("subject_id"));
        	  setSubject.setSubject_name(rs.getString("subject_name"));
        	   sets.add(setSubject);
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

	public int insertsort(SetSort setSort) {
		int count = 0;
		 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "insert into set_sort values(?,?)";
        try {
        	// ����Ԥ��������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
         // ����ռλ����ֵ
            pstmt.setInt(1,setSort.getSort_id());
            pstmt.setString(2, setSort.getSort_name());
            
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

	public int deletesort(String id) {
		// ����ɾ����¼��
        int count = 0;
 
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "DELETE FROM set_sort WHERE sort_id = ?";
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

	public List<SetSort> findsort() {
		List<SetSort> sets=new ArrayList<SetSort>();
        // ������ݿ�����
        Connection conn = ConnectionManager.getConnection();
        // ����SQL�ַ���
        String strSQL = "select * from set_sort";
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
        	   SetSort setSort=new SetSort();
        	   setSort.setSort_id(rs.getInt("sort_id"));
        	   setSort.setSort_name(rs.getString("sort_name"));
        	   sets.add(setSort);
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
