package service;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author：邾头肉
 * @date：2024/3/9
 */
public class ServiceForManager {
    static Connection conn = null;
//    登录
    public static int login(String maccount,String mpassword)
    {
        int flag = 0;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from manager where mid=? and mpass=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,maccount);
            ps.setString(2,mpassword);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                flag = 1;
            } else {
                flag = 0;
            }
            DBUtil.closeConnection(conn,ps,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
