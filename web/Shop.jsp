<%-- 
    Document   : Shop
    Created on : Nov 19, 2020, 3:12:08 PM
    Author     : black
--%>


<%@page import="Model.OrderTable"%>
<%@page import="Model.Orders"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="Shop" class="Model.Orders" scope="request"/>
    <%
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Orders> empList = OrderTable.findAllOrder(em);
        Iterator<Orders> itr = empList.iterator();
     %>
     <body>
        <center>
            <h1>Cart shop</h1>
           
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>DVD Name</th>
                    <th>Rate</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th> Remove </th>
                    </tr>
                    <%
                        while(itr.hasNext()) {
                            Shop = itr.next();
                            out.println("<tr>");
                            out.println("<td> "+ Shop.getId() + "</td>");
                            out.println("<td> "+ Shop.getDvdName()+ "</td>");
                            out.println("<td> "+ Shop.getRate() + "</td>");
                            out.println("<td> "+ Shop.getYears() + "</td>");
                            out.println("<td> "+ Shop.getPrice() + "</td>");
                            out.println("<td> "+ Shop.getQuantity() + "</td>");
                            out.println("<tr>");
                        }
                    %>
            </table>
                     <button class="btn btn-primary" type="button"><a href="DVDcat.jsp">Back to home</a></button>
        </center>
       
    </body>
</html>
