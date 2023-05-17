/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class UserDAO implements Serializable {

    public boolean deleteAnUser(String username)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "DELETE FROM [dbo].[tblUser]"
                        + "WHERE [username] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateAnUser(String username, String role) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "UPDATE [dbo].[tblUser]"
                        + "SET [role] = ? "
                        + "WHERE [username] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, role);
                stm.setString(2, username);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public List<UserDTO> getListUser(String username)
            throws ClassNotFoundException, SQLException {
        List<UserDTO> list = new ArrayList();
        Connection con = null;
        Statement stm = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT [username], [fullname], [email], [role] "
                        + "FROM [dbo].[tblUser]"
                        + "WHERE username like ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, "%" + username + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    username = rs.getString("username");
                    String password = "******";
                    String fullname = rs.getString("fullname");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    UserDTO user = new UserDTO(username, password, fullname, email, role);
                    list.add(user);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (preStm != null) {
                preStm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<UserDTO> getListUser()
            throws ClassNotFoundException, SQLException {
        List<UserDTO> list = new ArrayList();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT [username], [fullname], [email], [role] "
                        + "FROM [dbo].[tblUser]";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = "******";
                    String fullname = rs.getString("fullname");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    UserDTO user = new UserDTO(username, password, fullname, email, role);
                    list.add(user);
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean createNewUser(String username, String password, String fullname, String email)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                if (!checkDuplicate(username, email)) {
                    String sql = "INSERT INTO [dbo].[User] ([username], [password], [fullname], [email], [role]) "
                            + "VALUES(?, ?, ?, ?, ?) ";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, username);
                    stm.setString(2, password);
                    stm.setString(3, fullname);
                    stm.setString(4, email);
                    stm.setString(5, "user");

                    int row = stm.executeUpdate();
                    if (row > 0) {
                        return true;
                    }
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean checkDuplicate(String username, String email) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT [username] "
                        + "FROM [dbo].[User] "
                        + "WHERE[username] = ? OR [email] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public UserDTO checkLogin(String username, String password)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO user = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT [username], [password], [fullname], [email], [role] "
                        + "FROM [dbo].[tblUser] "
                        + "WHERE[username] = ? and [password] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    user = new UserDTO(username, password, fullname, email, role);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return user;
    }
}
