<%-- 
    Document   : Shopresult
    Created on : Nov 20, 2020, 9:39:48 PM
    Author     : black
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.Orders"%>
<%@page import="Model.OrderTable"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="ord" class="Model.Orders" scope="request"/>
    <%
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Orders> empList = OrderTable.findAllOrder(em);
        Iterator<Orders> itr = empList.iterator();
     %>
    <body>
        <center>
                <br>
                <h1>BILL</h1>
                <%
                    out.println("<h5>Total Amount: "+ ord.getPrice() + "</h5>");
                %>
            <button class="btn btn-primary" type="button"><a href="DVDcat.jsp">Back to home</a></button>
        </center>
    </body>
</html>
