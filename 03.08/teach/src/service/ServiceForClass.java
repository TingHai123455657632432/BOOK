package service;

import entity.Class1;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author：邾头肉
 * @date：2024/3/9
 */
public class ServiceForClass {
    static Connection conn =null;
//    查看所有班级信息
    public static void queryAllClass() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from class";
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String cname = resultSet.getString("cname");
                int tid = resultSet.getInt("tid");
                int sid=resultSet.getInt("sid");
                System.out.println("班级名称：" + cname + "  班主任：" + tid+"  学生：" + sid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn,ps,resultSet);
        }
    }
//    查看指定班级信息
    public static void queryClass(String cname) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from class where cname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cname);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String cname1 = resultSet.getString("cname");
                int tid = resultSet.getInt("tid");
                int sid=resultSet.getInt("sid");
                System.out.println("班级名称：" + cname1 + "  班主任：" + tid+"  学生：" + sid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn,ps,resultSet);
        }
    }
//    修改指定班级信息
    public static void updateClass(String cname,int tid,int sid) {
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update class set tid=?,sid=? where cname=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tid);
            ps.setInt(2,sid);
            ps.setString(3,cname);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
//    添加班级信息
    public static void addClass(String cname,int tid,int sid) {
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into class(cname,tid,sid) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cname);
            ps.setInt(2,tid);
            ps.setInt(3,sid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
//    删除指定班级信息
    public static void deleteClass(String cname) {
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from class where cname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cname);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
//根据学生编号删除班级信息
    public static void deleteClassByStudent(int sid) {
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from class where sid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
}
