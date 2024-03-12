package service;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author：邾头肉
 * @date：2024/3/9
 */
public class ServiceForCourse {
    static Connection conn = null;
//    查看所有课程信息
    public static void queryAllCourse() {
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select * from course";
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cid=rs.getInt("cid");
                String cname=rs.getString("cname");
                int tid=rs.getInt("tid");
                System.out.println("课程编号"+cid+"课程名称"+cname+"任课老师编号"+tid);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn, null, rs);
        }
    }
//    添加课程信息
    public static void addCourse(String cname,int tid) {
        conn = DBUtil.getConnection();
        try {
            String sql = "insert into course(cname,tid) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cname);
            ps.setInt(2,tid);
            int i=ps.executeUpdate();
            if( i != 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn, null, null);
        }
    }
//    删除指定课程信息
    public static void deleteCourse(int cid) {
        conn = DBUtil.getConnection();
        try {
            String sql = "delete from course where cid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);
            int i=ps.executeUpdate();
            if(i != 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn, null, null);
        }
    }
//    查看指定课程信息
    public static void queryCourse(int cid) {
        conn = DBUtil.getConnection();
        ResultSet rs = null;
        try {
            String sql = "select * from course where cid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id=rs.getInt("cid");
                String cname=rs.getString("cname");
                int tid=rs.getInt("tid");
                System.out.println("课程编号"+cid+"课程名称"+cname+"任课老师编号"+tid);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn, null, rs);
        }
    }
//    修改指定课程信息
    public static void updateCourse(int cid,String cname,int tid) {
        conn = DBUtil.getConnection();
        try {
            String sql = "update course set cname=?,tid=? where cid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cname);
            ps.setInt(2,tid);
            ps.setInt(3,cid);
            ps.executeUpdate();
            if( ps.executeUpdate() != 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn, null, null);
        }
    }
}
