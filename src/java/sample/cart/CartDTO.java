/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

/**
 *
 * @author ADMIN
 */
public class CartDTO {
    private String username;
    private String bearID;
    private String bearName;
    private String bearImg;
    private String description;
    private double price;
    private int quantity;

    public CartDTO() {
    }

    
    public CartDTO(String username, String bearID, String bearName, String bearImg, String description, double price, int quantity) {
        this.username = username;
        this.bearID = bearID;
        this.bearName = bearName;
        this.bearImg = bearImg;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBearID() {
        return bearID;
    }

    public void setBearID(String bearID) {
        this.bearID = bearID;
    }

    public String getBearName() {
        return bearName;
    }

    public void setBearName(String bearName) {
        this.bearName = bearName;
    }

    public String getBearImg() {
        return bearImg;
    }

    public void setBearImg(String bearImg) {
        this.bearImg = bearImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
