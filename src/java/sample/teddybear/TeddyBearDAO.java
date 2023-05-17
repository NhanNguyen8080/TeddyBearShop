/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.teddybear;

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
public class TeddyBearDAO implements Serializable {

    public boolean updateProduct(TeddyBearDTO bear)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "UPDATE [dbo].[TeddyBear]\n"
                        + "   SET [bearID] = ? "
                        + "      ,[bearName] = ? "
                        + "      ,[bearImg] = ? "
                        + "      ,[description] = ? "
                        + "      ,[price] = ? "
                        + "      ,[quantity] = ? "
                        + " WHERE [bearID] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, bear.getBearID());
                stm.setString(2, bear.getBearName());
                stm.setString(3, bear.getBearImg());
                stm.setString(4, bear.getDescription());
                stm.setDouble(5, bear.getPrice());
                stm.setInt(6, bear.getQuantity());
                stm.setString(7, bear.getBearID());

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

    public boolean deleteProduct(String bearID)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "DELETE FROM [dbo].[TeddyBear] "
                        + "WHERE [bearID] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, bearID);
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

    public boolean addAProduct(TeddyBearDTO bear)
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "INSERT INTO [dbo].[TeddyBear] ([bearID], [bearName],"
                        + "[bearImg], [description], [price], [quantity]) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, bear.getBearID());
                stm.setString(2, bear.getBearName());
                stm.setString(3, bear.getBearImg());
                stm.setString(4, bear.getDescription());
                stm.setDouble(5, bear.getPrice());
                stm.setInt(6, bear.getQuantity());
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

    public boolean checkDuplicate(String bearID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "SELECT [bearID]\n"
                        + "      ,[bearName]\n"
                        + "      ,[bearImg]\n"
                        + "      ,[description]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "  FROM [dbo].[TeddyBear]"
                        + "WHERE [bearID] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, bearID);
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

    public List<TeddyBearDTO> getBearList() throws SQLException, ClassNotFoundException {
        List<TeddyBearDTO> list = new ArrayList<>();
        Connection con = null;
        Statement stm = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {

                String sql = "SELECT [bearID]\n"
                        + "      ,[bearName]\n"
                        + "      ,[bearImg]\n"
                        + "      ,[description]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "  FROM [dbo].[TeddyBear]";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String bearID = rs.getString("bearID");
                    String bearName = rs.getString("bearName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String bearImg = rs.getString("bearImg");
                    TeddyBearDTO bear = new TeddyBearDTO(bearID, bearName, bearImg, description, price, quantity);
                    list.add(bear);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
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

    public List<TeddyBearDTO> getBearList(String bearID) throws SQLException, ClassNotFoundException {
        List<TeddyBearDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "SELECT [bearID]\n"
                        + "      ,[bearName]\n"
                        + "      ,[bearImg]\n"
                        + "      ,[description]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "  FROM [dbo].[TeddyBear]"
                        + "WHERE [bearID] like ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, "%" + bearID + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String bearName = rs.getString("bearName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String bearImg = rs.getString("bearImg");
                    TeddyBearDTO bear = new TeddyBearDTO(bearID, bearName, bearImg, description, price, quantity);
                    list.add(bear);
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

    public List<TeddyBearDTO> getBearListByName(String bearName) throws SQLException, ClassNotFoundException {
        List<TeddyBearDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "SELECT [bearID]\n"
                        + "      ,[bearName]\n"
                        + "      ,[bearImg]\n"
                        + "      ,[description]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "  FROM [dbo].[TeddyBear]"
                        + "WHERE [bearName] like ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, "%" + bearName + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    String bearID = rs.getString("bearID");
                    bearName = rs.getString("bearName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String bearImg = rs.getString("bearImg");
                    TeddyBearDTO bear = new TeddyBearDTO(bearID, bearName, bearImg, description, price, quantity);
                    list.add(bear);
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
}
