/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sample.teddybear.TeddyBearDAO;
import sample.teddybear.TeddyBearDTO;

/**
 *
 * @author ADMIN
 */
public class UpdateProductController extends HttpServlet {

    private static final String ERROR_PAGE = "error.jsp";
    private static final String LIST_PRODUCTS_CONTROLLER = "ListProductsController";

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
        
        String url = ERROR_PAGE;
        String bearID = request.getParameter("bearID");
        String bearName = request.getParameter("bearName");
        String bearImg = request.getParameter("bearImg");
        String description = request.getParameter("description");
        String origin = request.getParameter("origin");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        
        try {
            double price = Double.parseDouble(price_raw);
            int quantity = Integer.parseInt(quantity_raw);
            TeddyBearDTO bear = new TeddyBearDTO(bearID, bearName, bearImg, description, price, quantity);
            TeddyBearDAO dao = new TeddyBearDAO();
            boolean checkUpdate = dao.updateProduct(bear);
            if (checkUpdate) {
                url = LIST_PRODUCTS_CONTROLLER;
            } else {
                request.setAttribute("ERROR_MESSAGE", "Update product failed!");
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
