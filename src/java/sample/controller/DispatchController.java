/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class DispatchController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String REGISTER_CONTROLLER = "RegisterController";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String DELETE_CONTROLLER = "DeleteController";
    private static final String SEARCH_USERS_CONTROLLER = "SearchUserController";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String ADD_PRODUCT_CONTROLLER = "AddProductController";
    private static final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController";
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    private static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";
    private static final String SEARCH_PRODUCT_IN_USER_CONTROLLER = "SearchProductInUser";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    private static final String DELETE_CART_CONTROLLER = "DeleteCartController";
    private static final String INFO_PAGE = "info.jsp";
    private static final String PURCHASE_CONTROLLER = "PurchaseController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        String action = request.getParameter("action");
        try {
            if (action == null) {

            } else if (action.equals("Log in")) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals("Sign up")) {
                url = REGISTER_CONTROLLER;
            } else if (action.equals("Update")) {
                url = UPDATE_CONTROLLER;
            } else if (action.equals("Delete")) {
                url = DELETE_CONTROLLER;
            } else if (action.equals("Search")) {
                url = SEARCH_USERS_CONTROLLER;
            } else if (action.equals("Log out")) {
                url = LOGOUT_CONTROLLER;
            } else if (action.equals("Add")) {
                url = ADD_PRODUCT_CONTROLLER;
            } else if (action.equals("DeleteProduct")) {
                url = DELETE_PRODUCT_CONTROLLER;
            } else if (action.equals("UPDATE")) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (action.equals("SEARCH")) {
                url = SEARCH_PRODUCT_CONTROLLER;
            } else if (action.equals("Find")) {
                url = SEARCH_PRODUCT_IN_USER_CONTROLLER;
            } else if (action.equals("ADD TO CART")) {
                url = ADD_TO_CART_CONTROLLER;
            } else if (action.equals("DeleteCart")) {
                url = DELETE_CART_CONTROLLER;
            } else if (action.equals("Order")) {
                url = INFO_PAGE;
            } else if (action.equals("Purchase")) {
                url = PURCHASE_CONTROLLER;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
