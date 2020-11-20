/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DVDTable;
import Model.Dvdcatalog;
import Model.OrderTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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
public class OrderController extends HttpServlet {

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
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if(!paramName.equals("submit")) {
                int Qty = Integer.parseInt(request.getParameterValues(paramName)[0]);
                int id = Integer.parseInt(paramName);
                Dvdcatalog emp = DVDTable.findDvdcatalogById(em, id);
                Dvdcatalog order_item = new Dvdcatalog();
                order_item.setId(emp.getId());
                order_item.setDvdname(emp.getDvdname());
                order_item.setYyear(emp.getYyear());
                order_item.setRate(emp.getRate());
                order_item.setQuantity(Qty);
                order_item.setPrice(emp.getPrice() * Qty);
                //OrderTable.insertOrders(em, order_item);
                if (Qty > 0) {
                    session.setAttribute(paramName, order_item);
                }
                request.getRequestDispatcher("ConfirmShop.jsp").forward(request, response);
            }
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
