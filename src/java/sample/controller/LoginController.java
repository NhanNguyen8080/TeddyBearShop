/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";
    private static final String USER_PAGE = "user.jsp";
    private static final String ERROR_PAGE = "error.jsp";
    private static final String LIST_USERS_CONTROLLER = "ListUsersController";
    private static final String LIST_PRODUCTS_CONTROLLER = "ListProductsInUserController";

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = LOGIN_PAGE;
        HttpSession session = request.getSession();
        try {
            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkLogin(username, password);
            if (user != null) {
                session.setAttribute("USER_LOGIN", user);
                if (user.getRole().equals("admin")) {
                    url = LIST_USERS_CONTROLLER;
                } else if (user.getRole().equals("user")) {
                    url = LIST_PRODUCTS_CONTROLLER;
                    session.setAttribute("USERNAME", user.getUsername());
                } else {
                    request.setAttribute("ERROR_MESSAGE", "ERROR!!!");
                }
            } else {
                request.setAttribute("INVALID_USER", "Invalid username or password");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
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
