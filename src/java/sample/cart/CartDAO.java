/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

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
public class CartDAO {

    public boolean deleteProduct(String username, String bearID)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "DELETE FROM [dbo].[tblCart] "
                        + "WHERE [username] = ? and [bearID] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, bearID);
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

    public List<CartDTO> getCartList(String username) throws SQLException, ClassNotFoundException {
        List<CartDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "SELECT [username], [bearID], [bearName], [bearImg]"
                        + ", [description], [price], [quantity] "
                        + "FROM [dbo].[tblCart] "
                        + "WHERE [username] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    username = rs.getString("username");
                    String bearID = rs.getString("bearID");
                    String bearName = rs.getString("bearName");
                    String bearImg = rs.getString("bearImg");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    CartDTO cart = new CartDTO(username, bearID, bearName, bearImg, description, price, quantity);
                    list.add(cart);
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

    public CartDTO getACart(String username, String bearID)
            throws SQLException, ClassNotFoundException {
        CartDTO cart = new CartDTO();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                String sql = "SELECT [username], [bearID], [bearName], [bearImg]"
                        + ", [description], [price], [quantity] "
                        + "FROM [dbo].[tblCart] "
                        + "WHERE [username] = ? AND [bearID] = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, bearID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    username = rs.getString("username");
                    bearID = rs.getString("bearID");
                    String bearName = rs.getString("bearName");
                    String bearImg = rs.getString("bearImg");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    cart = new CartDTO(username, bearID, bearName, bearImg, description, price, quantity);
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
        return cart;
    }

    public boolean addToCart(CartDTO cart)
            throws SQLException, ClassNotFoundException {
        CartDTO getACartByUserName = getACart(cart.getUsername(), cart.getBearID());
        Connection con = null;
        Statement stm = null;
        PreparedStatement preStm = null;
        con = DBUtils.makeConnection();
        try {
            if (con != null) {
                if (getACartByUserName.getQuantity() >= 1) {
                    String sql = "Update [dbo].[tblCart] "
                            + "SET [quantity] += 1";
                    stm = con.createStatement();
                    int row = stm.executeUpdate(sql);
                    if (row > 0) {
                        return true;
                    }
                } else {
                    String sql = "INSERT INTO [dbo].[tblCart]\n"
                            + "           ([username]\n"
                            + "           ,[bearID]\n"
                            + "           ,[bearName]\n"
                            + "           ,[bearImg]\n"
                            + "           ,[description]\n"
                            + "           ,[price]\n"
                            + "           ,[quantity])\n"
                            + "     VALUES\n"
                            + "           (?, ?, ?, ?, ?, ?, ?)";
                    preStm = con.prepareStatement(sql);
                    preStm.setString(1, cart.getUsername());
                    preStm.setString(2, cart.getBearID());
                    preStm.setString(3, cart.getBearName());
                    preStm.setString(4, cart.getBearImg());
                    preStm.setString(5, cart.getDescription());
                    preStm.setDouble(6, cart.getPrice());
                    preStm.setInt(7, cart.getQuantity());
                    int row = preStm.executeUpdate();
                    if (row > 0) {
                        return true;
                    }
                }
            }
        } finally {
            if (preStm != null) {
                preStm.close();
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
}
