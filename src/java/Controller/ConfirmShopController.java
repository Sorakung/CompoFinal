/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DVDTable;
import Model.Dvdcatalog;
import Model.OrderTable;
import Model.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author black
 */
public class ConfirmShopController extends HttpServlet {

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
        HttpSession session = request.getSession();
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        if (request.getParameter("confirm") != null ) {
            Enumeration<String> attributes = request.getSession().getAttributeNames();
            while (attributes.hasMoreElements()) {
                String attribute = (String) attributes.nextElement();
                if(!(attribute.equals("WELD_S_HASH") || attribute.equals("entitymanager"))) {
                    Dvdcatalog product_item = (Dvdcatalog) request.getSession().getAttribute(attribute);
                    Orders item = new Orders();
                    item.setId(product_item.getId());
                    item.setDvdName(product_item.getDvdname());
                    item.setRate(product_item.getRate());
                    item.setYears(product_item.getYyear());
                    item.setQuantity(product_item.getQuantity());
                    item.setPrice(product_item.getPrice());
                    OrderTable.insertOrders(em, item);
                }}
        }
        if (request.getParameter("cancel") != null )
            request.getRequestDispatcher("DVDcat.jsp").forward(request, response);
        request.getRequestDispatcher("Shopresult.jsp").forward(request, response);
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
