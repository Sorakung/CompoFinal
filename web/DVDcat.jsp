<%-- 
    Document   : DVDcat
    Created on : Nov 19, 2020, 2:37:45 PM
    Author     : black
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.DVDTable"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.Dvdcatalog"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="emp" class="Model.Dvdcatalog" scope="request"/>
    <%
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Dvdcatalog> empList = DVDTable.findAllDvdcatalog(em);
        Iterator<Dvdcatalog> itr = empList.iterator();
     %>
     <body>
        <center>
            <form name="addCart" action="OrderController" method="POST" id="form">
            <h1>DVD Catalog</h1>
           
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>DVD Name</th>
                    <th>Rate</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th> Add to cart</th>
                    </tr>
                    <%
                        while(itr.hasNext()) {
                            emp = itr.next();
                            out.println("<tr>");
                            out.println("<td> "+ emp.getId() + "</td>");
                            out.println("<td> "+ emp.getDvdname()+ "</td>");
                            out.println("<td> "+ emp.getRate() + "</td>");
                            out.println("<td> "+ emp.getYyear() + "</td>");
                            out.println("<td> "+ emp.getPrice() + "</td>");
                            out.println("<td> "+ emp.getQuantity() + "</td>");
                            out.println("<td><input type='number' value='0' name='" + emp.getId() + "' min='0' max=" + emp.getQuantity() + "></td>");
                            out.println("<tr>");
                        }
                    %>
                    
            </table>
               
            </form>
                    <button class="btn btn-primary" type="submit" name="submit" value="Submit" form="form">Check Out</button>
        </center>
                    <br>
            <button class="btn btn-secondary" type="button" name="history" value="History"><a href="Shop.jsp">Order History</a></button>
       
    </body>
    
</html>
