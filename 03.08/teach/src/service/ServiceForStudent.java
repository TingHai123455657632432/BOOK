package service;

import entity.Student;
import util.DBUtil;
import util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class ServiceForStudent {
    static Connection conn = null;

    //    查看所有学生
    public static void queryAllStudent() {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from student;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                Date sbirth = DateUtil.strToutilDate(rs.getString(3));
                String ssex = rs.getString(4);
                String saccount = rs.getString(5);
                String spassword = rs.getString(6);
                String saddress = rs.getString(7);
                System.out.println(sid + " 姓名：" + sname + " 生日：" + sbirth + " 性别：" + ssex + " 账号：" + saccount + " 密码：" + spassword + " 家庭住址：" + saddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    查看单个学生
    public static void queryStudent(int sid) {
        System.out.println("查询单个学生信息");
        conn = DBUtil.getConnection();
        Student student = new Student();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from student where sid=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                sid = rs.getInt(1);
                String sname = rs.getString(2);
                Date sbirth = DateUtil.strToutilDate(rs.getString(3));
                String ssex = rs.getString(4);
                String saccount = rs.getString(5);
                String spassword = rs.getString(6);
                String saddress = rs.getString(7);
                stmt = conn.prepareStatement(sql);
                System.out.println(sid + "\t姓名：" + sname + "\t生日：" + sbirth + "\t性别：" + ssex + "\t账号：" + saccount + "\t密码：" + spassword + "\t家庭住址：" + saddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    添加学生信息
    public static boolean addStudent(Student student) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "insert into student(sname,sbirth,ssex,saccount,spass,saddress) values(?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getSname());
            stmt.setDate(2, DateUtil.utilDateTosqlDate(student.getSbirth()));
            stmt.setString(3, student.getSsex());
            stmt.setString(4, student.getSaccount());
            stmt.setString(5, student.getSpassword());
            stmt.setString(6, student.getSaddress());
            int i = stmt.executeUpdate();
            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, null);
        }
    }

    //    修改学生信息
    public static void updateStudent(Student student) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "update student set sname=?,sbirth=?,ssex=?,saccount=?,spass=?,saddress=? where sid=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getSname());
            stmt.setDate(2, DateUtil.utilDateTosqlDate(student.getSbirth()));
            stmt.setString(3, student.getSsex());
            stmt.setString(4, student.getSaccount());
            stmt.setString(5, student.getSpassword());
            stmt.setString(6, student.getSaddress());
            stmt.setInt(7, student.getSid());
            int i = stmt.executeUpdate();
            if (i != 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, null);
        }
    }

    //    删除学生信息
    public static void deleteStudent(int sid) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "delete from student where sid=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
            int i = stmt.executeUpdate();
            if (i != 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, null);
        }
    }

    //    查看单个学生指定科目信息
    public static void queryStudentSubject(String sname, String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT score FROM score,student,course WHERE score.sid=student.sid AND score.cid=course.`cid` AND sname=? AND cname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, sname);
            stmt.setString(2, cname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String score = rs.getString(1);
                System.out.println(sname + "该科目成绩为" + score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    查看指定学生所有科目成绩
    public static void queryStudentAllSubject(String sname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cname,score from student,score,course where score.cid=course.cid and student.sid=score.sid and sname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, sname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cname = rs.getString(1);
                int score = rs.getInt(2);
                System.out.println(cname + "科目成绩为" + score);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    查看自己班级所有学生所有科目成绩
    public static void queryAllStudentAllSubject(String cname) {
        conn = DBUtil.getConnection();
        Student student = new Student();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT student.sname,course.cname,score FROM student,score,course,class WHERE student.`sid`=score.sid AND score.cid=course.cid AND class.sid=score.sid AND class.cname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String sname = rs.getString(1);
                String coursename = rs.getString(2);
                int score = rs.getInt(3);
                System.out.println(sname + "的" + coursename + "科目成绩为" + score);
            }
            if (rs.next() == false) {
                System.out.println("该班级没有学生");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //   登录
    public static int login(String saccount, String spassword) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT sid FROM student WHERE saccount=? AND spass=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, saccount);
            stmt.setString(2, spassword);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    查看自己班级所有学生指定科目成绩
    public static void queryAllStudentSubject(String course, String classname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT student.sname,score FROM student,score,course,class WHERE student.`sid`=score.sid AND score.cid=course.cid AND class.sid=score.sid AND class.cname=? AND course.`cname`=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, course);
            stmt.setString(2, classname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String score = rs.getString(2);
                System.out.println(name + "该科目成绩为" + score);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    删除指定班级指定学生信息
    public static void deleteStudent(String sname, String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        try {
            String sql = "DELETE FROM student WHERE sname=?;";
            String sql1 = "DELETE FROM class WHERE cname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, sname);
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, cname);
            int i=stmt.executeUpdate();
            int j=stmt1.executeUpdate();
            if((i+j)!=0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, null);
        }
    }

    //    查看指定班级所有学生信息
    public static void queryAllStudent(String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT student.* FROM student,class WHERE student.sid=class.sid AND class.cname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                Date sbirth = rs.getDate(3);
                String ssex = rs.getString(4);
                String saccount = rs.getString(5);
                String spassword = rs.getString(6);
                String saddress = rs.getString(7);
                System.out.println(sid + "姓名：" + sname + "生日：" + sbirth + "性别：" + ssex + "账号：" + saccount + "密码：" + spassword + "家庭住址：" + saddress);
            }
            if (rs.next() == false) {
                System.out.println("该班级没有学生");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    查看指定班级指定学生信息
    public static void queryStudent(String sname, String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT student.* FROM student,class WHERE student.sid=class.sid AND class.cname=? AND sname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cname);
            stmt.setString(2, sname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt(1);
                String name = rs.getString(2);
                Date sbirth = rs.getDate(3);
                String ssex = rs.getString(4);
                String saccount = rs.getString(5);
                String spassword = rs.getString(6);
                String saddress = rs.getString(7);
                System.out.println(sid + "姓名：" + sname + "生日：" + sbirth + "性别：" + ssex + "账号：" + saccount + "密码：" + spassword + "家庭住址：" + saddress);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    查看所有学生成绩信息
    public static void queryAllScore() {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT student.sname,cname,score FROM student,score,course WHERE student.sid=score.sid AND course.cid=score.cid;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String cname = rs.getString(2);
                String score = rs.getString(3);
                System.out.println(name+ "的"+cname+ "科目成绩为" + score);
            }
            if (rs.next() == false) {
                System.out.println("该学生没有成绩");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    查看指定班级所有学生信息
    public static void queryclassAll(String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT student.* FROM student,class WHERE student.sid=class.sid AND class.cname=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                Date sbirth = rs.getDate(3);
                String ssex = rs.getString(4);
                String saccount = rs.getString(5);
                String spassword = rs.getString(6);
                String saddress = rs.getString(7);
                System.out.println(sid + "姓名：" + sname + "生日：" + sbirth + "性别：" + ssex + "账号：" + saccount + "密码：" + spassword + "家庭住址：" + saddress);
            }
            if (rs.next() == false) {
                System.out.println("该班级没有学生");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //   获取刚添加的学生ID
    public static int getNewStudentId() {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int sid = 0;
        try {
            String sql = "SELECT MAX(sid) FROM student;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                sid = rs.getInt(1);
            }
            return sid;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }

    //    将指定学生添加到指定班级
    public static void addStudentToClass(int sid, String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        int tid = 0;
        try {
            String sql = "INSERT INTO class VALUES(?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cname);
            if (cname.equals("一班")) {
                tid = 2;
            } else if (cname.equals("二班")) {
                tid = 3;
            } else if (cname.equals("三班")) {
                tid = 1;
            }
            stmt.setInt(2, tid);
            stmt.setInt(3, sid);
            int i = stmt.executeUpdate();
            if (i != 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, null);
        }
    }
//    查看所有班级指定科目总成绩和平均成绩
    public static void queryAllScoreByCourse(String cname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT class.cname,SUM(score),AVG(score) FROM score,class WHERE class.sid=score.sid AND class.cname=? GROUP BY class.cname;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cname1 = rs.getString(1);
                int sum = rs.getInt(2);
                double avg = rs.getDouble(3);
                System.out.println(cname1 + "该科目总成绩为" + sum + "\n平均成绩为" + avg);
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//查看指定班级指定科目成绩信息
    public static void queryScoreByClassAndCourse(String coursename,String classname) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT class.cname,SUM(score),AVG(score) FROM score,course,class WHERE class.sid=score.sid AND course.cid=score.cid AND course.cname=? AND class.cname=? GROUP BY class.cname;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, coursename);
            stmt.setString(2, classname);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cname1 = rs.getString(1);
                int sum = rs.getInt(2);
                double avg = rs.getDouble(3);
                System.out.println(cname1 + "该科目总成绩为" + sum + "\n平均成绩为" + avg);
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.closeConnection(conn, stmt, rs);
        }

    }

//    获取当前登录学生所在班级名称
    public static String getClassByStudent(int sid) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String cname = null;
        try {
            String sql = "SELECT class.cname FROM student,class WHERE student.sid=? AND student.sid=class.sid;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
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

//    获取当前登录学生姓名
    public static String getStudentNameByStudent(int sid) {
        conn = DBUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sname = null;
        try {
            String sql = "SELECT sname FROM student WHERE sid=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                sname = rs.getString(1);
            }
            return sname;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(conn, stmt, rs);
        }
    }
}

