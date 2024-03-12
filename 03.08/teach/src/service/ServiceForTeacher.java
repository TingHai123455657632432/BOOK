package service;

import entity.Teacher;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author：邾头肉
 * @date：2024/3/9
 */
public class ServiceForTeacher {
    static Connection conn = null;
//    登录
    public static int login(String taccount,String tpassword) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "select tid from teacher where taccount=? and tpass=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,taccount);
            ps.setString(2,tpassword);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("tid");
            }else{
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    查看指定老师信息
    public static void queryTeacher(int tid) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "select * from teacher where tid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tid);
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("教师编号：" + rs.getInt("tid"));
                System.out.println("教师姓名：" + rs.getString("tname"));
                System.out.println("教师电话：" + rs.getString("tphone"));
                System.out.println("教师账号：" + rs.getString("taccount"));
                System.out.println("教师密码：" + rs.getString("tpass"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn,ps,rs);
        }
    }
//    查看所有老师信息
    public static void queryAllTeacher() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "select * from teacher";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                String tphone = rs.getString("tphone");
                String taccount = rs.getString("taccount");
                String tpassword = rs.getString("tpass");
                System.out.println("教师编号：" + tid + " 教师姓名："+ tname + " 教师电话："+ tphone + " 教师账号："+ taccount + " 教师密码："+ tpassword);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn,ps,rs);
        }
    }
//    修改指定老师信息
    public static void updateTeacher(Teacher teacher) {
        PreparedStatement ps = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "update teacher set tname=?,tphone=?,taccount=?,tpass=? where tid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,teacher.getTname());
            ps.setString(2,teacher.getTphone());
            ps.setString(3,teacher.getTaccount());
            ps.setString(4,teacher.getTpassword());
            ps.setInt(5,teacher.getTid());

            int i =ps.executeUpdate();
            if(i!=0) {
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
//    删除指定老师信息
    public static void deleteTeacher(int tid) {
        PreparedStatement ps = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "delete from teacher where tid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tid);
            int i =ps.executeUpdate();
            if(i!=0) {
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
//    添加老师信息
    public static void addTeacher(Teacher teacher) {
        PreparedStatement ps = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "insert into teacher(tname,tphone,taccount,tpass) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,teacher.getTname());
            ps.setString(2,teacher.getTphone());
            ps.setString(3,teacher.getTaccount());
            ps.setString(4,teacher.getTpassword());
            int i =ps.executeUpdate();
            if(i!=0) {
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn,ps,null);
        }
    }
//    获取当前登录老师所在班级名称
public static String getClassByTeacher(int tid) {
    conn = DBUtil.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String cname = null;
    try {
        String sql = "SELECT class.cname FROM teacher,class WHERE teacher.tid=? AND teacher.tid=class.tid;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, tid);
        rs = stmt.executeQuery();
        while (rs.next()) {
            cname = rs.getString(1);
        }
        return cname;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        DBUtil.closeConnection(conn, stmt, rs);
    }
}
}
